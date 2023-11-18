package br.com.LightWeightAPI.domain.exercise;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ExerciseService {

    @Autowired
    private ExerciseRepository exerciseRepository;

    public List<ExerciseDTO> findByMuscularGroup(MuscularGroupEnum muscularGroup) {
        List<ExerciseDTO> exerciseDTOS = this.exerciseRepository.findByMuscularGroup(muscularGroup)
                .stream()
                .map(ExerciseDTO::new)
                .toList();

        return exerciseDTOS;
    }

    public List<ExerciseDTO> list() {
        List<ExerciseDTO> exerciseDTOS = this.exerciseRepository.findAll()
                .stream()
                .map(ExerciseDTO::new)
                .toList();

        return exerciseDTOS;
    }

    public Exercise findByName(String exerciseName) {
        return this.exerciseRepository.findByName(exerciseName);
    }

    public List<Exercise> findByNameList(List<String> exerciseNames) {
        return this.exerciseRepository.findByNameList(exerciseNames);
    }

    public Exercise findExerciseById(Long id) {
        return this.exerciseRepository.findExerciseById(id);
    }
}
