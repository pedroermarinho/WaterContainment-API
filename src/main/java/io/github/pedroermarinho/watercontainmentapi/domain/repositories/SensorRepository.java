package io.github.pedroermarinho.watercontainmentapi.domain.repositories;

import io.github.pedroermarinho.watercontainmentapi.domain.dtos.NewSensorDTO;
import io.github.pedroermarinho.watercontainmentapi.domain.dtos.SensorDTO;
import io.github.pedroermarinho.watercontainmentapi.domain.entities.SensorEntity;
import io.github.pedroermarinho.watercontainmentapi.domain.views.*;

import java.util.List;
import java.util.Optional;

public interface SensorRepository {
    List<SensorDTO> findAll();

    Optional<SensorDTO> findById(Long id);

    SensorEntity save(NewSensorDTO newSensorDTO);

    List<HourAndMinuteView> findAvgLitrosMinByHourAndMinute();

    List<HourView> findAvgLitrosMinByHour();

    List<DayOfWeekView> findAvgLitrosMinByDayOfWeek();

    List<DayOFMonthView> findAvgLitrosMinByDayOfMonth();

    List<MonthView> findAvgLitrosMinByMonth();

    List<YearView> findAvgLitrosMinByYear();
}
