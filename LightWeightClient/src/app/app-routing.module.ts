import { UserWorkoutsComponent } from './components/user-workouts/user-workouts.component';
import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { WorkoutComponent } from './components/workout/workout.component';
import { CreateWorkoutComponent } from './components/create-workout/create-workout.component';

const routes: Routes = [
  {
    path: "workouts",
    component: UserWorkoutsComponent
  },
  {
    path: "workout/:id",
    component: WorkoutComponent
  },
  {
    path: "create-workout",
    component: CreateWorkoutComponent
  },
  {
    path: "edit-workout/:id",
    component: CreateWorkoutComponent
  },
  {
    path: '',
    redirectTo: 'workouts',
    pathMatch: 'full'
  },
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
