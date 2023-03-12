package br.com.LightWeightAPI.domain.Exercise;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ExerciseService {

    @Autowired
    private ExerciseRepository exerciseRepository;

    public List<Exercise> findByMuscularGroup(MuscularGroupEnum muscularGroup) {
        return this.exerciseRepository.findByMuscularGroup(muscularGroup);
    }

}
