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

}
