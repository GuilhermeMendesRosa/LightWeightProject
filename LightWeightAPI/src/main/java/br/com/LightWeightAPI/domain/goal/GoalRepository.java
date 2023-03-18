package br.com.LightWeightAPI.domain.goal;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface GoalRepository extends JpaRepository<Goal, Long> {

    Goal findGoalById(Long id);

    @Query("SELECT new br.com.LightWeightAPI.domain.goal.GoalDTO(g) FROM Goal g WHERE g.id = :id")
    GoalDTO findGoalDTOById(Long id);
}
