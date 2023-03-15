package br.com.LightWeightAPI.domain.workoutsession;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface WorkoutSessionRepository extends JpaRepository<WorkoutSession, Long> {

    WorkoutSession findWorkoutSessionById(Long id);

    @Query("SELECT new br.com.LightWeightAPI.domain.workoutsession.WorkoutSessionDTO(ws) FROM WorkoutSession ws WHERE ws.id = :id")
    WorkoutSessionDTO findWorkoutSessionDTO(Long id);

}
