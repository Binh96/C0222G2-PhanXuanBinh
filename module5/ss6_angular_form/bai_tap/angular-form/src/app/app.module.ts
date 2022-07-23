import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { ReactiveFormsModule } from '@angular/forms';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { FormSignComponent } from './form-sign/form-sign.component';
import { IdentityRevealedComponent } from './shared/identity-revealed/identity-revealed.component';
import { FormLogInComponent } from './form-log-in/form-log-in.component';

@NgModule({
  declarations: [
    AppComponent,
    FormSignComponent,
    IdentityRevealedComponent,
    FormLogInComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    ReactiveFormsModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
