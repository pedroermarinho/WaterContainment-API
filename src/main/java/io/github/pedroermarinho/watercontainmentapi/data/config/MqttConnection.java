package io.github.pedroermarinho.watercontainmentapi.data.config;

import com.fasterxml.jackson.databind.ObjectMapper;
import io.github.pedroermarinho.watercontainmentapi.domain.dtos.NewSensorDTO;
import io.github.pedroermarinho.watercontainmentapi.domain.usecases.SensorRegister;
import org.eclipse.paho.client.mqttv3.*;
import org.eclipse.paho.client.mqttv3.persist.MemoryPersistence;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class MqttConnection implements MqttCallback {

    private final SensorRegister registerSensor;

    public MqttConnection(SensorRegister registerSensor) {
        this.registerSensor = registerSensor;
    }

    @Value("${host.mqtt.clientId:WaterContainment-Middleware}")
    private String clientId;

    @Value("${host.mqtt.qos:0}")
    private int qos;

    @Value("${host.mqtt.topic:SENSORES}")
    private String topic;

    @Value("${host.mqtt.mqttHost}")
    private String mqttHost;

    @Value("${host.mqtt.mqttUser}")
    private String mqttUser;

    @Value("${host.mqtt.mqttPassword}")
    private String mqttPassword;

    private MqttClient client;
    private MqttConnectOptions options;


    public void connect() throws MqttException {

        client  = new MqttClient(mqttHost, clientId, new MemoryPersistence());

        options = new MqttConnectOptions();

        options.setUserName(mqttUser);
        options.setPassword(mqttPassword.toCharArray());

        client.setCallback(this);
        client.connect(options);
        client.subscribe(topic, qos);

    }

    @Override
    public void connectionLost(Throwable throwable) {
        try {
            connect();
        } catch (MqttException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void messageArrived(String s, MqttMessage mqttMessage) throws Exception {
        System.out.println("Message arrived: " + mqttMessage.toString());
        final var mapper = new ObjectMapper();
        final NewSensorDTO newSensorDTO = mapper.readValue(mqttMessage.toString(), NewSensorDTO.class);
        registerSensor.save(newSensorDTO);
    }

    @Override
    public void deliveryComplete(IMqttDeliveryToken iMqttDeliveryToken) {
    }

    public void publish(String topic, String message) throws MqttException {
        client.publish(topic, message.getBytes(), 1, false);
    }
}
