import { Component, OnInit } from '@angular/core';
import { ValidationErrors, ValidatorFn, AbstractControl} from '@angular/forms';

@Component({
  selector: 'app-identity-revealed',
  templateUrl: './identity-revealed.component.html',
  styleUrls: ['./identity-revealed.component.css']
})
export class IdentityRevealedComponent implements OnInit {

  constructor() { }

  ngOnInit(): void {
  }

}

export function forbiddenNameValidator(nameRe: RegExp): ValidatorFn {
  return (control: AbstractControl): ValidationErrors | null => {
    const email = nameRe.test(control.value);
    return ;
  };
}
