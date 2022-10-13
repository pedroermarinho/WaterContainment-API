package io.github.pedroermarinho.watercontainmentapi.data.controllers;

import io.github.pedroermarinho.watercontainmentapi.data.config.PathRest;
import io.github.pedroermarinho.watercontainmentapi.domain.dtos.NewSensorDTO;
import io.github.pedroermarinho.watercontainmentapi.domain.dtos.SensorDTO;
import io.github.pedroermarinho.watercontainmentapi.domain.entities.SensorEntity;
import io.github.pedroermarinho.watercontainmentapi.domain.usecases.RegisterSensor;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;

@RestController
@RequestMapping(value = PathRest.API + PathRest.VERSION + PathRest.SENSOR)
@CrossOrigin(origins = "*")
public class RegisterSensorController {

    private final RegisterSensor registerSensor;

    public RegisterSensorController(RegisterSensor registerSensor) {
        this.registerSensor = registerSensor;
    }

    @Operation(summary = "Cadastrar um novo sensor")
    @PostMapping
    public ResponseEntity<SensorEntity> registerSensor(@RequestBody @Valid NewSensorDTO newSensorDTO) {
        SensorEntity sensor = registerSensor.save(newSensorDTO);
        URI uri = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(sensor.getId()).toUri();
        return ResponseEntity.created(uri).body(sensor);
    }


}
