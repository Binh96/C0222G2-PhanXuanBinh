import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { FormsModule } from '@angular/forms';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { HeaderComponent } from './header/header.component';
import { HeadComponent } from './head/head.component';
import { FooterComponent } from './footer/footer.component';
import { LibrariesComponent } from './libraries/libraries.component';
import { ListCustomerComponent } from './customer/list-customer/list-customer.component';
import { InsertCustomerComponent } from './customer/insert-customer/insert-customer.component';
import { EditCustomerComponent } from './customer/edit-customer/edit-customer.component';
import { ListFacilityComponent } from './facility/list-facility/list-facility.component';
import { InsertFacilityComponent } from './facility/insert-facility/insert-facility.component';
import { HomeComponent } from './home/home.component';
import { EditFacilityComponent } from './facility/edit-facility/edit-facility.component';

@NgModule({
  declarations: [
    AppComponent,
    HeaderComponent,
    HeadComponent,
    FooterComponent,
    LibrariesComponent,
    ListCustomerComponent,
    InsertCustomerComponent,
    EditCustomerComponent,
    ListFacilityComponent,
    InsertFacilityComponent,
    HomeComponent,
    EditFacilityComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    FormsModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
