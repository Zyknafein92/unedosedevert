import { Component, OnInit } from '@angular/core';
import {ActivatedRoute, Router} from '@angular/router';
import {ProduitService} from '../../../services/produit.service';
import {Produit} from '../../../model/produit.model';
import {HttpEvent} from '@angular/common/http';

@Component({
  selector: 'app-user-view-type-produit-list',
  templateUrl: './user-view-type-produit-list.component.html',
  styleUrls: ['./user-view-type-produit-list.component.css']
})
export class UserViewTypeProduitListComponent implements OnInit {

  produits: Array<Produit>;
  produit: Produit;

  constructor(private activatedRoute: ActivatedRoute, private route: Router, private produitService: ProduitService) { }

  ngOnInit(): void {
    this.activatedRoute.queryParams.subscribe(
      (params) => {
        const categorie = params.categorie;
        if (categorie) {
          this.produitService.getProduitsBySearch(categorie).subscribe( data => {
            this.produits = data;
            console.log('Youhou');
          });
        }
      });
  }

}