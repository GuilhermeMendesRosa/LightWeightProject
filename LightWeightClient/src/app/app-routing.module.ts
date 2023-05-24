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
    path: "workout/:id",  // Adicionando o parâmetro ':id' na rota
    component: WorkoutComponent
  },
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
