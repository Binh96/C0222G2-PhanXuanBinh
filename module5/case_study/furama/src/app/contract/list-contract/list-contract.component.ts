import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { Contract } from '../contract';
import { ContractService } from '../contract-service.service';

@Component({
  selector: 'app-list-contract',
  templateUrl: './list-contract.component.html',
  styleUrls: ['./list-contract.component.css']
})
export class ListContractComponent implements OnInit {
  p: number = 1;

  contracts: Contract[] = [];

  constructor(private contractService: ContractService,  private activeRoute: ActivatedRoute) { }

  ngOnInit(): void {
    this.getAll();
  }

  getAll(){
    this.contracts = this.contractService.getAll();
  }

}
