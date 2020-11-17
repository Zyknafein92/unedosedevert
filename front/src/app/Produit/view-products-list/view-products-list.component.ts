import { Component, OnInit } from '@angular/core';
import {Router} from '@angular/router';
import {Categorie} from '../../../model/categorie.model';
import {CategoriesService} from '../../../services/categorie.service';
import {TypeService} from '../../../services/type.service';
import {Type} from '../../../model/type.model';


@Component({
  selector: 'app-user-view-list-product',
  templateUrl: './view-products-list.component.html',
  styleUrls: ['./view-products-list.component.css']
})
export class ViewProductsListComponent implements OnInit {

  categorie: Categorie;
  categories: Array<Categorie>;
  types: Array<Type>;


  constructor(private router: Router, private categorieService: CategoriesService, private typeService: TypeService) { }

  ngOnInit(): void {
    this.initCategories();
    this.initTypes();
  }

  voirProduits(id: number): void {
    console.log('categorie: ', id);
    // const key = Object.keys(Categorie).find(k => Categorie[k] === categorie) || '';
    this.router.navigate(['products/categorie'], {queryParams: {id}});
  }

  private initCategories(): void {
    this.categorieService.getCategories().subscribe( data => {
      this.categories = data;
    });
  }

  private initTypes(): void {
    this.typeService.getTypes().subscribe( data => {
      this.types = data;
    });
  }
}