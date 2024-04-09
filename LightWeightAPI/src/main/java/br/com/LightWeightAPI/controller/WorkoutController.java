package br.com.LightWeightAPI.controller;

import br.com.LightWeightAPI.domain.workout.Workout;
import br.com.LightWeightAPI.domain.workout.WorkoutDTO;
import br.com.LightWeightAPI.domain.workout.WorkoutService;
import br.com.LightWeightAPI.domain.workoutcompound.WorkoutCompound;
import br.com.LightWeightAPI.domain.workoutcompound.WorkoutCompoundDTO;
import br.com.LightWeightAPI.infra.utils.LightWeightUtils;
import com.google.gson.Gson;
import jakarta.transaction.Transactional;
import org.hibernate.query.sql.internal.ParameterRecognizerImpl;
import org.springframework.ai.openai.OpenAiChatClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
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

    @Autowired
    private OpenAiChatClient chatClient;


    @PostMapping()
    @Transactional
    public ResponseEntity createWorkout(@RequestBody WorkoutDTO workoutDTO, UriComponentsBuilder uriComponentsBuilder) {
        Workout workout = this.workoutService.create(workoutDTO);

        URI uri = uriComponentsBuilder.path("/workout/{id}").buildAndExpand(workout.getId()).toUri();

        return ResponseEntity.created(uri).body(workoutDTO);
    }

    @GetMapping("/{id}")
    public ResponseEntity findWorkout(@PathVariable Long id) {
        WorkoutDTO workoutDTO = this.workoutService.findWorkoutDTOById(id);

        return ResponseEntity.ok(workoutDTO);
    }

    @GetMapping()
    public ResponseEntity findWorkoutByUser() {
        Long userId = LightWeightUtils.getLoggedUser().getId();

        List<WorkoutDTO> workoutDTOS = this.workoutService.findByUserId(userId);

        return ResponseEntity.ok(workoutDTOS);
    }

    @PutMapping("/{workoutId}")
    @Transactional
    public ResponseEntity editWorkout(@RequestBody WorkoutDTO workoutDTO, @PathVariable Long workoutId, UriComponentsBuilder uriComponentsBuilder) {
        this.workoutService.editWorkout(workoutId, workoutDTO);
        URI uri = uriComponentsBuilder.path("/workout/{id}").buildAndExpand(workoutId).toUri();

        return ResponseEntity.created(uri).body(workoutDTO);
    }

    @DeleteMapping("/{workoutId}")
    @Transactional
    public ResponseEntity deleteWorkout(@PathVariable Long workoutId) {
        this.workoutService.delete(workoutId);

        return ResponseEntity.status(HttpStatus.ACCEPTED).build();
    }

    @PostMapping()
    @RequestMapping("/generate")
    @Transactional
    public ResponseEntity generateWorkout(@RequestBody String description, UriComponentsBuilder uriComponentsBuilder) {
        Gson gson = new Gson();
        List<WorkoutCompoundDTO> allWorkoutCompounds = this.workoutService.findAllWorkoutCompounds();

        String prompt = String.format("""
                No meu aplicativo de treinos eu quero que você crie um treino com esse foco: {%s}
                                
                Para isso eu quero que você me devolva um json seguindo a estrutura da minha classe WorkoutDTO
                                
                WorkoutDTO {
                                
                String name;
                String description;
                List<WorkoutCompoundDTO> workoutCompoundsDTOs;
                                
                }
                                
                Ela contém uma lista de WorkoutCompoundDTO dentro dela, essa é a estrutura da classe
                                
                WorkoutCompoundDTO {
                                
                String exerciseName;
                Integer series;
                Integer reps;
                                
                }
                
                Os WorkoutCompoundDTO disponíveis são esses: {
                %s
                }
                                
                {{ME RESPONDA SOMENTE COM O JSON EM FORMAT DE STRING}}
                {{workoutCompoundsDTOs não pode vir vazio use somente os que estão disponíveis, também não pode ter nenhum repetido}
                """, description, gson.toJson(allWorkoutCompounds));

        String json = chatClient.call(prompt);
        WorkoutDTO workoutDTO = gson.fromJson(json, WorkoutDTO.class);

        Workout workout = this.workoutService.create(workoutDTO);

        URI uri = uriComponentsBuilder.path("/workout/{id}").buildAndExpand(workout.getId()).toUri();

        return ResponseEntity.created(uri).body(workoutDTO);
    }

}
