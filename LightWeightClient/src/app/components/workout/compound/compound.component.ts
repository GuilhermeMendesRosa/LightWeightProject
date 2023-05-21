import { Component, Input, OnInit } from '@angular/core';
import { WorkoutCompound } from 'src/app/model/workout-compound';

@Component({
  selector: 'app-compound',
  templateUrl: './compound.component.html',
  styleUrls: ['./compound.component.css']
})
export class CompoundComponent implements OnInit {

  @Input() workoutCompound: WorkoutCompound | undefined;


  constructor() { }

  ngOnInit(): void {
  }

}
