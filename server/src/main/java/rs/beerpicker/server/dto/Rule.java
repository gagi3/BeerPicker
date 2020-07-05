package rs.beerpicker.server.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class Rule {
    private String name;
    private String agendaGroup;
    private Integer salience;
    private Boolean lockOnActive;
    private Boolean noLoop;
    private String when;
    private String then;
}
