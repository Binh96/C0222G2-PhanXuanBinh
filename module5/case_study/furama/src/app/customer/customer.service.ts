import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Customer } from './customer';
import { Customertype } from './customertype';

const baseUrl = "http://localhost:3300/customer";
const baseUrlCustomertype = "http://localhost:3300/customer-type";

@Injectable({
  providedIn: 'root'
})
export class CustomerService {

  customer: Customer;

  constructor(private http: HttpClient) { }

  getAll(): Observable<Customer[]>{
    return this.http.get<Customer[]>(baseUrl);
  }

  createCustomer(customer: Customer): Observable<Customer>{
    return this.http.post<Customer>(baseUrl, customer);
  }

  findById(id: number): Observable<Customer>{
    return this.http.get<Customer>(baseUrl+`/${id}`);
  }

  deleteCustomer(id: number): Observable<Customer>{
    return this.http.delete<Customer>(baseUrl+`/${id}`);
  }

  editCustomer(customer: Customer, id: number): Observable<Customer>{
    return this.http.patch<Customer>(baseUrl+`/${id}`, customer);
  }

  getAllCustomerType(): Observable<Customertype[]>{
    return this.http.get<Customertype[]>(baseUrlCustomertype);
  }
}
