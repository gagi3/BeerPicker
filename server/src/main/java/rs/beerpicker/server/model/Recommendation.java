package rs.beerpicker.server.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Data
@NoArgsConstructor
@Entity
@Table
public class Recommendation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column
    @Enumerated(EnumType.STRING)
    private BeerType type;
    @Column
    @Enumerated(EnumType.STRING)
    private BeerStyle style;
    @ElementCollection(targetClass = BeerFlavour.class)
    @CollectionTable
    @Enumerated(EnumType.STRING)
    private List<BeerFlavour> flavours;
}
