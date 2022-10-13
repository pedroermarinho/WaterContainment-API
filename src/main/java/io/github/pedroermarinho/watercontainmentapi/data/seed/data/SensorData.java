package io.github.pedroermarinho.watercontainmentapi.data.seed.data;

import io.github.pedroermarinho.watercontainmentapi.data.seed.DataSeed;
import io.github.pedroermarinho.watercontainmentapi.domain.dtos.NewSensorDTO;
import io.github.pedroermarinho.watercontainmentapi.domain.usecases.RegisterSensor;

import java.util.List;

public class SensorData implements DataSeed {

    private final RegisterSensor registerSensor;

    public SensorData(RegisterSensor registerSensor) {
        this.registerSensor = registerSensor;
    }

    @Override
    public void create() {
        final List<NewSensorDTO> newSensorDTOs = List.of(
                new NewSensorDTO(26.3, 500.0, 15.0, 28.0),
                new NewSensorDTO(29.3, 448.0, 14.8, 27.8),
                new NewSensorDTO(24.3, 449.0, 15.1, 28.0),
                new NewSensorDTO(26.3, 530.0, 14.8, 28.9)
        );

        newSensorDTOs.forEach(registerSensor::save);
    }
}
