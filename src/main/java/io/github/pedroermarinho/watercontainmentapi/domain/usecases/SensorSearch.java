package io.github.pedroermarinho.watercontainmentapi.domain.usecases;

import io.github.pedroermarinho.watercontainmentapi.domain.dtos.*;
import io.github.pedroermarinho.watercontainmentapi.domain.exceptions.ObjectNotFoundException;
import io.github.pedroermarinho.watercontainmentapi.domain.repositories.SensorRepository;
import io.github.pedroermarinho.watercontainmentapi.domain.views.*;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;

@Service
public class SensorSearch {
    private final SensorRepository sensorRepository;

    public SensorSearch(SensorRepository sensorRepository) {
        this.sensorRepository = sensorRepository;
    }


    public SensorDTO searchSensorById(Long id) {
        return sensorRepository.findById(id).orElseThrow(
                () -> new ObjectNotFoundException(
                        "Endereço não encontrado! Id: " + id + ", Tipo: " + SensorDTO.class.getName())
        );
    }

    public List<SensorDTO> searchSensorAll() {
        return sensorRepository.findAll();
    }

    public List<HourAndMinuteView> findAvgLitrosMinByHourAndMinute() {
        final List<HourAndMinuteView> hourAndMinuteViews = sensorRepository.findAvgLitrosMinByHourAndMinute();
        for (int i = 0; i < 24; i++) {
            for (int j = 0; j < 60; j++) {
                final Integer finalI = i;
                final Integer finalJ = j;
                final boolean exists = hourAndMinuteViews.stream().anyMatch(hourAndMinuteView -> hourAndMinuteView.getHour().equals(finalI) && hourAndMinuteView.getMinute().equals(finalJ));
                if (!exists) {
                    hourAndMinuteViews.add(HourAndMinuteDTO.builder().hour(i).minute(j).litrosMinAvg(0.0).build());
                }
            }
        }
        return hourAndMinuteViews.stream().sorted(Comparator.comparing(HourAndMinuteView::getHour).thenComparing(HourAndMinuteView::getMinute)).toList();
    }

    public List<HourView> findAvgLitrosMinByHour() {
        final List<HourView> hourViews = sensorRepository.findAvgLitrosMinByHour();
        for (int i = 0; i < 24; i++) {
            final Integer finalI = i;
            final boolean exists = hourViews.stream().anyMatch(hourView -> hourView.getHour().equals(finalI));
            if (!exists) {
                hourViews.add(HourDTO.builder().hour(i).litrosMinAvg(0.0).build());
            }
        }
        return hourViews.stream().unordered().sorted(Comparator.comparing(HourView::getHour)).toList();
    }

    public List<DayOfWeekView> findAvgLitrosMinByDayOfWeek() {
        final List<DayOfWeekView> dayOfWeekViews = sensorRepository.findAvgLitrosMinByDayOfWeek();
        for (int i = 0; i < 7; i++) {
            final Integer finalI = i;
            final boolean exists = dayOfWeekViews.stream().anyMatch(dayOfWeekView -> dayOfWeekView.getDayOfWeek().equals(finalI));
            if (!exists) {
                dayOfWeekViews.add(DayOfWeekDTO.builder().dayOfWeek(i).litrosMinAvg(0.0).build());
            }
        }
        return dayOfWeekViews.stream().map(
                (item) -> (DayOfWeekView) DayOfWeekDTO.builder().dayOfWeek(item.getDayOfWeek() + 1).litrosMinAvg(item.getLitrosMinAvg()).build()
        ).unordered().sorted(Comparator.comparing(DayOfWeekView::getDayOfWeek)).toList();
    }

    public List<DayOFMonthView> findAvgLitrosMinByDayOfMonth() {
        final List<DayOFMonthView> dayOFMonthViews = sensorRepository.findAvgLitrosMinByDayOfMonth();
        for (int i = 1; i < 32; i++) {
            final Integer finalI = i;
            final boolean exists = dayOFMonthViews.stream().anyMatch(dayOFMonthView -> dayOFMonthView.getDayOfMonth().equals(finalI));
            if (!exists) {
                dayOFMonthViews.add(DayOFMonthDTO.builder().dayOfMonth(i).litrosMinAvg(0.0).build());
            }
        }
        return dayOFMonthViews.stream().unordered().sorted(Comparator.comparing(DayOFMonthView::getDayOfMonth)).toList();
    }

    public List<MonthView> findAvgLitrosMinByMonth() {
        final List<MonthView> monthViews = sensorRepository.findAvgLitrosMinByMonth();

        for (int i = 1; i <= 12; i++) {
            final Integer finalI = i;
            final boolean exists = monthViews.stream().anyMatch(monthView -> monthView.getMonth().equals(finalI));

            if (!exists) {
                monthViews.add(MonthDTO.builder().month(i).litrosMinAvg(0.0).build());
            }
        }

        return monthViews.stream().unordered().sorted(Comparator.comparing(MonthView::getMonth)).toList();
    }

    public List<YearView> findAvgLitrosMinByYear() {
        return sensorRepository.findAvgLitrosMinByYear();
    }

}
