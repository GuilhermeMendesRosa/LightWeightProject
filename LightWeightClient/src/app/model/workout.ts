import { WorkoutCompound } from "./workout-compound";

export interface Workout {
  name: string
  description: string
  compounds: WorkoutCompound[];
}
