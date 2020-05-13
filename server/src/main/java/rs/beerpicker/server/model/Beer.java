package rs.beerpicker.server.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

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
    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private BeerType type;
    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private BeerStyle style;
}
