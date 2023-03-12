package br.com.LightWeightAPI.domain.workoutcompound;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface WorkoutCompoundRepository extends JpaRepository<WorkoutCompound, Long> {
    List<WorkoutCompound> findByWorkoutId(Long WorkoutId);

}
