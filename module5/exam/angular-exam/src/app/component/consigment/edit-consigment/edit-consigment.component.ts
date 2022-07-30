import { Component, OnInit } from '@angular/core';
import { FormControl, FormGroup, Validators } from '@angular/forms';
import { ActivatedRoute, ParamMap, Router } from '@angular/router';
import { Product } from 'src/app/model/product';
import { ConsigmentService } from 'src/app/service/consigment.service';

@Component({
  selector: 'app-edit-consigment',
  templateUrl: './edit-consigment.component.html',
  styleUrls: ['./edit-consigment.component.css']
})
export class EditConsigmentComponent implements OnInit {

  ngProduct = "--Select Product--";
  products: Product[] = [];
  consignmentForm: FormGroup;
  id: number;

  constructor(private consigmentService: ConsigmentService, private activatedRoute: ActivatedRoute, private router: Router) { 
    this.getAllProduct();
    this.activatedRoute.paramMap.subscribe((p: ParamMap) => {
      this.id = parseInt(p.get('id'));
      this.getConsigmentById(this.id);
    });
  }

  ngOnInit(): void {
    this.getAllProduct();
  }

  getAllProduct(){
    this.consigmentService.getAllProduct().subscribe(products => {
      this.products = products;
    });
  }

  getConsigmentById(id: number){
    this.consigmentService.getConsigmentById(id).subscribe(consigment => {
      this.consignmentForm = new FormGroup({
        id: new FormControl(consigment.id),
        codeConsignment: new FormControl(consigment.codeConsignment, [Validators.required, Validators.pattern("^(LH-)[0-9]{4}$")]),
        product: new FormControl(consigment.product.nameProduct, [Validators.required]),
        quantity: new FormControl(consigment.quantity, [Validators.required, Validators.min(0)]),
        dateIn: new FormControl(consigment.dateIn, [Validators.required]),
        dateOut: new FormControl(consigment.dateOut, [Validators.required]),
        endOfDate: new FormControl(consigment.endOfDate, [Validators.required])
      });
    });
  }

  editConsigment(){
    const consigmentEdit = this.consignmentForm.value;
    console.log(consigmentEdit);
    this.consigmentService.editConsigment(consigmentEdit).subscribe(()=>{
      this.router.navigateByUrl("/home");
    });
  }

}
