package rs.beerpicker.server.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import rs.beerpicker.server.model.Beer;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Recommendation {
    private Beer beer;
    private Integer factor;
}
