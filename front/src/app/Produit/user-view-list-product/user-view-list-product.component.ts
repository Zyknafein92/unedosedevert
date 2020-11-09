import { Component, OnInit } from '@angular/core';
import {Router} from '@angular/router';
import {Categorie} from '../../../model/categorie.model';


@Component({
  selector: 'app-user-view-list-product',
  templateUrl: './user-view-list-product.component.html',
  styleUrls: ['./user-view-list-product.component.css']
})
export class UserViewListProductComponent implements OnInit {

  categorie = Categorie;


  constructor(private router: Router) { }

  ngOnInit(): void {
  }

  voirProduits(categorie: Categorie): void {
    console.log('categorie: ', categorie);
    const key = Object.keys(Categorie).find(k => Categorie[k] === categorie) || '';
    this.router.navigate(['products/categorie'], {queryParams: {categorie: key}});
  }
}
