import { Component, Input, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { Workout } from 'src/app/model/workout';
import { WorkoutService } from 'src/app/services/workout-service.service';

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
    workoutCompoundsDTOs: []
  };

  workoutId: string | null = "";

  constructor(private route: ActivatedRoute, private service: WorkoutService) { }

  ngOnInit(): void {
    this.route.paramMap.subscribe(params => {
      this.workoutId = params.get('id');
      console.log(this.workoutId);
      this.bindWorkout();
    });
    console.log(this.workout);
  }

  bindWorkout() {
    this.service.getById(this.workoutId).subscribe((data: any) => {
      this.workout = data;
      console.log(data);
    }, (error: any) => {
      console.log(error);
    })
  }

  edit(id: number | undefined) {

  }

}
