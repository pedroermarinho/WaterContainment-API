package io.github.pedroermarinho.watercontainmentapi.domain.dtos;

import io.github.pedroermarinho.watercontainmentapi.domain.entities.SensorEntity;

public record NewSensorDTO(
        Double litrosMin
) {
    public NewSensorDTO(Double litrosMin) {
        this.litrosMin = litrosMin;
    }

    public NewSensorDTO(SensorEntity entity) {

        this(
                entity.getLitrosMin()
        );
    }

    public SensorEntity toEntity() {
        final SensorEntity entity = new SensorEntity();
        entity.setLitrosMin(this.litrosMin);
        return entity;
    }
}
