import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { DetailDictionaryComponent } from './dictionary/detail-dictionary/detail-dictionary.component';
import { ListDictionaryComponent } from './dictionary/list-dictionary/list-dictionary.component';


const routes: Routes = [
  {path: "dictionary/list-dictionary", component: ListDictionaryComponent},
  {path: "dictionary/detail-dictionary/:word", component: DetailDictionaryComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
