import { Component, OnInit } from '@angular/core';
import { FormControl, FormGroup } from '@angular/forms';
import { Consigment } from 'src/app/model/consigment';
import { Product } from 'src/app/model/product';
import { ConsigmentService } from 'src/app/service/consigment.service';

@Component({
  selector: 'app-list-consigment',
  templateUrl: './list-consigment.component.html',
  styleUrls: ['./list-consigment.component.css']
})
export class ListConsigmentComponent implements OnInit {

  consigments: Consigment[] = [];
  consigmentHasToDelete: Consigment;

  p: number = 1;
  search = new FormGroup({
    nameProduct: new FormControl(""),
    // endOfDate: new FormControl(""),
    // dateInStart: new FormControl(),
    // dateInEnd: new FormControl()
  });
  constructor(private consigmentService: ConsigmentService) { 
  }

  ngOnInit(): void {
    this.getAll()
  }

  getAll(){
    this.consigmentService.getAllConsigment().subscribe(consigments => {
      this.consigments = consigments;     
    });
  }

  findToDelete(id: number){
    this.consigmentService.getConsigmentById(id).subscribe(consigment => {
      this.consigmentHasToDelete = consigment;
    });
  }


  findConsigment(){
    const search = this.search.value;
    console.log(search);
    
    if(search.nameProduct == null){
      this.getAll();
    }
    else{
      // , search.dateInStart, search.endOfDate, search.dateInEnd
      this.consigmentService.getConsigmentByName(search.nameProduct).subscribe((consigments)=>{
        this.consigments = consigments;
        this.search.reset();
        this.ngOnInit();
    });
    }
  }

  delete(id: number){
    this.consigmentService.deleteConsigmentById(id).subscribe(()=>{
      this.ngOnInit();
    });
  }

}
