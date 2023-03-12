package br.com.LightWeightAPI.domain.workout;

import br.com.LightWeightAPI.domain.workoutcompound.WorkoutCompound;
import br.com.LightWeightAPI.domain.workoutcompound.WorkoutCompoundDTO;
import lombok.Getter;
import lombok.Setter;

import java.io.Serial;
import java.io.Serializable;
import java.util.List;

@Getter
@Setter
public class WorkoutDTO implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    private Long userId;
    private String name;
    private String description;
    private List<WorkoutCompoundDTO> workoutCompoundsDTOs;

    public WorkoutDTO() {

    }


//    public WorkoutDTO(Workout workout) {
//        this.userId = workout.getUser().getId();
//        this.name = workout.getName();
//        this.description = workout.getDescription();
//    }

    public WorkoutDTO(Workout workout, List<WorkoutCompound> workoutCompounds) {
        this.userId = workout.getUser().getId();
        this.name = workout.getName();
        this.description = workout.getDescription();
        this.workoutCompoundsDTOs = workoutCompounds.stream().map(WorkoutCompoundDTO::new).toList();
    }

}
