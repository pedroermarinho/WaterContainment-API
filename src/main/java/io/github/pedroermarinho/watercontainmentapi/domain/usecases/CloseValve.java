package io.github.pedroermarinho.watercontainmentapi.domain.usecases;

import io.github.pedroermarinho.watercontainmentapi.data.config.MqttConnection;
import org.eclipse.paho.client.mqttv3.MqttException;
import org.springframework.stereotype.Service;

@Service
public class CloseValve {

    private final MqttConnection mqttConnection;

    public CloseValve(MqttConnection mqttConnection) {
        this.mqttConnection = mqttConnection;
    }

    public void close() {
        try {
            mqttConnection.publish("ALARMES", "on");
        } catch (MqttException e) {
            throw new RuntimeException(e);
        }
    }
}
