import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { ImageSliderModule } from './image-slider/image-slider.module';
import { GalleryConfig } from './image-slider/toke';

@NgModule({
  declarations: [
    AppComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    ImageSliderModule
  ],
  providers: [
    {provide: GalleryConfig, useValue: 1}
  ],
  bootstrap: [AppComponent]
})
export class AppModule { }
