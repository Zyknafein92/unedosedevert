import {Categorie} from './categorie.model';
import {Type} from './type.model';

export class Produit {
  id: number;
  categorie: Categorie;
  type: Type;
  description: string;
  origine: string;
  prixHT: number;
  tva: number;
  isAvaible: boolean;
  descriptionStock: string;
}
