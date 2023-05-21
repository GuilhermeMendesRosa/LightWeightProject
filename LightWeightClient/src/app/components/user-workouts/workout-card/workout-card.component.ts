import { Component, Input, OnInit } from '@angular/core';
import { Workout } from 'src/app/model/workout';

@Component({
  selector: 'app-workout-card',
  templateUrl: './workout-card.component.html',
  styleUrls: ['./workout-card.component.css']
})
export class WorkoutCardComponent implements OnInit {

  @Input() workout: Workout | undefined;

  constructor() { }

  ngOnInit(): void {
  }

}
