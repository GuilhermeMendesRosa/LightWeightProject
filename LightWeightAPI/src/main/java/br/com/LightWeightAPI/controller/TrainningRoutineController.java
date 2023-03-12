package br.com.LightWeightAPI.controller;

import br.com.LightWeightAPI.domain.Exercise.Exercise;
import br.com.LightWeightAPI.domain.Exercise.ExerciseService;
import br.com.LightWeightAPI.domain.Exercise.MuscularGroupEnum;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/trainning-routine")
public class TrainningRoutineController {

    @Autowired
    private ExerciseService exerciseService;

    @PostMapping("/find/{muscularGroup}")
    public ResponseEntity findByMuscularGroup(@PathVariable MuscularGroupEnum muscularGroup) {
        List<Exercise> exercises = this.exerciseService.findByMuscularGroup(muscularGroup);

        return ResponseEntity.ok(exercises);
    }

}
