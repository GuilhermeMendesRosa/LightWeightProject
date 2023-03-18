package br.com.LightWeightAPI.domain.workout;

import br.com.LightWeightAPI.domain.exercise.Exercise;
import br.com.LightWeightAPI.domain.exercise.ExerciseService;
import br.com.LightWeightAPI.domain.user.User;
import br.com.LightWeightAPI.domain.workoutcompound.WorkoutCompound;
import br.com.LightWeightAPI.domain.workoutcompound.WorkoutCompoundRepository;
import br.com.LightWeightAPI.infra.utils.LightWeightUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class WorkoutService {

    @Autowired
    private WorkoutRepository workoutRepository;

    @Autowired
    private WorkoutCompoundRepository workoutCompoundRepository;

    @Autowired
    private ExerciseService exerciseService;

    public Workout findById(Long id) {
        return this.workoutRepository.findWorkoutById(id);
    }

    public WorkoutDTO getWorkoutDTOById(Long id) {
        Workout workout = this.workoutRepository.findWorkoutById(id);
        List<WorkoutCompound> workoutCompounds = this.workoutCompoundRepository.findByWorkoutId(id);

        WorkoutDTO workoutDTO = new WorkoutDTO(workout, workoutCompounds);

        return workoutDTO;
    }

    public List<WorkoutDTO> findByUserId(Long userId) {
        List<Long> workoutIds = this.workoutRepository.findByUserId(userId);

        List<WorkoutDTO> workoutDTOS = new ArrayList<>();

        workoutIds.forEach(id -> {
            workoutDTOS.add(getWorkoutDTOById(id));
        });

        return workoutDTOS;
    }

    public Workout create(WorkoutDTO workoutDTO) {
        Workout workout = new Workout();
        workout.setName(workoutDTO.getName());
        workout.setDescription(workoutDTO.getDescription());
        workout.setUser(LightWeightUtils.getLoggedUser());

        this.workoutRepository.save(workout);

        workoutDTO.getWorkoutCompoundsDTOs().forEach(dto -> {
            WorkoutCompound workoutCompound = new WorkoutCompound();
            Exercise exercise = this.exerciseService.findByName(dto.getExerciseName());
            workoutCompound.setExercise(exercise);
            workoutCompound.setReps(dto.getReps());
            workoutCompound.setSeries(dto.getReps());
            workoutCompound.setWorkout(workout);

            this.workoutCompoundRepository.save(workoutCompound);
        });

        return workout;
    }
}
