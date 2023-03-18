package br.com.LightWeightAPI.domain.goal;

import br.com.LightWeightAPI.domain.exercise.Exercise;
import br.com.LightWeightAPI.domain.user.User;
import jakarta.persistence.*;
import lombok.*;

@Table(name = "goals")
@Entity(name = "Goal")
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
@Getter
@Setter
public class Goal {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(insertable = false, updatable = false)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @ManyToOne
    @JoinColumn(name = "exercise_id", nullable = false)
    private Exercise exercise;

    private Double weight;

    private Boolean accomplished;

}
