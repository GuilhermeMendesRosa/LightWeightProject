package br.com.LightWeightAPI.controller;

import br.com.LightWeightAPI.domain.workoutsession.WorkoutSession;
import br.com.LightWeightAPI.domain.workoutsession.WorkoutSessionDTO;
import br.com.LightWeightAPI.domain.workoutsession.WorkoutSessionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/workout-session")
public class WorkoutSessionController {

    @Autowired
    private WorkoutSessionService workoutSessionService;

    @PostMapping("/create")
    public ResponseEntity createWorkoutSession(@RequestBody WorkoutSessionDTO workoutSessionDTO) {
        WorkoutSession workoutSession = this.workoutSessionService.create(workoutSessionDTO);

        return ResponseEntity.ok().build();
    }
}
