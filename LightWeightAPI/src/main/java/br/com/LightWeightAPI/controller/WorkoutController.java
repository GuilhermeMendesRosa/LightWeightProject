package br.com.LightWeightAPI.controller;

import br.com.LightWeightAPI.domain.user.User;
import br.com.LightWeightAPI.domain.workout.WorkoutDTO;
import br.com.LightWeightAPI.domain.workout.WorkoutService;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/workout")
public class WorkoutController {

    @Autowired
    private WorkoutService workoutService;

    @GetMapping("/find/{id}")
    public ResponseEntity findWorkout(@PathVariable Long id) {
        WorkoutDTO workoutDTO = this.workoutService.findById(id);

        return ResponseEntity.ok(workoutDTO);
    }

    @GetMapping("/find")
    public ResponseEntity findWorkoutByUser() {
        User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        Long userId = user.getId();

        List<WorkoutDTO> workoutDTOS = this.workoutService.findByUserId(userId);

        return ResponseEntity.ok(workoutDTOS);
    }

    @PostMapping("/create")
    @Transactional
    public ResponseEntity createWorkout(@RequestBody WorkoutDTO workoutDTO) {
        this.workoutService.create(workoutDTO);

        return  ResponseEntity.ok(workoutDTO);
    }

}
