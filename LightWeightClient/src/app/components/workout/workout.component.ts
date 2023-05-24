import { Component, Input, OnInit } from '@angular/core';
import { Workout } from 'src/app/model/workout';

@Component({
  selector: 'app-workout',
  templateUrl: './workout.component.html',
  styleUrls: ['./workout.component.css']
})
export class WorkoutComponent implements OnInit {

  @Input() workout: Workout = {
    id: 0,
    name: "",
    description: "",
    compounds: []
  };

  constructor() { }

  ngOnInit(): void {
  }

}
