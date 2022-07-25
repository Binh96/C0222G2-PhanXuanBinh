import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { ReactiveFormsModule } from '@angular/forms';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { HttpClientModule } from '@angular/common/http';
import { ListCategoryComponent } from './category/list-category/list-category.component';
import { CreatCategoryComponent } from './category/creat-category/creat-category.component';
import { EditCategoryComponent } from './category/edit-category/edit-category.component';
import { DeleteCategoryComponent } from './category/delete-category/delete-category.component';
import { DeleteProductComponent } from './product/delete-product/delete-product.component';
import { EditProductComponent } from './product/edit-product/edit-product.component';
import { ListProductComponent } from './product/list-product/list-product.component';
import { CreateProductComponent } from './product/create-product/create-product.component';

@NgModule({
  declarations: [
    AppComponent,
    ListCategoryComponent,
    CreatCategoryComponent,
    EditCategoryComponent,
    DeleteCategoryComponent,
    DeleteProductComponent,
    EditProductComponent,
    ListProductComponent,
    CreateProductComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule,
    ReactiveFormsModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
