import {Categorie} from './categorie.model';
import {Type} from './type.model';

export class SearchCriteria {
  categorie: Categorie;
  type: Type;
  query: string;
}
