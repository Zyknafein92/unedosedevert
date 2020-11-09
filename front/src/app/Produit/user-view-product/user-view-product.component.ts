import { Component, OnInit } from '@angular/core';
import {Produit} from '../../../model/produit.model';
import {ProduitService} from '../../../services/produit.service';
import {ActivatedRoute, Router} from '@angular/router';

@Component({
  selector: 'app-user-view-product',
  templateUrl: './user-view-product.component.html',
  styleUrls: ['./user-view-product.component.css']
})
export class UserViewProductComponent implements OnInit {

  produit: Produit;

  constructor(private produitService: ProduitService, private activatedRoute: ActivatedRoute) { }

  ngOnInit(): void {
    this.initProduit();
  }

  private initProduit(): Produit {
    this.activatedRoute.queryParams.subscribe(
      (params) => {
        const id = params.id;
        if (id) {
          this.produitService.getProduit(id).subscribe(data => {
            this.produit = data;
          });
        }
      });
    return this.produit;
  }
}
