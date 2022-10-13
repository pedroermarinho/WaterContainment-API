package io.github.pedroermarinho.watercontainmentapi.data.controllers;

import io.github.pedroermarinho.watercontainmentapi.data.config.PathRest;
import io.github.pedroermarinho.watercontainmentapi.domain.dtos.SensorDTO;
import io.github.pedroermarinho.watercontainmentapi.domain.usecases.SensorSearch;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.UUID;

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
    @ApiResponses(value = {
            @ApiResponse(
                    responseCode = "200", description = "Operação bem sucedida",
                    content = @Content(array = @ArraySchema(schema = @Schema(implementation = SensorDTO.class)))
            )
    })
    @GetMapping
    public ResponseEntity<List<SensorDTO>> searchCommandAll() {
        final List<SensorDTO> sensors = sensorSearch.searchSensorAll();
        return ResponseEntity.ok().body(sensors);
    }

    @Operation(summary = "Buscar dados de sensores por id")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "404", description = "Comanda não encontrado"),
            @ApiResponse(
                    responseCode = "200", description = "Operação bem sucedida",
                    content = @Content(schema = @Schema(implementation = SensorDTO.class))
            )
    })
    @GetMapping("/{id}")
    public ResponseEntity<SensorDTO> searchCommandById(@PathVariable Long id) {
        final SensorDTO sensor = sensorSearch.searchSensorById(id);
        return ResponseEntity.ok().body(sensor);
    }
}
