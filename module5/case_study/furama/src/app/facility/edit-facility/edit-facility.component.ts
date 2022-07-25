import { Component, OnInit } from '@angular/core';
import { FormGroup } from '@angular/forms';

@Component({
  selector: 'app-edit-facility',
  templateUrl: './edit-facility.component.html',
  styleUrls: ['./edit-facility.component.css']
})
export class EditFacilityComponent implements OnInit {

  ngTypeService = '---Option Type Service---';
  ngTypeOfRent = '---Option Type Rent---';

  roomFacility: boolean;
  houseFacility: boolean;
  villaFacility: boolean;

  facility: FormGroup;

  constructor() { }

  ngOnInit(): void {
  }

  getFacilty(){
    
  }

  checkValidator(){
    if(this.roomFacility){
      this.facility.get("description").clearValidators();
      this.facility.get("numberOfFloor").clearValidators();
      this.facility.get("standardRoom").clearValidators();
      this.facility.get("poolArea").clearValidators();
      this.facility.get("description").setErrors(null);
      this.facility.get("numberOfFloor").setErrors(null);
      this.facility.get("standardRoom").setErrors(null);
      this.facility.get("poolArea").setErrors(null);
    }
    if(this.houseFacility){
      this.facility.get("poolArea").clearValidators();
      this.facility.get("facilityFree").clearValidators();
      this.facility.get("poolArea").setErrors(null);
      this.facility.get("facilityFree").setErrors(null);
    }
    if(this.houseFacility){
      this.facility.get("facilityFree").clearValidators();
      this.facility.get("facilityFree").setErrors(null);
    }
    this.facility.updateValueAndValidity();
  }

}
