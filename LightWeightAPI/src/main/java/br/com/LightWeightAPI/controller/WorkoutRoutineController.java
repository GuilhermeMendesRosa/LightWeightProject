package br.com.LightWeightAPI.controller;

import br.com.LightWeightAPI.domain.exercise.ExerciseDTO;
import br.com.LightWeightAPI.domain.exercise.ExerciseService;
import br.com.LightWeightAPI.domain.exercise.MuscularGroupEnum;
import br.com.LightWeightAPI.domain.workout.WorkoutDTO;
import br.com.LightWeightAPI.domain.workout.WorkoutService;
import br.com.LightWeightAPI.domain.workoutcompound.WorkoutCompound;
import br.com.LightWeightAPI.domain.workoutcompound.WorkoutCompoundRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/workout")
public class WorkoutRoutineController {

    @Autowired
    private ExerciseService exerciseService;

    @Autowired
    private WorkoutService workoutService;

    @GetMapping("/find-exercises/{muscularGroup}")
    public ResponseEntity findExercisesByMuscularGroup(@PathVariable MuscularGroupEnum muscularGroup) {
        List<ExerciseDTO> exercises = this.exerciseService.findByMuscularGroup(muscularGroup);

        return ResponseEntity.ok(exercises);
    }

    @GetMapping("/find/{id}")
    public ResponseEntity findWorkoutRoutine(@PathVariable Long id) {
        WorkoutDTO workoutDTO = this.workoutService.findById(id);

        return ResponseEntity.ok(workoutDTO);
    }

}
