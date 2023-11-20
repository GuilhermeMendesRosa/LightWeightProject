import {WorkoutService} from 'src/app/services/workout-service.service';
import {Component, OnInit} from '@angular/core';
import {Workout} from 'src/app/model/workout';
import {WorkoutCompound} from 'src/app/model/workout-compound';
import {ActivatedRoute, Router} from '@angular/router';
import {ExercisesService} from "../../services/exercises.service";
import {Exercise} from "../../model/exercise";

@Component({
  selector: 'app-create-workout',
  templateUrl: './create-workout.component.html',
  styleUrls: ['./create-workout.component.css']
})
export class CreateWorkoutComponent implements OnInit {

  workout: Workout = {
    name: "",
    description: "",
    workoutCompoundsDTOs: [this.createCompound()]
  };

  isEdit: boolean = false;
  workoutId: string | null = null;
  exercises: Exercise[] = [];

  constructor(private workoutService: WorkoutService,
              private exerciseService: ExercisesService,
              private router: Router,
              private route: ActivatedRoute) {
  }

  ngOnInit(): void {
    this.exerciseService.list().subscribe(exercises => {
      this.exercises = exercises;
    })
    this.route.paramMap.subscribe(params => {
      if (params.get('id') != null) {
        this.workoutId = params.get('id');
        this.isEdit = true
        this.bindWorkout();
      }
    });
  }

  bindWorkout() {
    this.workoutService.getById(this.workoutId).subscribe((data: any) => {
      this.workout = data;
      console.log(data);
    }, (error: any) => {
      console.log(error);
    })
  }

  addCompound() {
    this.workout.workoutCompoundsDTOs.push(this.createCompound());
  }

  createCompound(): WorkoutCompound {
    var compound: WorkoutCompound = {
      exerciseName: '',
      reps: 0,
      series: 0,
      muscularGroup: ""
    };
    return compound;
  }

  trackByFn(index: number, item: any): any {
    return item.id; // Supondo que cada item tem uma propriedade 'id' única
  }

  create() {
    this.workoutService.create(this.workout).subscribe(result => {
      this.router.navigate(['/workouts']);
    });
  console.log(this.workout)
  }

  edit() {
    this.workoutService.edit(this.workout).subscribe(result => {
      this.router.navigate(['workouts']);
    });
  }
}
