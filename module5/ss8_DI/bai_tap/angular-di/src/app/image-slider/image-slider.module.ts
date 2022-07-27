import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { ImageSliderComponent } from './image-slider.component';
import { ImageCardComponent } from './image-card/image-card.component';



@NgModule({
  declarations: [ImageSliderComponent, ImageCardComponent],
  imports: [
    CommonModule
  ],
  exports: [
    ImageSliderComponent
  ]
})
export class ImageSliderModule { }
