import { Component} from '@angular/core';

@Component({
  selector: 'app-calculator',
  template: `<h2>Calculator</h2>
  <label for="">Number no.1:</label>
  <input type="text" id="numberOne" #numberOne>
  <label for="">Number no.2:</label>
  <input type="text" id="numberTwo" #numberTwo>
  <button (click)="calculator(numberOne.value, numberTwo.value, '+')">+</button>
  <button (click)="calculator(numberOne.value, numberTwo.value, '-')">-</button>
  <button (click)="calculator(numberOne.value, numberTwo.value, '*')">*</button>
  <button (click)="calculator(numberOne.value, numberTwo.value, '/')">/</button>
  <h1 style="color:red;">{{result}}</h1>
  <p>{{error}}</p>`
})

export class CalculatorComponent{

  result:string ="";
  error:string = "";
  calculator(numberOne: string, numberTwo: string, operand: string){
    switch(operand){
      case "+":{
        this.result = String(parseInt(numberOne) + parseInt(numberTwo));
        break;
      }
      case "-":{
        this.result = String(parseInt(numberOne) - parseInt(numberTwo));
        break;
      }
      case "*":{
        this.result = String(parseInt(numberOne) * parseInt(numberTwo));
        break;
      }
      case "/":{
        if(parseInt(numberTwo) != 0){
          this.result = String(parseInt(numberOne) / parseInt(numberTwo));
          break;
        }
        else{
          this.error = "Condition not right for this calculator";
        }
      }
    }
  }
}
