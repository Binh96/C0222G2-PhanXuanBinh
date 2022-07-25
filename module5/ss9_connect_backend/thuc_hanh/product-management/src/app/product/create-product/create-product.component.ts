import { Component, OnInit } from '@angular/core';
import { FormControl, FormGroup } from '@angular/forms';
import { ActivatedRoute, Router } from '@angular/router';
import { Catagory } from 'src/app/catagory';
import { CategoryService } from 'src/app/category.service';
import { ProductService } from '../product-service.service';

@Component({
  selector: 'app-create-product',
  templateUrl: './create-product.component.html',
  styleUrls: ['./create-product.component.css']
})
export class CreateProductComponent implements OnInit {

  productForm = new FormGroup({
    name: new FormControl(),
    price: new FormControl(),
    description: new FormControl(),
    category: new FormControl()
  });

  categories: Catagory[] = [];

  constructor(private productService: ProductService, private router: Router, private activatedRoute: ActivatedRoute,
    private categoryService: CategoryService) { }

  ngOnInit(): void {
    this.getAllCategory();
  }

  submit(){
    const product = this.productForm.value;
    product.category = {
      id: product.category
    };
    this.productService.saveProduct(product).subscribe(() => {
      alert('Tạo thành công');
      this.productForm.reset();
    }, e => console.log(e));
  }

  getAllCategory() {
    this.categoryService.getAll().subscribe(categoires => {
      this.categories = categoires;
    });
  }

}
