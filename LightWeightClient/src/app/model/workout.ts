import { WorkoutCompound } from "./workout-compound";

export interface Workout {
  id?: number,
  name: string
  description: string
  compounds: WorkoutCompound[];
}
