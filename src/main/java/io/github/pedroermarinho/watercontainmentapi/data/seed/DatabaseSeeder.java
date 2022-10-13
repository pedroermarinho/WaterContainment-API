package io.github.pedroermarinho.watercontainmentapi.data.seed;

import io.github.pedroermarinho.watercontainmentapi.domain.usecases.SensorRegister;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class DatabaseSeeder implements CommandLineRunner {

    private final List<DataSeed> dataSeeds;

    public DatabaseSeeder(
            SensorRegister registerSensor
    ) {
        this.dataSeeds = List.of(
                // new SensorData(registerSensor)
        );
    }

    @Override
    public void run(String... args) throws Exception {
        dataSeeds.forEach(DataSeed::create);
    }
}
