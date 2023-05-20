import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { UserWorkoutsComponent } from './components/user-workouts/user-workouts.component';
import { HeaderComponent } from './components/header/header.component';
import { WorkoutCardComponent } from './components/user-workouts/workout-card/workout-card.component';

@NgModule({
  declarations: [
    AppComponent,
    UserWorkoutsComponent,
    HeaderComponent,
    WorkoutCardComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
