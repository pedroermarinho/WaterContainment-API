package io.github.pedroermarinho.watercontainmentapi.data.repositories;

import io.github.pedroermarinho.watercontainmentapi.data.datasources.SensorDataSource;
import io.github.pedroermarinho.watercontainmentapi.domain.dtos.NewSensorDTO;
import io.github.pedroermarinho.watercontainmentapi.domain.dtos.SensorDTO;
import io.github.pedroermarinho.watercontainmentapi.domain.entities.SensorEntity;
import io.github.pedroermarinho.watercontainmentapi.domain.repositories.SensorRepository;
import io.github.pedroermarinho.watercontainmentapi.domain.views.*;
import org.springframework.stereotype.Component;

import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

@Component
public class SensorRepositoryImpl implements SensorRepository {

    private final SensorDataSource sensorDataSource;

    public SensorRepositoryImpl(SensorDataSource sensorDataSource) {
        this.sensorDataSource = sensorDataSource;
    }

    @Override
    public List<SensorDTO> findAll() {
        final List<SensorEntity> sensorEntities = sensorDataSource.findTop20ByOrderByCreatedAtDesc();
        Collections.reverse(sensorEntities);
        return sensorEntities.stream().map(SensorDTO::new).toList();
    }

    @Override
    public Optional<SensorDTO> findById(Long id) {
        return sensorDataSource.findById(id).map(SensorDTO::new);
    }

    @Override
    public SensorEntity save(NewSensorDTO newSensorDTO) {
        return sensorDataSource.save(newSensorDTO.toEntity());
    }

    @Override
    public List<HourAndMinuteView> findAvgLitrosMinByHourAndMinute() {
        return sensorDataSource.findAvgLitrosMinByHourAndMinute();
    }

    @Override
    public List<HourView> findAvgLitrosMinByHour() {
        return sensorDataSource.findAvgLitrosMinByHour();
    }

    @Override
    public List<DayOfWeekView> findAvgLitrosMinByDayOfWeek() {
        return sensorDataSource.findAvgLitrosMinByDayOfWeek();
    }

    @Override
    public List<DayOFMonthView> findAvgLitrosMinByDayOfMonth() {
        return sensorDataSource.findAvgLitrosMinByDayOfMonth();
    }

    @Override
    public List<MonthView> findAvgLitrosMinByMonth() {
        return sensorDataSource.findAvgLitrosMinByMonth();
    }

    @Override
    public List<YearView> findAvgLitrosMinByYear() {
        return sensorDataSource.findAvgLitrosMinByYear();
    }

}
