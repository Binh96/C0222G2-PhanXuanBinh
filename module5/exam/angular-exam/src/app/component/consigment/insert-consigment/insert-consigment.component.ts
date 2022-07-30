import { Component, OnInit } from '@angular/core';
import { FormControl, FormGroup, Validators } from '@angular/forms';
import { ActivatedRoute, Router } from '@angular/router';
import { Product } from 'src/app/model/product';
import { ConsigmentService } from 'src/app/service/consigment.service';

@Component({
  selector: 'app-insert-consigment',
  templateUrl: './insert-consigment.component.html',
  styleUrls: ['./insert-consigment.component.css']
})
export class InsertConsigmentComponent implements OnInit {

  ngProduct = "--Select Product--";
  products: Product[] = [];
  consigmentForm: FormGroup;

  constructor(private consigmentService: ConsigmentService, private activatedRoute: ActivatedRoute, private router: Router) { }

  ngOnInit(): void {
    this.getAllProduct();
    this.consigmentForm = new FormGroup({
      codeConsignment: new FormControl("", [Validators.required, Validators.pattern("^(LH-)[0-9]{4}$")]),
      product: new FormControl("", [Validators.required]),
      quantity: new FormControl("", [Validators.required, Validators.min(0)]),
      dateIn: new FormControl("", [Validators.required]),
      dateOut: new FormControl("", [Validators.required]),
      endOfDate: new FormControl("", [Validators.required])
    });
  }

  getAllProduct(){
    this.consigmentService.getAllProduct().subscribe(products => {
      this.products = products;
    });
  }

  createConsigment(){
    if(this.consigmentForm.valid){
      const consigment = this.consigmentForm.value;
      console.log(consigment.product);
      this.consigmentService.createConsigment(consigment).subscribe(()=>{
        this.router.navigateByUrl("/home");
      });
    }
  }

}
