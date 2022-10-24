package io.github.pedroermarinho.watercontainmentapi.domain.dtos;

import io.github.pedroermarinho.watercontainmentapi.domain.views.DayOfWeekView;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data

@AllArgsConstructor
@NoArgsConstructor
@Builder
public class DayOfWeekDTO  implements DayOfWeekView {
    private Double litrosMinAvg;
    private Integer dayOfWeek;
}
