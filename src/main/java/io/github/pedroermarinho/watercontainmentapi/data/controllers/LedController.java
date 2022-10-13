package io.github.pedroermarinho.watercontainmentapi.data.controllers;

import io.github.pedroermarinho.watercontainmentapi.data.config.PathRest;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = PathRest.API + PathRest.VERSION + PathRest.LED)
@CrossOrigin(origins = "*")
public class LedController {

    @Operation(summary = "Ligar led 1")
    @PatchMapping(value = "/on")
    public ResponseEntity<Void> onLed() {
        return ResponseEntity.ok().build();
    }


    @Operation(summary = "Ligar led 1")
    @PatchMapping(value = "/off")
    public ResponseEntity<Void> offLed() {
        return ResponseEntity.ok().build();
    }

}
