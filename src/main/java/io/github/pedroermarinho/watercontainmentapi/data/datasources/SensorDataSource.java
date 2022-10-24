package io.github.pedroermarinho.watercontainmentapi.data.datasources;

import io.github.pedroermarinho.watercontainmentapi.domain.entities.SensorEntity;
import io.github.pedroermarinho.watercontainmentapi.domain.views.*;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SensorDataSource extends JpaRepository<SensorEntity, Long> {

    List<SensorEntity> findTop20ByOrderByCreatedAtDesc();

    @Query(value = "select extract(hour from created_at) as hour , extract(MINUTE from created_at) as minute, avg(litros_min) as LitrosMinAvg from sensor_entity group by hour, minute;", nativeQuery = true)
    List<HourAndMinuteView> findAvgLitrosMinByHourAndMinute();

    @Query(value = "select extract(hour from created_at) as hour, avg(litros_min) as LitrosMinAvg  from sensor_entity group by hour;", nativeQuery = true)
    List<HourView> findAvgLitrosMinByHour();

    @Query(value = "select extract(DOW from created_at) as dayOfWeek, avg(litros_min) as LitrosMinAvg from sensor_entity group by dayOfWeek;", nativeQuery = true)
    List<DayOfWeekView> findAvgLitrosMinByDayOfWeek();

    @Query(value = "select extract(DAY from created_at) as DayOfMonth, avg(litros_min) as LitrosMinAvg from sensor_entity group by DayOfMonth", nativeQuery = true)
    List<DayOFMonthView> findAvgLitrosMinByDayOfMonth();

    @Query(value = "select extract(MONTH from created_at) as month, avg(litros_min) as LitrosMinAvg from sensor_entity group by month;", nativeQuery = true)
    List<MonthView> findAvgLitrosMinByMonth();

    @Query(value = "select extract(YEAR from created_at) as year, avg(litros_min) as LitrosMinAvg from sensor_entity group by year;", nativeQuery = true)
    List<YearView> findAvgLitrosMinByYear();

}
