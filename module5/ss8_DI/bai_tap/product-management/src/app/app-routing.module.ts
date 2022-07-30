import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { EditProductComponent } from './products/edit-product/edit-product.component';
import { ProductCreateComponent } from './products/product-create/product-create.component';
import { ProductListComponent } from './products/product-list/product-list.component';


const routes: Routes = [
  {
    path: 'products/product-list',
    component: ProductListComponent
  },
  {
    path: 'products/product-create',
    component: ProductCreateComponent
  },
  {
    path: 'products/edit-product/:id',
    component: EditProductComponent
  }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
