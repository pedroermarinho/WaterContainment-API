package io.github.pedroermarinho.watercontainmentapi;

import io.github.pedroermarinho.watercontainmentapi.domain.usecases.SensorRegister;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class WaterContainmentApiApplication {

    private final SensorRegister register;

    public WaterContainmentApiApplication(SensorRegister register) {
        this.register = register;
    }

    public static void main(String[] args) {
        SpringApplication.run(WaterContainmentApiApplication.class, args);
    }

}
