import { Component, Input, OnInit, Output, EventEmitter } from '@angular/core';
import { Router } from '@angular/router';
import { Workout } from 'src/app/model/workout';
import { WorkoutService } from 'src/app/services/workout-service.service';

@Component({
  selector: 'app-workout-card',
  templateUrl: './workout-card.component.html',
  styleUrls: ['./workout-card.component.css']
})
export class WorkoutCardComponent implements OnInit {

  @Input() workout: Workout = {
    id: 0,
    name: "",
    description: "",
    workoutCompoundsDTOs: []
  };

  @Output() workoutDeleted: EventEmitter<void> = new EventEmitter<void>();

  constructor(private service: WorkoutService, private router: Router) {
  }

  ngOnInit(): void {
  }

}
