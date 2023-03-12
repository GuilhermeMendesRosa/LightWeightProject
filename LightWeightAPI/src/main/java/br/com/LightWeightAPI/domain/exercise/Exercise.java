package br.com.LightWeightAPI.domain.exercise;

import jakarta.persistence.*;
import lombok.*;

@Table(name = "exercises")
@Entity(name = "Exercise")
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
@Getter
@Setter
public class Exercise {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(insertable = false, updatable = false)
    private Long id;

    private String name;

    @Enumerated(EnumType.ORDINAL)
    private MuscularGroupEnum muscularGroup;

}
