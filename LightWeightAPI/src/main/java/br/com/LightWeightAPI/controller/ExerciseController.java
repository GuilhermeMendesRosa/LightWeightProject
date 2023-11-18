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
@RequestMapping("/exercise")
public class ExerciseController {

    @Autowired
    private ExerciseService exerciseService;

    @GetMapping()
    public ResponseEntity list() {
        List<ExerciseDTO> exercises = this.exerciseService.list();

        return ResponseEntity.ok(exercises);
    }

    @GetMapping("/find/{muscularGroup}")
    public ResponseEntity findExercisesByMuscularGroup(@PathVariable MuscularGroupEnum muscularGroup) {
        List<ExerciseDTO> exercises = this.exerciseService.findByMuscularGroup(muscularGroup);

        return ResponseEntity.ok(exercises);
    }

}
