import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { ListDictionaryComponent } from './dictionary/list-dictionary/list-dictionary.component';
import { DetailDictionaryComponent } from './dictionary/detail-dictionary/detail-dictionary.component';

@NgModule({
  declarations: [
    AppComponent,
    ListDictionaryComponent,
    DetailDictionaryComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
