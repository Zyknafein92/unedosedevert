import { Component, OnInit } from '@angular/core';
import {ActivatedRoute, Route, Router} from '@angular/router';
import {ProduitService} from '../../../services/produit.service';
import {Produit} from '../../../model/produit.model';
import {SearchCriteria} from '../../../model/search-criteria';



@Component({
  selector: 'app-user-view-type-produit-list',
  templateUrl: './user-view-type-produit-list.component.html',
  styleUrls: ['./user-view-type-produit-list.component.css']
})
export class UserViewTypeProduitListComponent implements OnInit {

  produits: Array<Produit>;
  produit: Produit;
  search: SearchCriteria = {categorie: null, query: null, type: null};

  constructor(private activatedRoute: ActivatedRoute, private router: Router, private produitService: ProduitService) {}

  ngOnInit(): void {
    this.activatedRoute.queryParams.subscribe(
      (params) => {
        this.search.categorie = params.categorie;
        console.log('search', this.search);
        this.produitService.getProduitsBySearch(this.search).subscribe(data => {
          console.log('data: ', data);
          this.produits = data;
        });
      });
  }

  voirProduit(id: number): void {
    this.router.navigate(['product'], {queryParams: {id}});
  }
}
