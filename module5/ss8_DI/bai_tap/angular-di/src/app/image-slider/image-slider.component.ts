import { Component, Inject, OnInit, Optional } from '@angular/core';
import { Image } from './image';
import { GalleryConfig } from './toke';

@Component({
  selector: 'app-image-slider',
  templateUrl: './image-slider.component.html',
  styleUrls: ['./image-slider.component.css']
})
export class ImageSliderComponent implements OnInit {


  image: Image= {};
  active: boolean = false;

  listImage = [
    'https://via.placeholder.com/1280x420/e91e63/ffffff?text=1',
    'https://via.placeholder.com/1280x420/e91e63/ffffff?text=2',
    'https://via.placeholder.com/1280x420/e91e63/ffffff?text=3',
    'https://via.placeholder.com/1280x420/e91e63/ffffff?text=4'
  ];
  i = 0;
  config = 1;
  src = this.listImage[this.i];
  itemWidth: number;

  constructor(@Inject(GalleryConfig) @Optional() config: number) {
    if (config) {
      this.config = config;
    }
  }
  

  ngOnInit(): void {
    this.itemWidth = 100 / this.config;
    console.log(this.active);
  }

  ngOnChanges(){

  }

  next(){
    this.i++;
    if(this.i < this.listImage.length){
      this.active= true;
      this.src= this.listImage[this.i];
      setTimeout(() =>{
        this.active = false;
      }, 1000);
      console.log(this.i);
      
    }
    else{
      this.active= true;
      this.i = 0;
      this.src= this.listImage[this.i];
      setTimeout(() =>{
        this.active = false;
      }, 1000);
    }
  }

  previous(){
    this.i--;
    if(this.i < 0){
      this.active= true;
      this.i = this.listImage.length - 1;
      this.src= this.listImage[this.i];
      setTimeout(() =>{
        this.active = false;
      }, 1000);
    }
    else{
      this.active= true;
      this.src= this.listImage[this.i];
      setTimeout(() =>{
        this.active = false;
      }, 1000);
    }
  }

}
