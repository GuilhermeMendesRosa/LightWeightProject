import {NgModule} from '@angular/core';
import {RouterModule, Routes} from '@angular/router';
import {CreateWorkoutComponent} from './components/create-workout/create-workout.component';
import {DeleteWorkoutComponent} from './components/delete-workout/delete-workout.component';
import {UserWorkoutsComponent} from './components/user-workouts/user-workouts.component';
import {WorkoutComponent} from './components/workout/workout.component';
import {LoginComponent} from "./components/login/login.component";

const routes: Routes = [
  {
    path: "login",
    component: LoginComponent
  },
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
    path: "delete-workout/:id",
    component: DeleteWorkoutComponent
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
export class AppRoutingModule {
}
