package br.com.LightWeightAPI.domain.workout;

import br.com.LightWeightAPI.domain.user.User;
import jakarta.persistence.*;
import lombok.*;

@Table(name = "workouts")
@Entity(name = "Workout")
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
@Getter
@Setter
public class Workout {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(insertable = false, updatable = false)
    private Long id;
    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;
    private String name;
    private String description;

}
