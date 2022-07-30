import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { EditConsigmentComponent } from './component/consigment/edit-consigment/edit-consigment.component';
import { InsertConsigmentComponent } from './component/consigment/insert-consigment/insert-consigment.component';
import { ListConsigmentComponent } from './component/consigment/list-consigment/list-consigment.component';


const routes: Routes = [
  {path: "home", component: ListConsigmentComponent},
  {path: "insert-consigment", component: InsertConsigmentComponent},
  {path: "edit-consigment/:id", component: EditConsigmentComponent},
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
