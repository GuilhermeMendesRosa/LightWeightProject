import { Component, Input, OnInit } from '@angular/core';
import { Workout } from 'src/app/model/workout';

@Component({
  selector: 'app-workout',
  templateUrl: './workout.component.html',
  styleUrls: ['./workout.component.css']
})
export class WorkoutComponent implements OnInit {

  @Input() workout: Workout | undefined;

  constructor() { }

  ngOnInit(): void {
    this.workout =       {
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
    }
  }

}
