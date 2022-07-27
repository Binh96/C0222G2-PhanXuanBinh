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

  facilityToDelete: Facility;

  constructor(private facilityService: FacilityService) {
   
  }


  ngOnInit(): void {
    this.getAll();
  }

  getAll(){
    // this.facilities = this.facilityService.getList();
    this.facilityService.getAll().subscribe(facilities =>{
      this.facilities = facilities;
    });
  }

  findToDelete(id: string){
    this.facilityService.findById(id).subscribe(
      (facility: Facility) => {
        this.facilityToDelete = facility;
      }
    );
  }

  delete(){
    this.facilityService.deleteFacility(this.facilityToDelete.id).subscribe();
  }

}
