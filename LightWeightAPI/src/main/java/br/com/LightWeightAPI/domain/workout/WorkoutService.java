package br.com.LightWeightAPI.domain.workout;

import br.com.LightWeightAPI.domain.workoutcompound.WorkoutCompound;
import br.com.LightWeightAPI.domain.workoutcompound.WorkoutCompoundRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class WorkoutService {

    @Autowired
    private WorkoutRepository workoutRepository;

    @Autowired
    private WorkoutCompoundRepository workoutCompoundRepository;

    public WorkoutDTO findById(Long id) {
        Workout workout = this.workoutRepository.findWorkoutById(id);
        List<WorkoutCompound> workoutCompounds = this.workoutCompoundRepository.findByWorkoutId(id);

        WorkoutDTO workoutDTO = new WorkoutDTO(workout, workoutCompounds);

        return workoutDTO;
    }

}
