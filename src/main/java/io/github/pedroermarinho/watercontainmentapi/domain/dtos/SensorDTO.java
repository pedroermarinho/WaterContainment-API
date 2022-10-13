package io.github.pedroermarinho.watercontainmentapi.domain.dtos;

import java.time.LocalDateTime;

import io.github.pedroermarinho.watercontainmentapi.domain.entities.SensorEntity;

public record SensorDTO(
        Long id,

        Double litrosMin,

        LocalDateTime createdAt
) {

    public SensorDTO(SensorEntity entity) {
        this(entity.getId(), entity.getLitrosMin(),entity.getCreatedAt());
    }

    public SensorEntity toEntity() {
        final SensorEntity entity = new SensorEntity();
        entity.setId(this.id);
        entity.setLitrosMin(this.litrosMin);
        entity.setCreatedAt(this.createdAt);
        return entity;
    }
}
