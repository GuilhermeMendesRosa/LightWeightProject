import { WorkoutService } from 'src/app/services/workout-service.service';
import { Component, OnInit } from '@angular/core';
import { Workout } from 'src/app/model/workout';
import { WorkoutCompound } from 'src/app/model/workout-compound';
import { Router } from '@angular/router';

@Component({
  selector: 'app-create-workout',
  templateUrl: './create-workout.component.html',
  styleUrls: ['./create-workout.component.css']
})
export class CreateWorkoutComponent implements OnInit {

  name: string = "";
  description: string = "";
  compounds: WorkoutCompound[] = [this.createCompound()];

  constructor(private service: WorkoutService, private router: Router) { }

  ngOnInit(): void {
  }

  addCompound() {
    this.compounds.push(this.createCompound());
  }

  createCompound(): WorkoutCompound {
    var compound: WorkoutCompound = {
      exercise: '',
      reps: 0,
      series: 0
    };
    return compound;
  }

  create() {
    var workout: Workout = {
      name: this.name,
      description: this.description,
      compounds: this.compounds

    }
    this.service.create(workout).subscribe(result => {
      console.log('Workout created successfully:', result);
      this.router.navigate(['/']); // navigate to main page
    });

  }

}
