import { Component, OnInit } from '@angular/core';
import { FormControl, FormGroup, Validators } from '@angular/forms';
import { Contract } from '../contract';
import { ContractService } from '../contract-service.service';

@Component({
  selector: 'app-insert-contract',
  templateUrl: './insert-contract.component.html',
  styleUrls: ['./insert-contract.component.css']
})
export class InsertContractComponent implements OnInit {
  ngSelectCustomer = "--Select Customer--";
  ngSelectFacility = "--Select Facility--";

  contract = new FormGroup({
    codeContract: new FormControl("", [Validators.required, Validators.pattern("^(CT-)[0-9]{4}$")]),
    nameCustomer: new FormControl("", [Validators.required]),
    facilityInfor: new FormControl("", [Validators.required]),
    startDate: new FormControl("", [Validators.required]),
    endDate: new FormControl("", [Validators.required]),
    deposit: new FormControl("", [Validators.required, Validators.min(0)])
  });

  constructor(private contractService: ContractService) { }

  ngOnInit(): void {
  }

  createContract(){
    if(this.contract.valid){
      this.contractService.createContract(this.contract.value).subscribe();
    }
  }

}
