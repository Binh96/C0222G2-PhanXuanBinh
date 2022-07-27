import { Component, ElementRef, OnInit, SimpleChanges, ViewChild } from '@angular/core';
import { FormBuilder, FormControl, FormGroup, Validators } from '@angular/forms';
import { Facility } from 'src/app/facility/facility';
import { FacilityService } from '../facility-service.service';

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
    id: new FormControl('', [Validators.required, Validators.pattern("^(SV-)[0-9]{4}$")]),
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

  // facility:  FormGroup;

  constructor(private facilityService: FacilityService, private facilityBuilder: FormBuilder) { 
    // this.facility = this.facilityBuilder.group({
    //   id: ["", [Validators.required, Validators.pattern("^(SV-)[0-9]{4}$")]],
    //   type: ['', [Validators.required]],
    //   nameService: ['', [Validators.required, Validators.minLength(6)]],
    //   cost: ['', [Validators.required, Validators.min(1)]],
    //   typeRent: ['', [Validators.required]],
    //   quantity: ['', [Validators.required, Validators.min(1)]],
    //   area: ['', [Validators.required, Validators.min(1)]],
    //   facilityFree: ['', [Validators.required]],
    //   numberOfFloor: ['', [Validators.required, Validators.min(1)]],
    //   description: ['', [Validators.required]],
    //   standardRoom: ['', [Validators.required]],
    //   poolArea: ['', [Validators.required, Validators.min(1)]]
    // });
  }

  ngOnInit(): void {
    
  }

  createFacility(){
    
    if(this.facility.valid){
      if(this.roomFacility || this.houseFacility || this.villaFacility){
        this.facilityService.createFacility(this.facility.value).subscribe();
        this.facility.reset();
      }
    }
  }

  changeForm(item: string){
    if(item == 'room'){
      this.roomFacility = true;
      this.villaFacility = false;
      this.houseFacility = false;
      this.checkValidator();
    }
    if(item == 'house'){
      this.houseFacility = true;
      this.roomFacility = false;
      this.villaFacility = false;
      this.checkValidator();
    }
    if(item == 'villa'){
      this.houseFacility = true;
      this.roomFacility = false;
      this.villaFacility = true;
      this.checkValidator();
    }
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
