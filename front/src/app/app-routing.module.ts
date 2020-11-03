import {RouterModule, Routes} from '@angular/router';
import {NgModule} from '@angular/core';
import {AdminViewProductComponent} from './Produit/admin-view-product/admin-view-product.component';
import {ProduitEditComponent} from './Produit/produit-edit/produit-edit.component';
import {UserViewProductComponent} from './Produit/user-view-product/user-view-product.component';
import {UserViewListProductComponent} from './Produit/user-view-list-product/user-view-list-product.component';
import {UserViewTypeProduitListComponent} from './Produit/user-view-type-produit-list/user-view-type-produit-list.component';


const routes: Routes = [
  { path: 'admin/products', component: AdminViewProductComponent},
  { path: 'admin/products/edit', component: ProduitEditComponent},
  { path: 'products', component: UserViewListProductComponent},
  { path: 'products/type', component: UserViewTypeProduitListComponent},
  { path: 'product', component: UserViewProductComponent},
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})

export class AppRoutingModule { }

