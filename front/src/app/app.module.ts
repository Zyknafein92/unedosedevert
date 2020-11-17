import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppComponent } from './app.component';
import { ProduitEditComponent } from './Produit/produit-edit/produit-edit.component';
import { AdresseEditComponent } from './Adresse/adresse-edit/adresse-edit.component';
import { CommandeEditComponent } from './Commande/commande-edit/commande-edit.component';
import { PanierEditComponent } from './Panier/panier-edit/panier-edit.component';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import {MatToolbarModule} from '@angular/material/toolbar';
import {MatIconModule} from '@angular/material/icon';
import {MatButtonModule} from '@angular/material/button';
import {RouterModule} from '@angular/router';
import {AppRoutingModule} from './app-routing.module';
import {HttpClientModule} from '@angular/common/http';
import {FormsModule, ReactiveFormsModule} from '@angular/forms';
import { AdminViewProductComponent } from './Produit/admin-view-product/admin-view-product.component';
import { MenuComponent } from './Menu/menu.component';
import {MatMenuModule} from '@angular/material/menu';
import { ProductViewComponent } from './Produit/view-product/product-view.component';
import { ViewProductsListComponent } from './Produit/view-products-list/view-products-list.component';
import { LoginComponent } from './Auth/login/login.component';
import { CreateUserComponent } from './Auth/create-user/create-user.component';
import { AccueilComponent } from './Accueil/accueil/accueil.component';
import {httpInterceptorProviders} from '../services/security/auth-interceptor.service';
import { CategorieViewProduitComponent } from './Produit/categorie-view-produit/categorie-view-produit.component';
import {CommonModule} from '@angular/common';
import {ViewProductListTypeComponent} from './Produit/view-products-list-type/view-product-list-type.component';
import { CategorieEditComponent } from './Categorie/categorie-edit/categorie-edit.component';
import { TypeEditComponent } from './Type/type-edit/type-edit.component';
import { AdminViewTypesListComponent } from './Type/admin-view-types-list/admin-view-types-list.component';
import { AdminViewCategorieListComponent } from './Categorie/admin-view-categorie-list/admin-view-categorie-list.component';


@NgModule({
  declarations: [
    AppComponent,
    ProduitEditComponent,
    AdresseEditComponent,
    CommandeEditComponent,
    PanierEditComponent,
    AdminViewProductComponent,
    MenuComponent,
    ProductViewComponent,
    ViewProductsListComponent,
    ViewProductListTypeComponent,
    LoginComponent,
    CreateUserComponent,
    AccueilComponent,
    CategorieViewProduitComponent,
    CategorieEditComponent,
    TypeEditComponent,
    AdminViewTypesListComponent,
    AdminViewCategorieListComponent,
  ],
  imports: [
    BrowserModule,
    BrowserAnimationsModule,
    MatToolbarModule,
    MatIconModule,
    MatButtonModule,
    MatMenuModule,
    RouterModule,
    AppRoutingModule,
    HttpClientModule,
    FormsModule,
    ReactiveFormsModule,
    CommonModule
  ],
  providers: [httpInterceptorProviders],
  bootstrap: [AppComponent]
})
export class AppModule { }
