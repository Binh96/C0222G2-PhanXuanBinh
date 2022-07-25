import { Component, OnInit } from '@angular/core';
import { Catagory } from 'src/app/catagory';
import { CategoryService } from 'src/app/category.service';

@Component({
  selector: 'app-list-category',
  templateUrl: './list-category.component.html',
  styleUrls: ['./list-category.component.css']
})
export class ListCategoryComponent implements OnInit {

  categories: Catagory[] = [];

  constructor(private categoryService: CategoryService) { }

  ngOnInit(): void {
    this.getAll();
  }

  getAll(){
    this.categoryService.getAll().subscribe(categories => {
      this.categories = categories;
    });
  }
}
