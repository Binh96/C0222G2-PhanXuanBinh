import { Component, ElementRef, OnInit, ViewChild } from '@angular/core';
import { FormControl, FormGroup, Validators } from '@angular/forms';
import { Facility } from 'src/app/facility/facility';

@Component({
  selector: 'app-insert-facility',
  templateUrl: './insert-facility.component.html',
  styleUrls: ['./insert-facility.component.css']
})
export class InsertFacilityComponent implements OnInit {

  ngTypeService = '---Option Type Service---';
  ngTypeOfRent = '---Option Type Rent---';
  roomFacility: boolean;
  houseFacility: boolean;
  villaFacility: boolean;

  facility = new FormGroup({
    id: new FormControl('', [Validators.required, Validators.pattern("^[SV]/-/d{1,4}")]),
    type: new FormControl('', [Validators.required]),
    nameService: new FormControl('', [Validators.required, Validators.minLength(6)]),
    cost: new FormControl('', [Validators.required, Validators.min(1)]),
    typeRent: new FormControl('', [Validators.required]),
    quantity: new FormControl('', [Validators.required, Validators.min(1)]),
    area: new FormControl('', [Validators.required, Validators.min(1)]),
    facilityFree: new FormControl('', [Validators.required]),
    numberOfFloor: new FormControl('', [Validators.required, Validators.min(1)]),
    description: new FormControl('', [Validators.required]),
    standardRoom: new FormControl('', [Validators.required]),
    poolArea: new FormControl('', [Validators.required, Validators.min(1)])
  });

  constructor() { }

  ngOnInit(): void {
    console.log(this.facility);
  }

  createFacility(){
    
  }

  changeForm(item: string){
    if(item == 'room'){
      this.roomFacility = true;
      this.villaFacility = false;
      this.houseFacility = false;
    }
    if(item == 'house'){
      this.houseFacility = true;
      this.roomFacility = false;
      this.villaFacility = false;
    }
    if(item == 'villa'){
      this.houseFacility = true;
      this.roomFacility = false;
      this.villaFacility = true;
    }
  }


}
