package br.com.LightWeightAPI.domain.workout;

import br.com.LightWeightAPI.domain.workoutcompound.WorkoutCompound;
import br.com.LightWeightAPI.domain.workoutcompound.WorkoutCompoundDTO;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.List;

@Data
public class WorkoutDTO implements Serializable {


    private Long id;
    @NotBlank
    private String name;
    private String description;
    @NotEmpty
    @Valid
    private List<WorkoutCompoundDTO> workoutCompoundsDTOs;

    public WorkoutDTO() {
    }

    public WorkoutDTO(List<WorkoutCompound> workoutCompounds) {
        Workout workout = workoutCompounds.get(0).getWorkout();

        this.id = workout.getId();
        this.name = workout.getName();
        this.description = workout.getDescription();

        this.workoutCompoundsDTOs = workoutCompounds.stream().map(WorkoutCompoundDTO::new).toList();
    }

}
