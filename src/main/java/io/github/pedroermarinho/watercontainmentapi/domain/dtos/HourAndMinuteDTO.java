package io.github.pedroermarinho.watercontainmentapi.domain.dtos;

import io.github.pedroermarinho.watercontainmentapi.domain.views.HourAndMinuteView;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data

@AllArgsConstructor
@NoArgsConstructor
@Builder
public class HourAndMinuteDTO implements HourAndMinuteView {
    private Integer hour;
    private Integer minute;
     private Double litrosMinAvg;
}
