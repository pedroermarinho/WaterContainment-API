package io.github.pedroermarinho.watercontainmentapi.data.controllers;

import io.github.pedroermarinho.watercontainmentapi.data.config.PathRest;
import io.github.pedroermarinho.watercontainmentapi.domain.dtos.SensorDTO;
import io.github.pedroermarinho.watercontainmentapi.domain.usecases.SensorSearch;
import io.github.pedroermarinho.watercontainmentapi.domain.views.*;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = PathRest.API + PathRest.VERSION + PathRest.SENSOR)
@Tag(name = "Sensor", description = "Operações do sensores")
@CrossOrigin(origins = "*")
public class SearchSensorController {
    private final SensorSearch sensorSearch;

    public SearchSensorController(SensorSearch sensorSearch) {
        this.sensorSearch = sensorSearch;
    }

    @Operation(summary = "Lista de dados dos sensores")
    @GetMapping
    public ResponseEntity<List<SensorDTO>> searchCommandAll() {
        final List<SensorDTO> sensors = sensorSearch.searchSensorAll();
        return ResponseEntity.ok().body(sensors);
    }

    @Operation(summary = "Buscar dados de sensores por id")
    @GetMapping("/{id}")
    public ResponseEntity<SensorDTO> searchCommandById(@PathVariable Long id) {
        final SensorDTO sensor = sensorSearch.searchSensorById(id);
        return ResponseEntity.ok().body(sensor);
    }

    @Operation(summary = "Buscar dados de sensores por hora e minuto")
    @GetMapping("/hourAndMinute")
    public ResponseEntity<List<HourAndMinuteView>> searchCommandByHourAndMinute() {
        final List<HourAndMinuteView> sensor = sensorSearch.findAvgLitrosMinByHourAndMinute();
        return ResponseEntity.ok().body(sensor);
    }

    @Operation(summary = "Buscar dados de sensores por hora")
    @GetMapping("/hour")
    public ResponseEntity<List<HourView>> searchCommandByHour() {
        final List<HourView> sensor = sensorSearch.findAvgLitrosMinByHour();
        return ResponseEntity.ok().body(sensor);
    }

    @Operation(summary = "Buscar dados de sensores por dia da semana")
    @GetMapping("/dayOfWeek")
    public ResponseEntity<List<DayOfWeekView>> searchCommandByDayOfWeek() {
        final List<DayOfWeekView> sensor = sensorSearch.findAvgLitrosMinByDayOfWeek();
        return ResponseEntity.ok().body(sensor);
    }

    @Operation(summary = "Buscar dados de sensores por dia do mês")
    @GetMapping("/dayOfMonth")
    public ResponseEntity<List<DayOFMonthView>> searchCommandByDayOfMonth() {
        final List<DayOFMonthView> sensor = sensorSearch.findAvgLitrosMinByDayOfMonth();
        return ResponseEntity.ok().body(sensor);
    }

    @Operation(summary = "Buscar dados de sensores por mês")
    @GetMapping("/month")
    public ResponseEntity<List<MonthView>> searchCommandByMonth() {
        final List<MonthView> sensor = sensorSearch.findAvgLitrosMinByMonth();
        return ResponseEntity.ok().body(sensor);
    }

    @Operation(summary = "Buscar dados de sensores por ano")
    @GetMapping("/year")
    public ResponseEntity<List<YearView>> searchCommandByYear() {
        final List<YearView> sensor = sensorSearch.findAvgLitrosMinByYear();
        return ResponseEntity.ok().body(sensor);
    }
}
