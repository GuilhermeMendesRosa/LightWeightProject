package br.com.LightWeightAPI.domain.exercise;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ExerciseRepository extends JpaRepository<Exercise, Long> {

    List<Exercise> findByMuscularGroup(MuscularGroupEnum muscularGroup);

    Exercise findByName(String exerciseName);

    Exercise findExerciseById(Long exercise);

    @Query("SELECT e FROM Exercise e WHERE e.name in :exerciseNames")
    List<Exercise> findByListName(List<String> exerciseNames);
}
