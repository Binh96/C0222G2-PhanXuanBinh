import { Injectable } from '@angular/core';
import { Observable, throwError } from 'rxjs';
import { Product } from '../model/product';
import { HttpClient, HttpErrorResponse } from '@angular/common/http';
import { catchError } from 'rxjs/operators';

const configUrl = 'http://localhost:3000/product';

@Injectable({
  providedIn: 'root'
})
export class ProductService {

  subject: Observable<string>;

  constructor(private http: HttpClient) { }

  getAll(): Observable<Product[]>{
    return this.http.get<Product[]>(configUrl);
  }

  saveProduct(product): Observable<Product>{
    console.log(product);
    return this.http.post<Product>(configUrl, product);
  }

  findById(id: number): Observable<Product>{
    return this.http.get<Product>(configUrl+`/${id}`);
  }

  updateProduct(id: number, product: Product): Observable<Product>{
    console.log(product);
    return this.http.put<Product>(configUrl+`/${id}`, product);
  }

  deleteProduct(id: number): Observable<Product>{
    console.log(id);
    
    return this.http.delete<Product>(configUrl+`/${id}`);
  }
}
