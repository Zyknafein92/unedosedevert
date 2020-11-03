import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppComponent } from './app.component';
import { ProduitEditComponent } from './Produit/produit-edit/produit-edit.component';
import { AdresseEditComponent } from './Adresse/adresse-edit/adresse-edit.component';
import { CommandeEditComponent } from './Commande/commande-edit/commande-edit.component';
import { UserEditComponent } from './User/user-edit/user-edit.component';
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
import { UserViewProductComponent } from './Produit/user-view-product/user-view-product.component';
import { UserViewListProductComponent } from './Produit/user-view-list-product/user-view-list-product.component';
import { UserViewTypeProduitListComponent } from './Produit/user-view-type-produit-list/user-view-type-produit-list.component';


@NgModule({
  declarations: [
    AppComponent,
    ProduitEditComponent,
    AdresseEditComponent,
    CommandeEditComponent,
    UserEditComponent,
    PanierEditComponent,
    AdminViewProductComponent,
    MenuComponent,
    UserViewProductComponent,
    UserViewListProductComponent,
    UserViewTypeProduitListComponent,
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
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
