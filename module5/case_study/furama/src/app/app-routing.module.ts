import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { ListFacilityComponent } from './facility/list-facility/list-facility.component';
import { InsertFacilityComponent} from './facility/insert-facility/insert-facility.component'
import { ListCustomerComponent } from './customer/list-customer/list-customer.component';
import { InsertCustomerComponent } from './customer/insert-customer/insert-customer.component';
import { EditCustomerComponent } from './customer/edit-customer/edit-customer.component';
import { EditFacilityComponent } from './facility/edit-facility/edit-facility.component';
import { HomeComponent } from './home/home.component';
import { InsertContractComponent } from './contract/insert-contract/insert-contract.component';
import { ListContractComponent } from './contract/list-contract/list-contract.component';


const routes: Routes = [
  {path: '', component: HomeComponent},
  {path: 'facility/list-facility', component: ListFacilityComponent },
  {path: 'facility/insert-facility', component: InsertFacilityComponent },
  {path: 'facility/edit-facility', component: EditFacilityComponent},
  {path: 'customer/list-customer', component: ListCustomerComponent },
  {path: 'customer/insert-customer', component: InsertCustomerComponent },
  {path: 'customer/edit-customer', component: EditCustomerComponent },
  {path: 'contract/insert-contract', component: InsertContractComponent },
  {path: 'contract/list-contract', component: ListContractComponent }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
export const routingComponent = [HomeComponent, ListFacilityComponent, InsertFacilityComponent, EditFacilityComponent, ListCustomerComponent, 
  InsertCustomerComponent, EditCustomerComponent, ListContractComponent, InsertContractComponent];