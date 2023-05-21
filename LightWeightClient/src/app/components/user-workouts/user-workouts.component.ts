import { Workout } from './../../model/workout';
import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-user-workouts',
  templateUrl: './user-workouts.component.html',
  styleUrls: ['./user-workouts.component.css']
})
export class UserWorkoutsComponent implements OnInit {

  workouts: Workout[] = [];

  constructor() { }

  ngOnInit(): void {
    this.workouts = [
      {
        name: "Treino de Peito",
        description: "treino focado em peitoral inferior",
        compounds: [
          {
            exercise: "supino reto",
            reps: 12,
            series: 4
          },
          {
            exercise: "supino inclinado com halteres",
            reps: 12,
            series: 4
          },
          {
            exercise: "voador",
            reps: 12,
            series: 4
          },
          {
            exercise: "crossover",
            reps: 12,
            series: 4
          }

        ]
      },
      {
        name: "Costas",
        description: "pra ficar largo atrás",
        compounds: [
          {
            exercise: "Remada curvada",
            reps: 12,
            series: 4
          },
          {
            exercise: "puxada frontal",
            reps: 12,
            series: 4
          },
          {
            exercise: "remada maquina",
            reps: 12,
            series: 4
          },
          {
            exercise: "remada cavalinho",
            reps: 12,
            series: 4
          }

        ]
      },
      {
        name: "Treino de perna",
        description: "",
        compounds: [
          {
            exercise: "agachamento livre",
            reps: 12,
            series: 6
          },
          {
            exercise: "flexora",
            reps: 12,
            series: 6
          },
          {
            exercise: "extensora",
            reps: 12,
            series: 6
          }
        ]
      }
    ];
  }
}
