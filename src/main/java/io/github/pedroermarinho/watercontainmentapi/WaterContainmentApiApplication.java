package io.github.pedroermarinho.watercontainmentapi;

import io.github.pedroermarinho.watercontainmentapi.domain.usecases.RegisterSensor;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class WaterContainmentApiApplication {

    private final RegisterSensor register;

    public WaterContainmentApiApplication(RegisterSensor register) {
        this.register = register;
    }

    public static void main(String[] args) {
        SpringApplication.run(WaterContainmentApiApplication.class, args);
    }

}
