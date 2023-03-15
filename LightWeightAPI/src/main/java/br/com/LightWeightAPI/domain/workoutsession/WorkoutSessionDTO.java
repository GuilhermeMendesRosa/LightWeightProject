package br.com.LightWeightAPI.domain.workoutsession;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.Date;

@Getter
@Setter
public class WorkoutSessionDTO implements Serializable {

    private Long userId;
    private Long workoutId;
    private Long duration;
    private Date date;

    public WorkoutSessionDTO() {

    }

    public WorkoutSessionDTO(WorkoutSession workoutSession) {
        this.userId = workoutSession.getId();
        this.workoutId = workoutSession.getWorkout().getId();
        this.duration = workoutSession.getDuration();
        this.date = workoutSession.getDate();
    }

}
