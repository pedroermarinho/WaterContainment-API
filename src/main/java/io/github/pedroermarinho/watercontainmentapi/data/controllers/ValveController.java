package io.github.pedroermarinho.watercontainmentapi.data.controllers;

import io.github.pedroermarinho.watercontainmentapi.data.config.PathRest;
import io.github.pedroermarinho.watercontainmentapi.domain.usecases.CloseValve;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = PathRest.API + PathRest.VERSION + PathRest.LED)
@CrossOrigin(origins = "*")
public class ValveController{

    private final CloseValve closeValve;

    public ValveController(CloseValve closeValve) {
        this.closeValve = closeValve;
    }

    @Operation(summary = "Fechar a válvula")
    @PatchMapping(value = "/close-valve")
    public ResponseEntity<Void> closeValve() {
        closeValve.close();
        return ResponseEntity.ok().build();
    }

}
