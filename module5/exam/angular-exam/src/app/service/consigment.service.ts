import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Consigment } from '../model/consigment';
import { Product } from '../model/product';

const baseUrl1 = 'http://localhost:8080/store/consignment';
const baseUrl2 = 'http://localhost:8080/store/product';
const baseUrlGetConsignment = 'http://localhost:8080/store/getConsignment';
const baseUrlUpdateConsignment = 'http://localhost:8080/store/updateConsignment';
const baseUrlGetConsignmentByAll = 'http://localhost:8080/store/getConsignmentByAll';

@Injectable({
  providedIn: 'root'
})
export class ConsigmentService {

  constructor(private http: HttpClient) { }

  getAllConsigment(): Observable<Consigment[]>{
    return this.http.get<Consigment[]>(baseUrl1);
  }

  getAllProduct(): Observable<Product[]>{
    return this.http.get<Product[]>(baseUrl2);
  }

  getConsigmentById(id: number): Observable<Consigment>{
    return this.http.get<Consigment>(baseUrlGetConsignment+`?id=${id}`);
  }

  // , dateInStart: string, endOfDate: string, dateInEnd: string, &dateIn_where=${dateInStart}&dateIn_where=${dateInEnd}&endOfDate_where=${endOfDate}
  getConsigmentByName(consignment: Consigment): Observable<Consigment[]>{
    return this.http.get<Consigment[]>(baseUrlGetConsignmentByAll);
  }

  createConsigment(consigment: Consigment): Observable<Consigment>{
    return this.http.post<Consigment>(baseUrl1, consigment);
  }

  editConsigment(consigment: Consigment): Observable<Consigment>{
    return this.http.patch<Consigment>(baseUrlUpdateConsignment, consigment);
  }

  deleteConsigmentById(id: number): Observable<Consigment>{
    return this.http.delete<Consigment>(baseUrl1+`?id=${id}`);
  }
  
}
