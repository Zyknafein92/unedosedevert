import { Component, OnInit } from '@angular/core';
import {Produit} from '../../../model/produit.model';
import {Router} from '@angular/router';
import {ProduitService} from '../../../services/produit.service';
import {Categorie} from '../../../model/categorie.model';
import {Type} from '../../../model/type.model';

@Component({
  selector: 'app-admin-view-product',
  templateUrl: './admin-view-product.component.html',
  styleUrls: ['./admin-view-product.component.css']
})
export class AdminViewProductComponent implements OnInit {

  produit: Produit;
  produits: Array<Produit>;
  type: Type;
  categorie: Categorie;

  constructor(private router: Router, private produitService: ProduitService) { }

  ngOnInit(): void {
    this.initProduits();
  }

  private initProduits(): void {
    this.produitService.getProduits().subscribe(data => {
        this.produits = data;
        console.log('data : ', data);
      },
      err => {
        console.log('error: ', err.error.message);
      });
  }

  creerProduit(): void {
    this.router.navigate(['admin/products/edit']);
  }

  modifierProduit(id: number): void {
    this.router.navigate(['admin/products/edit'], {queryParams: {id}});
  }

  supprimerProduit(id: number): void {
    this.produitService.deleteProduit(id).subscribe( next => this.initProduits()); }

}
