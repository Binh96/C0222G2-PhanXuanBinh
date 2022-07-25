import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { ListCategoryComponent } from './category/list-category/list-category.component';
import { CreatCategoryComponent } from './category/creat-category/creat-category.component';
import { DeleteCategoryComponent } from './category/delete-category/delete-category.component';
import { ListProductComponent } from './product/list-product/list-product.component';
import { CreateProductComponent } from './product/create-product/create-product.component';
import { DeleteProductComponent } from './product/delete-product/delete-product.component';


const routes: Routes = [
  {path: 'category/list-category', component: ListCategoryComponent},
  {path: 'category/creat-category', component: CreatCategoryComponent},
  {path: 'category/delete-category', component: DeleteCategoryComponent},
  {path: 'category/edit-category', component: ListCategoryComponent},
  {path: 'product/list-product', component: ListProductComponent},
  {path: 'product/create-product', component: CreateProductComponent},
  {path: 'product/delete-product', component: DeleteProductComponent},
  {path: 'product/edit-product', component: ListProductComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
