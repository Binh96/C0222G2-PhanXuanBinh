import { HttpClient } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { FormControl, FormGroup, Validators } from '@angular/forms';
import { ActivatedRoute, ParamMap } from '@angular/router';
import { Facility } from '../facility';
import { FacilityService } from '../facility-service.service';

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

  id: string;

  facility: Facility;
  facilityForm: FormGroup;

  constructor(private facilityService: FacilityService, private activatedRoute: ActivatedRoute) { 
     
  }

  ngOnInit(): void {
    this.activatedRoute.paramMap.subscribe((p : ParamMap)=>{
      this.id = p.get('id');
      this.getFacilty(this.id);
   });
  }

  getFacilty(id: string){
    this.facilityService.findById(id).subscribe(facility => {
      this.facilityForm = new FormGroup({
        id: new FormControl(facility.id, [Validators.required, Validators.pattern("^(SV-)[0-9]{4}$")]),
        type: new FormControl(facility.type, [Validators.required]),
        nameService: new FormControl(facility.nameService, [Validators.required, Validators.minLength(6)]),
        cost: new FormControl(facility.cost, [Validators.required, Validators.min(1)]),
        typeRent: new FormControl(facility.typeRent, [Validators.required]),
        quantity: new FormControl(facility.quantity, [Validators.required, Validators.min(1)]),
        area: new FormControl(facility.area, [Validators.required, Validators.min(1)]),
        facilityFree: new FormControl(facility.facilityFree, [Validators.required]),
        numberOfFloor: new FormControl(facility.numberOfFloor, [Validators.required, Validators.min(1)]),
        description: new FormControl(facility.description, [Validators.required]),
        standardRoom: new FormControl(facility.standardRoom, [Validators.required]),
        poolArea: new FormControl(facility.poolArea, [Validators.required, Validators.min(1)])
     });
    });
  }

  checkValidator(){
    if(this.roomFacility){
      this.facilityForm.get("description").clearValidators();
      this.facilityForm.get("numberOfFloor").clearValidators();
      this.facilityForm.get("standardRoom").clearValidators();
      this.facilityForm.get("poolArea").clearValidators();
      this.facilityForm.get("description").setErrors(null);
      this.facilityForm.get("numberOfFloor").setErrors(null);
      this.facilityForm.get("standardRoom").setErrors(null);
      this.facilityForm.get("poolArea").setErrors(null);
    }
    if(this.houseFacility){
      this.facilityForm.get("poolArea").clearValidators();
      this.facilityForm.get("facilityFree").clearValidators();
      this.facilityForm.get("poolArea").setErrors(null);
      this.facilityForm.get("facilityFree").setErrors(null);
    }
    if(this.houseFacility){
      this.facilityForm.get("facilityFree").clearValidators();
      this.facilityForm.get("facilityFree").setErrors(null);
    }
    this.facilityForm.updateValueAndValidity();
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

  editFacility(){

  }

}
