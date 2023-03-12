package br.com.LightWeightAPI.domain.workout;

import br.com.LightWeightAPI.domain.workoutcompound.WorkoutCompound;
import br.com.LightWeightAPI.domain.workoutcompound.WorkoutCompoundDTO;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.List;

@Getter
@Setter
public class WorkoutDTO implements Serializable {


    @NotBlank
    private String name;
    private String description;

    @NotEmpty
    @Valid
    private List<WorkoutCompoundDTO> workoutCompoundsDTOs;

    public WorkoutDTO() {

    }

    public WorkoutDTO(Workout workout, List<WorkoutCompound> workoutCompounds) {
        this.name = workout.getName();
        this.description = workout.getDescription();
        this.workoutCompoundsDTOs = workoutCompounds.stream().map(WorkoutCompoundDTO::new).toList();
    }

}
