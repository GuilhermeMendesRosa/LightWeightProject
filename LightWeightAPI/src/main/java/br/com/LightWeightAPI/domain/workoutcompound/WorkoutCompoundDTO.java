package br.com.LightWeightAPI.domain.workoutcompound;

import br.com.LightWeightAPI.domain.exercise.MuscularGroupEnum;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
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
