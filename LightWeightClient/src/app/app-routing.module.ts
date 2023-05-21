import { UserWorkoutsComponent } from './components/user-workouts/user-workouts.component';
import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { WorkoutComponent } from './components/workout/workout.component';

const routes: Routes = [
  {
    path: "workouts",
    component: UserWorkoutsComponent
  },
  {
    path: "workout",
    component: WorkoutComponent
  },
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
