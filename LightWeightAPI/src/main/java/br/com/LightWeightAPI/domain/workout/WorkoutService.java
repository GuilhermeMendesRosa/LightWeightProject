package br.com.LightWeightAPI.domain.workout;

import br.com.LightWeightAPI.domain.exercise.Exercise;
import br.com.LightWeightAPI.domain.exercise.ExerciseService;
import br.com.LightWeightAPI.domain.workoutcompound.WorkoutCompound;
import br.com.LightWeightAPI.domain.workoutcompound.WorkoutCompoundDTO;
import br.com.LightWeightAPI.domain.workoutcompound.WorkoutCompoundRepository;
import br.com.LightWeightAPI.infra.utils.LightWeightUtils;
import com.google.gson.Gson;
import org.springframework.ai.openai.OpenAiChatClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class WorkoutService {

    @Autowired
    private WorkoutRepository workoutRepository;

    @Autowired
    private WorkoutCompoundRepository workoutCompoundRepository;

    @Autowired
    private ExerciseService exerciseService;

    @Autowired
    private OpenAiChatClient chatClient;

    public Workout create(WorkoutDTO workoutDTO) {
        Workout workout = new Workout();
        workout.setName(workoutDTO.getName());
        workout.setDescription(workoutDTO.getDescription());
        workout.setUser(LightWeightUtils.getLoggedUser());

        this.workoutRepository.save(workout);

        this.bindWorkoutCompounds(workout, workoutDTO);

        return workout;
    }

    public Workout findById(Long id) {
        return this.workoutRepository.findWorkoutById(id);
    }

    public WorkoutDTO findWorkoutDTOById(Long id) {
        List<WorkoutCompound> workoutCompounds = this.workoutCompoundRepository.findByWorkoutId(id);
        WorkoutDTO workoutDTO = new WorkoutDTO(workoutCompounds);

        return workoutDTO;
    }

    public List<WorkoutDTO> findByUserId(Long userId) {
        List<Long> workoutIds = this.workoutRepository.findByUserId(userId);

        List<WorkoutDTO> workoutDTOS = new ArrayList<>();

        workoutIds.forEach(id -> {
            workoutDTOS.add(findWorkoutDTOById(id));
        });

        return workoutDTOS;
    }

    public void delete(Long workoutId) {
        Workout workout = this.workoutRepository.findWorkoutById(workoutId);
        this.clearWorkoutCompounds(workoutId);

        this.workoutRepository.delete(workout);
    }

    public void editWorkout(Long workoutId, WorkoutDTO workoutDTO) {
        Workout workout = this.workoutRepository.findWorkoutById(workoutId);
        workout.setName(workoutDTO.getName());
        workout.setDescription(workoutDTO.getDescription());

        this.clearWorkoutCompounds(workoutId);
        this.bindWorkoutCompounds(workout, workoutDTO);
    }

    private void bindWorkoutCompounds(Workout workout, WorkoutDTO workoutDTO) {
        List<String> exerciseNames = workoutDTO.getWorkoutCompoundsDTOs().stream().map(WorkoutCompoundDTO::getExerciseName).toList();

        List<Exercise> exercises = this.exerciseService.findByNameList(exerciseNames);

        List<WorkoutCompoundDTO> workoutCompoundsDTOs = workoutDTO.getWorkoutCompoundsDTOs();
        for (WorkoutCompoundDTO compoundDTO : workoutCompoundsDTOs) {
            WorkoutCompound workoutCompound = new WorkoutCompound();
            workoutCompound.setExercise(exercises.get(workoutCompoundsDTOs.indexOf(compoundDTO)));
            workoutCompound.setReps(compoundDTO.getReps());
            workoutCompound.setSeries(compoundDTO.getReps());
            workoutCompound.setWorkout(workout);

            this.workoutCompoundRepository.save(workoutCompound);
        }
    }

    private void clearWorkoutCompounds(Long workoutId) {
        List<WorkoutCompound> workoutCompounds = this.workoutCompoundRepository.findByWorkoutId(workoutId);
        for (WorkoutCompound workoutCompound : workoutCompounds) {
            this.workoutCompoundRepository.delete(workoutCompound);
        }
    }

    public List<WorkoutCompoundDTO> findAllWorkoutCompounds() {
        return this.workoutCompoundRepository.findAll().stream().map(WorkoutCompoundDTO::new).toList();
    }

    public WorkoutDTO generateWorkoutByAI(String description) {
        Gson gson = new Gson();
        List<WorkoutCompoundDTO> allWorkoutCompounds = this.findAllWorkoutCompounds();

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
        Workout workout = this.create(workoutDTO);
        workoutDTO.setId(workout.getId());

        return workoutDTO;
    }

}
