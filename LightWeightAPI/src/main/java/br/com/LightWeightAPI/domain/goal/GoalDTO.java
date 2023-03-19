package br.com.LightWeightAPI.domain.goal;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
public class GoalDTO implements Serializable {

    private Long userId;
    private Long exerciseId;
    private Double weight;

    public GoalDTO() {

    }

    public GoalDTO(Goal goal) {
        this.userId = goal.getUser().getId();
        this.exerciseId = goal.getExercise().getId();
        this.weight = goal.getWeight();
    }

}
