import { Component, OnInit } from '@angular/core';
import {Router} from '@angular/router';


@Component({
  selector: 'app-user-view-list-product',
  templateUrl: './user-view-list-product.component.html',
  styleUrls: ['./user-view-list-product.component.css']
})
export class UserViewListProductComponent implements OnInit {

  constructor(private router: Router) { }

  ngOnInit(): void {
  }

  voirProduits(categorie: string): void {
    // this.router.navigate(['products/type'], {queryParams: {categorie}});
  }
}
