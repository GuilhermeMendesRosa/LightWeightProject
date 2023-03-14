package br.com.LightWeightAPI.domain.workoutsession;

import org.springframework.data.jpa.repository.JpaRepository;

public interface WorkoutSessionRepository extends JpaRepository<WorkoutSession, Long> {
}
