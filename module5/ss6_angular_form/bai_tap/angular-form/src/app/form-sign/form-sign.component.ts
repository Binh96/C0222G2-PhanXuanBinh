import { Component, OnInit } from '@angular/core';
import { AbstractControl, FormControl, FormGroup, Validators } from '@angular/forms';
import { Formsignangular } from '../formsignangular';

@Component({
  selector: 'app-form-sign',
  templateUrl: './form-sign.component.html',
  styleUrls: ['./form-sign.component.css']
})
export class FormSignComponent implements OnInit {

  msg: string = '';
  invalid: boolean;
  formsignList: Formsignangular[] = [];
  account = new FormGroup({
    email: new FormControl('', [Validators.required, Validators.email]),
    password: new FormControl('', [Validators.required, Validators.minLength(6)]),
    confirmPassword: new FormControl('', Validators.required),
    country: new FormControl('', [Validators.required, Validators.minLength(2)]),
    age: new FormControl('', [Validators.required, Validators.min(18)]),
    gender: new FormControl('', [Validators.required]),
    phone: new FormControl('', [Validators.required, Validators.minLength(9), Validators.pattern("^[+84][0-9]{1,9}$")]),
  });

  constructor() { }

  ngOnInit(): void {
  }

  signIn(){
    if(this.checkPassword()){
      this.formsignList.push(this.account.value);
    }
  }

  checkPassword(): boolean{
    if(this.account.value.password != this.account.value.confirmPassword){
      this.invalid = false;
      this.msg = `Invalid password please try again`;
      return false;
    }
    else{
      this.invalid = true;
      return true;
    }
  }

  get email(){
    return this.account.get('email');
  }

  get password(){
    return this.account.get('password');
  }

  get confirmPassword(){
    return this.account.get('confirmPassword');
  }

  get country(){
    return this.account.get('country');
  }

  get age(){
    return this.account.get('age');
  }

  get gender(){
    return this.account.get('gender');
  }
  
  get phone(){
    return this.account.get('phone');
  }

}

