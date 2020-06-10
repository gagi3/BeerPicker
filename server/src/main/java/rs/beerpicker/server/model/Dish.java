package rs.beerpicker.server.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import java.util.List;

@NoArgsConstructor
@Data
@Entity
@Table
public class Dish {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false)
    private String name;
    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private DishType type;
    @Column
    @Enumerated(EnumType.STRING)
    private Cuisine cuisine;
    @OneToMany
    private List<Food> ingredients;
    @Column
    @ElementCollection(targetClass = String.class)
    private List<String> descriptors;
    @ElementCollection(targetClass = Preparation.class)
    @Column
    @Enumerated(EnumType.STRING)
    private List<Preparation> preparation;
    @Max(5)
    @Min(0)
    @Column(nullable = false)
    private Integer saltinessIndex;
    @Max(5)
    @Min(0)
    @Column(nullable = false)
    private Integer spicinessIndex;
    @Max(5)
    @Min(0)
    @Column(nullable = false)
    private Integer sweetnessIndex;
    @Max(5)
    @Min(0)
    @Column(nullable = false)
    private Integer sournessIndex;
    @Max(5)
    @Min(0)
    @Column(nullable = false)
    private Integer bitternessIndex;
}
