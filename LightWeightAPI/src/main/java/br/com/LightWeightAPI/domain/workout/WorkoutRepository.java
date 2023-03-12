package br.com.LightWeightAPI.domain.workout;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface WorkoutRepository extends JpaRepository<Workout, Long> {

//    @Query("SELECT new br.com.LightWeightAPI.domain.workout.WorkoutDTO(w) FROM Workout w WHERE w.id = :id")
    Workout findWorkoutById(Long id);

}
