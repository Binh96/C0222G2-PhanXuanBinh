import { Component, OnInit } from '@angular/core';


@Component({
  selector: 'app-color',
  template: ``

})

export class ColorComponent implements OnInit {

  constructor() { }

  ngOnInit(): void {
  }

  title='color picker';
  color: string = 'red';
  arrayColors: any = {
    color1: '#2883e9', color2: '#e920e9', color3: 'rgb(255,245,0)',color4: 'rgb(236,64,64)', color5: 'rgba(45,208,45,1)',color6: 'rgba(467,221,45,122)'
  }
  selectedColor: string = 'color1';

}
