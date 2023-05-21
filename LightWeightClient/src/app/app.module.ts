import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { UserWorkoutsComponent } from './components/user-workouts/user-workouts.component';
import { HeaderComponent } from './components/header/header.component';
import { WorkoutCardComponent } from './components/user-workouts/workout-card/workout-card.component';
import { WorkoutComponent } from './components/workout/workout.component';
import { CompoundComponent } from './components/workout/compound/compound.component';

@NgModule({
  declarations: [
    AppComponent,
    UserWorkoutsComponent,
    HeaderComponent,
    WorkoutCardComponent,
    WorkoutComponent,
    CompoundComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
