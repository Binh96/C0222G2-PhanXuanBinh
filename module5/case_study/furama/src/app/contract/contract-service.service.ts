import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Facility } from '../facility/facility';
import { Contract } from './contract';
import { Observable } from 'rxjs';

const baseUrl = 'http://localhost:3300/contract';

@Injectable({
  providedIn: 'root'
})
export class ContractService {

  contracts: Contract[] = [];

  constructor(private http: HttpClient) { 
    this.contracts.push({codeContract:  "CT-1234", facilityInfor: "Villa",nameCustomer: "Michael Kean", startDate: "2022-01-03", endDate: "2022-01-12", deposit: "1000000"});
    this.contracts.push({codeContract:  "CT-1235", facilityInfor: "Room",nameCustomer: "Lebron James", startDate: "2022-02-03", endDate: "2022-02-12", deposit: "2000000"});
    this.contracts.push({codeContract:  "CT-1236", facilityInfor: "Villa",nameCustomer: "Stephen Curry", startDate: "2022-03-03", endDate: "2022-03-12", deposit: "0"});
    this.contracts.push({codeContract:  "CT-1237", facilityInfor: "House",nameCustomer: "David James", startDate: "2022-04-03", endDate: "2022-04-12", deposit: "1000000"});
    this.contracts.push({codeContract:  "CT-1238", facilityInfor: "Room",nameCustomer: "Michael Jordan", startDate: "2022-05-03", endDate: "2022-05-12", deposit: "0"});
    this.contracts.push({codeContract:  "CT-1239", facilityInfor: "Villa",nameCustomer: "Kevin Durant", startDate: "2022-06-03", endDate: "2022-06-12", deposit: "5000000"});
    this.contracts.push({codeContract:  "CT-1240", facilityInfor: "House",nameCustomer: "Chou Chie Tie", startDate: "2022-07-03", endDate: "2022-07-12", deposit: "3000000"});
    this.contracts.push({codeContract:  "CT-1241", facilityInfor: "House",nameCustomer: "Lin Dan", startDate: "2022-08-03", endDate: "2022-08-12", deposit: "0"});
    this.contracts.push({codeContract:  "CT-1242", facilityInfor: "Villa",nameCustomer: "Chris Exelsen", startDate: "2022-09-03", endDate: "2022-10-12", deposit: "1000000"});
  }

  getAll(){
    return this.contracts;
  }

  createContract(contract: Contract): Observable<Contract>{
    return this.http.post<Contract>(baseUrl, contract);
  }

  findById(id: number): Observable<Contract>{
    return this.http.get<Contract>(baseUrl+`/${id}`);
  }

  deleteContract(id: number): Observable<Contract>{
    return this.http.delete<Contract>(baseUrl+`/${id}`);
  }

  editContract(contract: Contract, id: number): Observable<Contract>{
    return this.http.patch<Contract>(baseUrl+`/${id}`, contract);
  }
}
