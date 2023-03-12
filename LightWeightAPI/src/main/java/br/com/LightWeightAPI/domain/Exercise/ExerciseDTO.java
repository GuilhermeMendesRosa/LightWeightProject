package br.com.LightWeightAPI.domain.Exercise;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ExerciseDTO {

    private String name;
    private MuscularGroupEnum muscularGroup;

    public ExerciseDTO() {
    }

    public ExerciseDTO(Exercise exercise) {
        this.name = exercise.getName();
        this.muscularGroup = exercise.getMuscularGroup();
    }

}
