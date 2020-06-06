import { MealType } from './meal-type.enum';
import { Dish } from './dish';

export class Meal {
  id: BigInteger;
  name: string;
  type: MealType;
  dishes: Dish[];
}
