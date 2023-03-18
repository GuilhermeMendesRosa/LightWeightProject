package br.com.LightWeightAPI.domain.exercise;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ExerciseRepository extends JpaRepository<Exercise, Long> {

    List<Exercise> findByMuscularGroup(MuscularGroupEnum muscularGroup);

    Exercise findByName(String exerciseName);

    Exercise findExerciseById(Long exercise);

}
