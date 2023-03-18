package br.com.LightWeightAPI.domain.workoutsession;

import br.com.LightWeightAPI.domain.user.User;
import br.com.LightWeightAPI.domain.workout.Workout;
import jakarta.persistence.*;
import lombok.*;

import java.util.Date;

@Table(name = "workout_sessions")
@Entity(name = "WorkoutSession")
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
@Getter
@Setter
public class WorkoutSession {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JoinColumn(insertable = false, updatable = false)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @ManyToOne
    @JoinColumn(name = "workout_id", nullable = false)
    private Workout workout;

    private Long duration;

    private Date date;

}
