package br.com.LightWeightAPI.domain.workoutcompound;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

import java.io.Serializable;

@Data
public class WorkoutCompoundDTO implements Serializable {

    @NotBlank
    private String exerciseName;
    private Integer series;
    private Integer reps;
//    @NotNull
//    private MuscularGroupEnum muscularGroup;

    public WorkoutCompoundDTO() {

    }

    public WorkoutCompoundDTO(WorkoutCompound workoutCompound) {
        this.exerciseName = workoutCompound.getExercise().getName();
        this.series = workoutCompound.getSeries();
        this.reps = workoutCompound.getReps();
//        this.muscularGroup = workoutCompound.getExercise().getMuscularGroup();
    }

}
