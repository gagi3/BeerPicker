import { DishType } from './dish-type.enum';
import { Food } from './food';
import { Preparation } from './preparation.enum';
import { Cuisine } from './cuisine.enum';

export class Dish {
  id: number;
  name: string;
  type: DishType;
  cuisine: Cuisine;
  ingredients: Food[];
  // descriptors: string[];
  preparation: Preparation[];
  saltinessIndex: number;
  spicinessIndex: number;
  sweetnessIndex: number;
  sournessIndex: number;
  bitternessIndex: number;
}
