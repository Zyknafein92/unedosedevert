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
import { MenuComponent } from './menu/menu.component';
import {MatMenuModule} from '@angular/material/menu';
import { ProductViewComponent } from './Produit/view-product/product-view.component';
import { UserViewListProductComponent } from './Produit/user-view-list-product/user-view-list-product.component';
import { LoginComponent } from './Auth/login/login.component';
import { CreateUserComponent } from './Auth/create-user/create-user.component';
import { AccueilComponent } from './Accueil/accueil/accueil.component';
import {httpInterceptorProviders} from '../services/security/auth-interceptor.service';
import { CategorieViewProduitComponent } from './Produit/categorie-view-produit/categorie-view-produit.component';
import {CommonModule} from '@angular/common';
import {UserViewTypeProduitListComponent} from './Produit/user-view-type-produit-list/user-view-type-produit-list.component';


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
    UserViewListProductComponent,
    UserViewTypeProduitListComponent,
    LoginComponent,
    CreateUserComponent,
    AccueilComponent,
    CategorieViewProduitComponent,
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
