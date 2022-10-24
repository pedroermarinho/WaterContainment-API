package io.github.pedroermarinho.watercontainmentapi.domain.dtos;

import io.github.pedroermarinho.watercontainmentapi.domain.views.YearView;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data

@AllArgsConstructor
@NoArgsConstructor
@Builder
public class YearDTO  implements YearView {
    private Double litrosMinAvg;
    private Integer year;
}
