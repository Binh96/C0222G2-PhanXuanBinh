import { Component, Injectable, OnInit } from '@angular/core';
import { FormControl, FormGroup } from '@angular/forms';
import { ActivatedRoute, ParamMap } from '@angular/router';
import { Observable } from 'rxjs';
import { map } from 'rxjs/operators'
import { Product } from 'src/app/model/product';
import { ProductService } from 'src/app/service/product.service';

@Injectable()
@Component({
  selector: 'app-edit-product',
  templateUrl: './edit-product.component.html',
  styleUrls: ['./edit-product.component.css']
})
export class EditProductComponent implements OnInit {
  id;
  productForm: FormGroup;

  constructor(private editRoute: ActivatedRoute, private editService: ProductService) {
    
  }

  ngOnInit(): void {
    this.editRoute.paramMap.subscribe((p: ParamMap) => {
      this.id = p.get('id');
      this.editById(this.id);
    });
  }

  editById(id: number){
    return this.editService.findById(id).subscribe(product => {
      console.log(product);
      this.productForm = new FormGroup({
        id: new FormControl(product.id),
        name: new FormControl(product.name),
        price: new FormControl(product.price),
        description: new FormControl(product.description)
      });
    });
  }

  updateProduct(){
    const product = this.productForm.value;
    console.log(product);
    this.editService.updateProduct(this.id, product).subscribe(()=>{
      this.productForm.reset();
    });
  }

}
