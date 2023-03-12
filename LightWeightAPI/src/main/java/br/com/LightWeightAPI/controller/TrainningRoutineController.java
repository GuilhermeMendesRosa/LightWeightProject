package br.com.LightWeightAPI.controller;

import br.com.LightWeightAPI.domain.exercise.ExerciseDTO;
import br.com.LightWeightAPI.domain.exercise.ExerciseService;
import br.com.LightWeightAPI.domain.exercise.MuscularGroupEnum;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/workout-routine")
public class WorkoutController {

    @Autowired
    private ExerciseService exerciseService;

    @GetMapping("/find-exercises/{muscularGroup}")
    public ResponseEntity findByMuscularGroup(@PathVariable MuscularGroupEnum muscularGroup) {
        List<ExerciseDTO> exercises = this.exerciseService.findByMuscularGroup(muscularGroup);

        return ResponseEntity.ok(exercises);
    }

}
