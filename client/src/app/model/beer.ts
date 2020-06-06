import { BeerFlavour } from './beer-flavour.enum';
import { BeerType } from './beer-type.enum';
import { BeerStyle } from './beer-style.enum';

export class Beer {
  id: BigInteger;
  name: string;
  strength: number;
  flavours: BeerFlavour[];
  type: BeerType;
  style: BeerStyle;
}
