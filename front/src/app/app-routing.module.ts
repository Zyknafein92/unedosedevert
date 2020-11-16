import {RouterModule, Routes} from '@angular/router';
import {NgModule} from '@angular/core';
import {AdminViewProductComponent} from './Produit/admin-view-product/admin-view-product.component';
import {ProduitEditComponent} from './Produit/produit-edit/produit-edit.component';
import {ProductViewComponent} from './Produit/view-product/product-view.component';
import {UserViewListProductComponent} from './Produit/user-view-list-product/user-view-list-product.component';
import {UserViewTypeProduitListComponent} from './Produit/user-view-type-produit-list/user-view-type-produit-list.component';
import {LoginComponent} from './Auth/login/login.component';
import {CreateUserComponent} from './Auth/create-user/create-user.component';
import {AccueilComponent} from './Accueil/accueil/accueil.component';


const routes: Routes = [
  { path: 'admin/products', component: AdminViewProductComponent},
  { path: 'admin/products/edit', component: ProduitEditComponent},
  { path: 'products', component: UserViewListProductComponent},
  { path: 'products/categorie', component: UserViewTypeProduitListComponent},
  { path: 'product', component: ProductViewComponent},
  { path: 'login', component: LoginComponent},
  { path: 'user/add', component: CreateUserComponent},
  { path: 'accueil', component: AccueilComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})

export class AppRoutingModule { }

