package br.com.LightWeightAPI.domain.workoutcompound;

import br.com.LightWeightAPI.domain.exercise.Exercise;
import jakarta.persistence.*;
import lombok.*;

@Table(name = "workout_compounds")
@Entity(name = "WorkoutCompound")
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
@Getter
@Setter
public class WorkoutCompound {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(insertable = false, updatable = false)
    private Long id;
    @ManyToOne
    @JoinColumn(name="exercise_id", nullable=false)
    private Exercise exercise;
    private Integer series;
    private Integer reps;

}
