import { Component, OnInit } from '@angular/core';
import { Customer } from '../customer';
import { CustomerService } from '../customer.service';

@Component({
  selector: 'app-list-customer',
  templateUrl: './list-customer.component.html',
  styleUrls: ['./list-customer.component.css']
})
export class ListCustomerComponent implements OnInit {
  p: number = 1;

  customers: Customer[] = [];


  constructor(private customerService: CustomerService) { 
    this.customers.push({id: 'KH-1234', name: 'Nguyễn Văn An', gender: 'Nam', dob: '1990-01-01', numberPhone: '0902131233', 
  email: 'nguyenvanan@gmail.com', address: 'k203/21 Nguyễn Chí Thanh, ĐakNong', type:'Diamond'});
  }

  ngOnInit(): void {
    
  }

}
