import { Component, OnInit } from '@angular/core';
import { Product } from 'src/app/model/product';
import { ProductService } from 'src/app/service/product.service';
import { ActivatedRoute, ParamMap } from '@angular/router';

@Component({
  selector: 'app-product-list',
  templateUrl: './product-list.component.html',
  styleUrls: ['./product-list.component.css']
})
export class ProductListComponent implements OnInit {
  id;
  products: Product[] = [];

  constructor(private productService: ProductService, private routeList: ActivatedRoute) { 

  }

  ngOnInit(): void {
    this.getAll();
  }

  getAll(){
    this.productService.getAll().subscribe(products => {
      this.products = products;
    });
  }

  delete(id: number){
    this.productService.deleteProduct(id).subscribe();
  }

}
