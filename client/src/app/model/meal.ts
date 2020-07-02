import { MealType } from './meal-type.enum';
import { Dish } from './dish';

export class Meal {
  id: number;
  name: string;
  type: MealType;
  dishes: Dish[];
}
