package br.com.LightWeightAPI.domain.workout;

import br.com.LightWeightAPI.domain.exercise.Exercise;
import br.com.LightWeightAPI.domain.exercise.ExerciseService;
import br.com.LightWeightAPI.domain.workoutcompound.WorkoutCompound;
import br.com.LightWeightAPI.domain.workoutcompound.WorkoutCompoundDTO;
import br.com.LightWeightAPI.domain.workoutcompound.WorkoutCompoundRepository;
import br.com.LightWeightAPI.infra.utils.LightWeightUtils;
import org.springframework.beans.factory.annotation.Autowired;
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

    public WorkoutDTO findWorkoutDTOById(Long id) {
        List<WorkoutCompound> workoutCompounds = this.workoutCompoundRepository.findByWorkoutId(id);
        WorkoutDTO workoutDTO = new WorkoutDTO(workoutCompounds);

        return workoutDTO;
    }

    public List<WorkoutDTO> findByUserId(Long userId) {
        List<Long> workoutIds = this.workoutRepository.findByUserId(userId);

        List<WorkoutDTO> workoutDTOS = new ArrayList<>();

        workoutIds.forEach(id -> {
            workoutDTOS.add(findWorkoutDTOById(id));
        });

        return workoutDTOS;
    }

    public Workout create(WorkoutDTO workoutDTO) {
        Workout workout = new Workout();
        workout.setName(workoutDTO.getName());
        workout.setDescription(workoutDTO.getDescription());
        workout.setUser(LightWeightUtils.getLoggedUser());

        this.workoutRepository.save(workout);

        bindWorkoutCompounds(workout, workoutDTO);

        return workout;
    }

    private void bindWorkoutCompounds(Workout workout, WorkoutDTO workoutDTO) {
        List<String> exerciseNames = workoutDTO.getWorkoutCompoundsDTOs().stream().map(WorkoutCompoundDTO::getExerciseName).toList();

        List<Exercise> exercises = this.exerciseService.findByNameList(exerciseNames);

        List<WorkoutCompoundDTO> workoutCompoundsDTOs = workoutDTO.getWorkoutCompoundsDTOs();
        for (WorkoutCompoundDTO compoundDTO : workoutCompoundsDTOs) {
            WorkoutCompound workoutCompound = new WorkoutCompound();
            workoutCompound.setExercise(exercises.get(workoutCompoundsDTOs.indexOf(compoundDTO)));
            workoutCompound.setReps(compoundDTO.getReps());
            workoutCompound.setSeries(compoundDTO.getReps());
            workoutCompound.setWorkout(workout);

            this.workoutCompoundRepository.save(workoutCompound);
        }
    }

    public void delete(Long workoutId) {
        Workout workout = this.workoutRepository.findWorkoutById(workoutId);
        this.clearWorkoutCompounds(workoutId);

        this.workoutRepository.delete(workout);
    }

    public void editWorkout(Long workoutId, WorkoutDTO workoutDTO) {
        Workout workout = this.workoutRepository.findWorkoutById(workoutId);
        workout.setName(workoutDTO.getName());
        workout.setDescription(workoutDTO.getDescription());

        this.clearWorkoutCompounds(workoutId);
        this.bindWorkoutCompounds(workout, workoutDTO);
    }

    private void clearWorkoutCompounds(Long workoutId) {
        List<WorkoutCompound> workoutCompounds = this.workoutCompoundRepository.findByWorkoutId(workoutId);
        for (WorkoutCompound workoutCompound : workoutCompounds) {
            this.workoutCompoundRepository.delete(workoutCompound);
        }
    }

}
