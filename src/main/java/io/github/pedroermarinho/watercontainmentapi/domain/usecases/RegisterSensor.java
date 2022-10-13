package io.github.pedroermarinho.watercontainmentapi.domain.usecases;

import io.github.pedroermarinho.watercontainmentapi.domain.dtos.NewSensorDTO;
import io.github.pedroermarinho.watercontainmentapi.domain.entities.SensorEntity;
import io.github.pedroermarinho.watercontainmentapi.domain.repositories.SensorRepository;
import org.springframework.stereotype.Service;

@Service
public class RegisterSensor {

    private final SensorRepository sensorRepository;

    public RegisterSensor(SensorRepository sensorRepository) {
        this.sensorRepository = sensorRepository;
    }

    public SensorEntity save(NewSensorDTO newSensorDTO) {
        return sensorRepository.save(newSensorDTO);
    }

}
