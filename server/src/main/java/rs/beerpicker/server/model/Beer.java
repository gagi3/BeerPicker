package rs.beerpicker.server.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@NoArgsConstructor
@Data
@Entity
@Table
public class Beer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false)
    private String name;
    @Column(nullable = false)
    private Double strength;
    @ElementCollection(targetClass = BeerFlavour.class)
    @Column
    @Enumerated(EnumType.STRING)
    private List<BeerFlavour> flavours;
    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private BeerType type;
    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private BeerStyle style;
}
