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

}
