package io.github.pedroermarinho.watercontainmentapi.domain.dtos;

import io.github.pedroermarinho.watercontainmentapi.domain.views.HourView;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data

@AllArgsConstructor
@NoArgsConstructor
@Builder
public class HourDTO  implements HourView {
    private Integer hour;
     private Double litrosMinAvg;
}
