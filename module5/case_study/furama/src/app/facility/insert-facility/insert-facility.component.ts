import { Component, ElementRef, OnInit, SimpleChanges, ViewChild } from '@angular/core';
import { FormBuilder, FormControl, FormGroup, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { Facility } from 'src/app/facility/facility';
import { FacilityService } from '../facility-service.service';
import { TypeFacility } from '../type-facility';

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

  typeFacilities: TypeFacility[] = [];

  facility: FormGroup;
  // facility:  FormGroup;

  constructor(private facilityService: FacilityService, private facilityBuilder: FormBuilder, private route: Router) { 

  }

  ngOnInit(): void {
    this.gettAllFacilytiesType();
    this.facility = new FormGroup({
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
  }

  createFacility(){
    
    if(this.facility.valid){
      if(this.roomFacility || this.houseFacility || this.villaFacility){
        this.facilityService.createFacility(this.facility.value).subscribe(()=>{
          this.route.navigateByUrl('facility/list-facility');
        });
      }
    }
  }

  changeForm(item: string){
    if(item == '3'){
      this.roomFacility = true;
      this.villaFacility = false;
      this.houseFacility = false;
      this.checkValidator();
    }
    if(item == '2'){
      this.houseFacility = true;
      this.roomFacility = false;
      this.villaFacility = false;
      this.checkValidator();
    }
    if(item == '1'){
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

  gettAllFacilytiesType(){
    this.facilityService.getAllFacilitiesType().subscribe(typeFacilities => {
        this.typeFacilities = typeFacilities;
    });
  }


}
