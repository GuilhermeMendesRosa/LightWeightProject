import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { WorkoutService } from 'src/app/services/workout-service.service';

@Component({
  selector: 'app-delete-workout',
  templateUrl: './delete-workout.component.html',
  styleUrls: ['./delete-workout.component.css']
})
export class DeleteWorkoutComponent implements OnInit {

  constructor(private service: WorkoutService, private router: Router, private route: ActivatedRoute) { }

  workoutId: number | undefined;

  ngOnInit(): void {
    this.route.paramMap.subscribe(params => {
      const id = params.get('id');
      if (id !== null) {
        this.workoutId = parseInt(id);
      }
    });
  }

  delete() {
    this.service.delete(this.workoutId).subscribe(result => {
      this.router.navigate(['/workouts']);
    });
  }

  cancel() {
    this.router.navigate(['/']);
  }

}
