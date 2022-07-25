import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Facility } from './facility';

@Injectable({
  providedIn: 'root'
})
export class FacilityService {
  
  facility: Facility[] = [];

  constructor(private http: HttpClient) { }

  getAll(): Facility[]{
    return this.facility;
  }

  createFacility(facility: Facility){
    this.facility.push(facility);
  }

}

