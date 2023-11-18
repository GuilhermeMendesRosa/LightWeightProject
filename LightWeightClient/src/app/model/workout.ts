import { WorkoutCompound } from "./workout-compound";

export interface Workout {
  id?: number,
  name: string
  description: string
  workoutCompoundsDTOs: WorkoutCompound[];
}
