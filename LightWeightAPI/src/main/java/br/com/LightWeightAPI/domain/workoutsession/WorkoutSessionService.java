package br.com.LightWeightAPI.domain.workoutsession;

import br.com.LightWeightAPI.domain.workout.Workout;
import br.com.LightWeightAPI.domain.workout.WorkoutService;
import br.com.LightWeightAPI.infra.utils.LightWeightUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class WorkoutSessionService {

    @Autowired
    private WorkoutSessionRepository repository;

    @Autowired
    private WorkoutService workoutService;

    public WorkoutSession create(WorkoutSessionDTO workoutSessionDTO) {
        WorkoutSession workoutSession = new WorkoutSession();

        Workout workout = this.workoutService.findById(workoutSessionDTO.getWorkoutId());

        workoutSession.setUser(LightWeightUtils.getLoggedUser());
        workoutSession.setWorkout(workout);
        workoutSession.setDuration(workoutSessionDTO.getDuration());
        workoutSession.setDate(new Date());

        this.repository.save(workoutSession);

        return workoutSession;
    }

    public WorkoutSessionDTO findById(Long id) {
        WorkoutSessionDTO workoutSessionDTO = this.repository.findWorkoutSessionDTO(id);

        return workoutSessionDTO;
    }
}
