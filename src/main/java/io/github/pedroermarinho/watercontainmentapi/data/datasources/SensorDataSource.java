package io.github.pedroermarinho.watercontainmentapi.data.datasources;

import io.github.pedroermarinho.watercontainmentapi.domain.entities.SensorEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface SensorDataSource extends JpaRepository<SensorEntity, Long> {

    List<SensorEntity> findTop200ByOrderByCreatedAtDesc();
}
