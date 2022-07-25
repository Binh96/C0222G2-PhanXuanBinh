import { Component, OnInit } from '@angular/core';
import { FormControl, FormGroup } from '@angular/forms';
import { ActivatedRoute, ParamMap, Router } from '@angular/router';
import { CategoryService } from 'src/app/category.service';

@Component({
  selector: 'app-delete-category',
  templateUrl: './delete-category.component.html',
  styleUrls: ['./delete-category.component.css']
})
export class DeleteCategoryComponent implements OnInit {
  category: FormGroup;
  id: number;

  constructor(private categoryService: CategoryService, private router: Router, private activeRoute: ActivatedRoute) {
    this.activeRoute.paramMap.subscribe((p: ParamMap) => {
      this.id = parseInt(p.get('id'));
      this.getCategory(this.id);
    })
  }

  ngOnInit(): void {
  }

  getCategory(id: number){
    return this.categoryService.findById(id).subscribe( category => {
      this.category = new FormGroup({
        name: new FormControl(category.name)
      });
    });
  }

  deleteCategory(id: number){
    this.categoryService.deleteCategory(id).subscribe(() => {
      this.router.navigate(['/category/list']);
    }, e => { console.log(e);})
  }
}
