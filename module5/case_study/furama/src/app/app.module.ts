import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { HeaderComponent } from './header/header.component';
import { HeadComponent } from './head/head.component';
import { FooterComponent } from './footer/footer.component';
import { LibrariesComponent } from './libraries/libraries.component';
import { ListCustomerComponent } from './customer/list-customer/list-customer.component';
import { InsertCustomerComponent } from './customer/insert-customer/insert-customer.component';

@NgModule({
  declarations: [
    AppComponent,
    HeaderComponent,
    HeadComponent,
    FooterComponent,
    LibrariesComponent,
    ListCustomerComponent,
    InsertCustomerComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
