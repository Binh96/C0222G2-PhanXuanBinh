import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { HttpClientModule } from '@angular/common/http';
import { NgxPaginationModule } from 'ngx-pagination';

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
import { ListContractComponent } from './contract/list-contract/list-contract.component';
import { InsertContractComponent } from './contract/insert-contract/insert-contract.component';
import { FileUploadComponent } from './file-upload/file-upload.component';

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
    EditFacilityComponent,
    ListContractComponent,
    InsertContractComponent,
    FileUploadComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    FormsModule,
    ReactiveFormsModule,
    HttpClientModule,
    NgxPaginationModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
