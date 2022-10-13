package io.github.pedroermarinho.watercontainmentapi.domain.repositories;

import io.github.pedroermarinho.watercontainmentapi.domain.dtos.NewSensorDTO;
import io.github.pedroermarinho.watercontainmentapi.domain.dtos.SensorDTO;
import io.github.pedroermarinho.watercontainmentapi.domain.entities.SensorEntity;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface SensorRepository {
    List<SensorDTO> findAll();

    Optional<SensorDTO> findById(Long id);

    SensorEntity save(NewSensorDTO newSensorDTO);
}
