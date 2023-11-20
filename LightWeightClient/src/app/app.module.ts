import {NgModule} from '@angular/core';
import {BrowserModule} from '@angular/platform-browser';
import {HTTP_INTERCEPTORS, HttpClientModule} from '@angular/common/http'; // Importe o HttpClientModule
import {FormsModule} from '@angular/forms';

import {AppRoutingModule} from './app-routing.module';
import {AppComponent} from './app.component';
import {UserWorkoutsComponent} from './components/user-workouts/user-workouts.component';
import {HeaderComponent} from './components/header/header.component';
import {WorkoutCardComponent} from './components/user-workouts/workout-card/workout-card.component';
import {WorkoutComponent} from './components/workout/workout.component';
import {CompoundComponent} from './components/workout/compound/compound.component';
import {CreateWorkoutComponent} from './components/create-workout/create-workout.component';
import {DeleteWorkoutComponent} from './components/delete-workout/delete-workout.component';
import {LoginComponent} from './components/login/login.component';
import {AuthInterceptor} from "./auth/auth.interceptor";
import { RegisterComponent } from './components/register/register.component';

@NgModule({
  declarations: [
    AppComponent,
    UserWorkoutsComponent,
    HeaderComponent,
    WorkoutCardComponent,
    WorkoutComponent,
    CompoundComponent,
    CreateWorkoutComponent,
    DeleteWorkoutComponent,
    LoginComponent,
    RegisterComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule,
    FormsModule
  ],
  providers: [
    {
      provide: HTTP_INTERCEPTORS,
      useClass: AuthInterceptor,
      multi: true
    }
  ],
  bootstrap: [AppComponent]
})
export class AppModule {
}
