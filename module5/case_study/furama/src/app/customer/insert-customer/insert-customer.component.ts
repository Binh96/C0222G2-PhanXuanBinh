import { Component, OnInit } from '@angular/core';
import { FormControl, FormGroup, Validators } from '@angular/forms';
import { ActivatedRoute, Router } from '@angular/router';
import { CustomerService } from '../customer.service';
import { Customertype } from '../customertype';

@Component({
  selector: 'app-insert-customer',
  templateUrl: './insert-customer.component.html',
  styleUrls: ['./insert-customer.component.css']
})
export class InsertCustomerComponent implements OnInit {

  ngTypeCustomer = "---Option Type Customer---";

  customerType: Customertype[] = [];

  customer: FormGroup;

  constructor(private customerService: CustomerService, private routes: ActivatedRoute, private router: Router) { }

  ngOnInit(): void {
    this.getAllCustomerType();
  }

  createCustomer(){
    if(this.customer.valid){
      this.customerService.createCustomer(this.customer.value).subscribe();
      this.router.navigateByUrl("/list-customer");
    }
  }

  getAllCustomerType(){
    this.customerService.getAllCustomerType().subscribe(customerType =>{
      this.customerType = customerType;
    }, ()=>{

    }, () => {
      this.customer= new FormGroup({
        id: new FormControl("", [Validators.required, Validators.pattern("^(KH-)[0-9]{4}$")]),
        name: new FormControl("", [Validators.required, Validators.minLength(1), Validators.pattern("")]),
        gender: new FormControl("", [Validators.required]),
        dob: new FormControl("", [Validators.required]),
        numberPhone: new FormControl("", [Validators.required, Validators.pattern("^(84+)[0-9]{9}$")]),
        email: new FormControl("", [Validators.required, Validators.email]),
        address: new FormControl("", [Validators.required, Validators.minLength(3)]),
        types: new FormControl("", [Validators.required]),
        idCard: new FormControl("", [Validators.required, Validators.pattern("^[0-9]{9}$")])
      })
    });
  }

}
