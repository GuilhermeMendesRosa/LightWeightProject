package br.com.LightWeightAPI.domain.workout;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface WorkoutRepository extends JpaRepository<Workout, Long> {

    Workout findWorkoutById(Long id);

    @Query("SELECT w.id FROM Workout w WHERE w.user.id = :userId")
    List<Long> findByUserId(Long userId);

}
