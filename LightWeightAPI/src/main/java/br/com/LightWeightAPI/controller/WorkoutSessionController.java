package br.com.LightWeightAPI.controller;

import br.com.LightWeightAPI.domain.workoutsession.WorkoutSession;
import br.com.LightWeightAPI.domain.workoutsession.WorkoutSessionDTO;
import br.com.LightWeightAPI.domain.workoutsession.WorkoutSessionService;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/workout-session")
public class WorkoutSessionController {

    @Autowired
    private WorkoutSessionService workoutSessionService;

    @PostMapping("/create")
    @Transactional
    public ResponseEntity create(@RequestBody WorkoutSessionDTO workoutSessionDTO) {
        WorkoutSession workoutSession = this.workoutSessionService.create(workoutSessionDTO);

        return ResponseEntity.ok().build();
    }

    @GetMapping("/find/{id}")
    public ResponseEntity findById(@PathVariable Long id) {
        WorkoutSessionDTO workoutSessionDTO = this.workoutSessionService.findById(id);

        return ResponseEntity.ok(workoutSessionDTO);
    }

}
