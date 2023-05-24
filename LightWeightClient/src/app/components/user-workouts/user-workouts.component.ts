import { WorkoutService } from 'src/app/services/workout-service.service';
import { Workout } from './../../model/workout';
import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-user-workouts',
  templateUrl: './user-workouts.component.html',
  styleUrls: ['./user-workouts.component.css']
})
export class UserWorkoutsComponent implements OnInit {

  workouts: Workout[] = [];

  constructor(private service: WorkoutService) {
  }

  ngOnInit(): void {
    this.listWorkouts();
  }

  listWorkouts() {
    this.service.list().subscribe((data: any) => {
      this.workouts = data;
      console.log(data);
    }, (error: any) => {
      console.log(error);
    })
  }

  refreshWorkouts() {
    this.listWorkouts();
  }

}
