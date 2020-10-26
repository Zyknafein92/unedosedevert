import {Commande} from './commande.model';
import {Adresse} from './adresse.model';
import {Panier} from './panier.model';

export class User {
  id: number;
  commandes = new Array<Commande>();
  adresses = new Array<Adresse>();
  panier: Panier;
  nom: string;
  prenom: string;
  anniversaire: Date;
  telephone: string;
  email: string;
  password: string;
  active: boolean;
}
