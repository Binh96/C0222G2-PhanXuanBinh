import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { AngularRatingBarComponent } from './angular-rating-bar/angular-rating-bar.component';
import { AngularCountdowTimerComponent } from './angular-countdow-timer/angular-countdow-timer.component';

@NgModule({
  declarations: [
    AppComponent,
    AngularRatingBarComponent,
    AngularCountdowTimerComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
