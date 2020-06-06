import { DishType } from './dish-type.enum';
import { Food } from './food';
import { Preparation } from './preparation.enum';

export class Dish {
  id: BigInteger;
  name: string;
  type: DishType;
  ingredients: Food[];
  descriptors: string[];
  preparation: Preparation[];
  saltinessIndex: number;
  spicinessIndex: number;
  sweetnessIndex: number;
  sournessIndex: number;
  bitternessIndex: number;
}
