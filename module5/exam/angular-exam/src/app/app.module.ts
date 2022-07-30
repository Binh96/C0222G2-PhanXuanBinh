import {BrowserModule} from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { HttpClientModule} from '@angular/common/http';
import { NgxPaginationModule} from 'ngx-pagination';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { HeaderComponent } from './component/header/header.component';
import { FooterComponent } from './component/footer/footer.component';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { ConsigmentComponent } from './component/consigment/consigment.component';
import { EditConsigmentComponent } from './component/consigment/edit-consigment/edit-consigment.component';
import { InsertConsigmentComponent } from './component/consigment/insert-consigment/insert-consigment.component';
import { ListConsigmentComponent } from './component/consigment/list-consigment/list-consigment.component';

@NgModule({
  declarations: [
    AppComponent,
    HeaderComponent,
    FooterComponent,
    ConsigmentComponent,
    EditConsigmentComponent,
    InsertConsigmentComponent,
    ListConsigmentComponent,

  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule,
    NgxPaginationModule,
    ReactiveFormsModule,
    FormsModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
