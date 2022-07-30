import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Facility } from './facility';
import { TypeFacility } from './type-facility';

const baseUrl = "http://localhost:3000/facility";
const baseUrlTypeFacility = "http://localhost:3000/type-facility";

@Injectable({
  providedIn: 'root'
})
export class FacilityService {

  constructor(private http: HttpClient) { 

  }

  getAll(): Observable<Facility[]>{
    return this.http.get<Facility[]>(baseUrl);
  }

  createFacility(facility: Facility): Observable<Facility>{
    return this.http.post<Facility>(baseUrl, facility);
  }

  findById(id: string): Observable<Facility>{
    return this.http.get<Facility>(baseUrl+`/${id}`);
  }

  deleteFacility(id: string): Observable<Facility>{
    return this.http.delete<Facility>(baseUrl+`/${id}`);
  }

  editFacility(facility: Facility, id: string): Observable<Facility>{
    return this.http.put<Facility>(baseUrl+`/${id}`, facility);
  }

  getAllFacilitiesType(): Observable<TypeFacility[]>{
    return this.http.get<TypeFacility[]>(baseUrlTypeFacility);
  }

  findByName(search: string): Observable<Facility[]>{
    return this.http.get<Facility[]>(baseUrl+`?nameService=${search}`);
  }

}

