import { Workout } from './../../model/workout';
import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-user-workouts',
  templateUrl: './user-workouts.component.html',
  styleUrls: ['./user-workouts.component.css']
})
export class UserWorkoutsComponent implements OnInit {

  workouts: Workout[] = [];

  constructor() { }

  ngOnInit(): void {
     this.workouts = [
       {name: "Treino de Peito", description: "treino focado em peitoral inferior"},
       {name: "Costas", description: "pra ficar largo atrás"},
       {name: "Treino de perna", description: ""}
     ];
  }
}
