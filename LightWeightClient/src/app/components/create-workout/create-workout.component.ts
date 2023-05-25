import { WorkoutService } from 'src/app/services/workout-service.service';
import { Component, Input, OnInit } from '@angular/core';
import { Workout } from 'src/app/model/workout';
import { WorkoutCompound } from 'src/app/model/workout-compound';
import { ActivatedRoute, Router } from '@angular/router';

@Component({
  selector: 'app-create-workout',
  templateUrl: './create-workout.component.html',
  styleUrls: ['./create-workout.component.css']
})
export class CreateWorkoutComponent implements OnInit {

  workout: Workout = {
    name: "",
    description: "",
    compounds: [this.createCompound()]
  };

  isEdit: boolean = false;
  workoutId: string | null = null;

  constructor(private service: WorkoutService, private router: Router, private route: ActivatedRoute) { }

  ngOnInit(): void {
    this.route.paramMap.subscribe(params => {
      if (params.get('id') != null) {
        this.workoutId = params.get('id');
        this.isEdit = true
        this.bindWorkout();
      }
    });
  }

  bindWorkout() {
    this.service.getById(this.workoutId).subscribe((data: any) => {
      this.workout = data;
      console.log(data);
    }, (error: any) => {
      console.log(error);
    })
  }

  addCompound() {
    this.workout.compounds.push(this.createCompound());
  }

  createCompound(): WorkoutCompound {
    var compound: WorkoutCompound = {
      exercise: '',
      reps: 0,
      series: 0
    };
    return compound;
  }

  trackByFn(index: number, item: any): any {
    return item.id; // Supondo que cada item tem uma propriedade 'id' única
  }

  create() {
    this.service.create(this.workout).subscribe(result => {
      this.router.navigate(['/']);
    });
  }

  edit() {
    this.service.edit(this.workout).subscribe(result => {
      this.router.navigate(['/']);
    });
  }
}
