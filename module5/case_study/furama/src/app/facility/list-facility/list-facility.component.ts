import { Component, OnInit } from '@angular/core';
import { Facility } from 'src/app/facility/facility';

@Component({
  selector: 'app-list-facility',
  templateUrl: './list-facility.component.html',
  styleUrls: ['./list-facility.component.css']
})
export class ListFacilityComponent implements OnInit {

  facilities: Facility[] = [];

  constructor() {
    this.facilities.push({id: 'SV-1234', nameService: 'Ocean Outit', type: 'villa', typeRent: 'month', quantity: '2', 
  area: '32.3', facilityFree: null, numberOfFloor: '2', description: 'Mới thuê', standardRoom: 'vip', poolArea: '32.3'});
  }


  ngOnInit(): void {
  }

}
