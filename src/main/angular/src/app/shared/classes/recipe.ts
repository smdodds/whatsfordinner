import{ Ingredient  } from './ingredient'
export class Recipe {
    id: number;
    name : string;
    description : string;
    ingredients : Array<Ingredient>;
}
