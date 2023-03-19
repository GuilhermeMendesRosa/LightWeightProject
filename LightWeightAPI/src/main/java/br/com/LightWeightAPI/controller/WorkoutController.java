package br.com.LightWeightAPI.controller;

import br.com.LightWeightAPI.domain.workout.Workout;
import br.com.LightWeightAPI.domain.workout.WorkoutDTO;
import br.com.LightWeightAPI.domain.workout.WorkoutService;
import br.com.LightWeightAPI.infra.utils.LightWeightUtils;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/workout")
public class WorkoutController {

    @Autowired
    private WorkoutService workoutService;

    @GetMapping("/{id}")
    public ResponseEntity findWorkout(@PathVariable Long id) {
        WorkoutDTO workoutDTO = this.workoutService.findWorkoutDTOById(id);

        return ResponseEntity.ok(workoutDTO);
    }

    @GetMapping("/find")
    public ResponseEntity findWorkoutByUser() {
        Long userId = LightWeightUtils.getLoggedUser().getId();

        List<WorkoutDTO> workoutDTOS = this.workoutService.findByUserId(userId);

        return ResponseEntity.ok(workoutDTOS);
    }

    @PostMapping("/create")
    @Transactional
    public ResponseEntity createWorkout(@RequestBody WorkoutDTO workoutDTO, UriComponentsBuilder uriComponentsBuilder) {
        Workout workout = this.workoutService.create(workoutDTO);

        URI uri = uriComponentsBuilder.path("/workout/{id}").buildAndExpand(workout.getId()).toUri();

        return ResponseEntity.created(uri).body(workoutDTO);
    }

}
