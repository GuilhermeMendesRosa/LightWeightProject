package br.com.LightWeightAPI.controller;

import br.com.LightWeightAPI.domain.goal.Goal;
import br.com.LightWeightAPI.domain.goal.GoalDTO;
import br.com.LightWeightAPI.domain.goal.GoalService;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;

@RestController
@RequestMapping("/goal")
public class GoalController {

    @Autowired
    private GoalService goalService;

    @PostMapping("/create")
    @Transactional
    public ResponseEntity create(@RequestBody GoalDTO goalDTO, UriComponentsBuilder uriComponentsBuilder) {
        Goal goal = this.goalService.create(goalDTO);

        URI uri = uriComponentsBuilder.path("/workout/{id}").buildAndExpand(goal.getId()).toUri();
        goalDTO = new GoalDTO(goal);
        
        return ResponseEntity.created(uri).body(goalDTO);
    }

    @GetMapping("/{id}")
    public ResponseEntity findGoal(@PathVariable Long id) {
        GoalDTO goalDTO = this.goalService.findGoalDTOById(id);

        return ResponseEntity.ok(goalDTO);
    }

    @PutMapping("/{id}")
    public ResponseEntity changeGoalToAccomplished(@PathVariable Long id) {
        Goal goal = this.goalService.changeGoalToAccomplished(id);
        GoalDTO goalDTO = new GoalDTO(goal);

        return ResponseEntity.ok(goalDTO);
    }

}
