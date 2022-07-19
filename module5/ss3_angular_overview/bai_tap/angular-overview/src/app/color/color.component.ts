import { Component, OnInit } from '@angular/core';


@Component({
  selector: 'app-color',
  template: `<p>Choose your monster's colors:</p>

  <div>
      <input type="color" id="head" name="head"
             #nameColor (change)="getColor(nameColor.value)">
      <label for="head">Color</label>
  </div>
  <h3>Color you picker is: <span [style.color] ='color'>{{color}}</span></h3>
  `

})

export class ColorComponent implements OnInit {

  constructor() { }

  ngOnInit(): void {
  }

  color: string = '';

  getColor(nameColor: string){
    this.color = nameColor;
  }

}
