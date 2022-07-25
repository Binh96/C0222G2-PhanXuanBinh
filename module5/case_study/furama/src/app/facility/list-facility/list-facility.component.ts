import { Component, OnInit } from '@angular/core';
import { Facility } from 'src/app/facility/facility';
import { FacilityService } from '../facility-service.service';

@Component({
  selector: 'app-list-facility',
  templateUrl: './list-facility.component.html',
  styleUrls: ['./list-facility.component.css']
})
export class ListFacilityComponent implements OnInit {

  p: number=1;

  facilities: Facility[] = [];

  constructor(private facilityService: FacilityService) {
    this.facilities = this.facilityService.getAll();
  }


  ngOnInit(): void {
  }

}
