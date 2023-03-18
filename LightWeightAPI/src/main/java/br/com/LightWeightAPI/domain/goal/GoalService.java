package br.com.LightWeightAPI.domain.goal;

import br.com.LightWeightAPI.domain.exercise.ExerciseService;
import br.com.LightWeightAPI.domain.user.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

@Service
public class GoalService {

    @Autowired
    private GoalRepository repository;

    @Autowired
    private ExerciseService exerciseService;

    public Goal create(GoalDTO goalDTO) {
        User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();

        Goal goal = new Goal();

        goal.setUser(user);
        goal.setExercise(this.exerciseService.findExerciseById(goalDTO.getExerciseId()));
        goal.setWeight(goalDTO.getWeight());

        this.repository.save(goal);

        return goal;
    }

    public Goal changeGoalToAccomplished(Long id) {
        Goal goal = this.repository.findGoalById(id);
        goal.setAccomplished(Boolean.TRUE);

        return goal;
    }

    public GoalDTO findGoalDTOById(Long id) {
        return this.repository.findGoalDTOById(id);
    }

}
