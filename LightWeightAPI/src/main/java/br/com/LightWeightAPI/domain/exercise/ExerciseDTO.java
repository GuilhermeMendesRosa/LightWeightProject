package br.com.LightWeightAPI.domain.exercise;

import lombok.Data;

@Data
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
