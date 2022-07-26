import { Component, OnInit } from '@angular/core';
import { FormControl } from '@angular/forms';
import { ActivatedRoute } from '@angular/router';
import { Todo } from './todo';
import { TodoService } from './todo.service';


@Component({
  selector: 'app-todo',
  templateUrl: './todo.component.html',
  styleUrls: ['./todo.component.css']
})
export class TodoComponent implements OnInit {
  id: number;
  todos: Todo[] = [];
  content = new FormControl();

  constructor(private todoService: TodoService, private activatedRoute: ActivatedRoute) { }

  ngOnInit(): void {
    this.getAll();
  }

  toggleTodo(i: number) {
    this.todos[i].complete = !this.todos[i].complete;
  }

  getAll(){
    this.todoService.getAll().subscribe(todos => {
      this.todos = todos;
    });
  }

  change(){
    const value = this.content.value;
    if (value) {
      const todo: Todo = {
        id: this.id++,
        content: value,
        complete: false
      };
      this.todoService.createTodo(todo).subscribe();
      this.content.reset();
    }
  }

  delete(id: string){
    this.todoService.deleteTodo(parseInt(id)).subscribe();
  }

}
