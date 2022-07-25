import { Component, OnInit } from '@angular/core';
import { FormControl, FormGroup } from '@angular/forms';
import { CategoryService } from 'src/app/category.service';

@Component({
  selector: 'app-creat-category',
  templateUrl: './creat-category.component.html',
  styleUrls: ['./creat-category.component.css']
})
export class CreatCategoryComponent implements OnInit {

  categoryForm: FormGroup = new FormGroup({
    name: new FormControl()
  });

  constructor(private categoryService: CategoryService) { }

  ngOnInit(): void {
  }

  submit() {
    const category = this.categoryForm.value;
    this.categoryService.saveCategory(category).subscribe(() => {
      this.categoryForm.reset();
      alert('Tạo thành công');
    }, e => {
      console.log(e);
    });
  }

}
