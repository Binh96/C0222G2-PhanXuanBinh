import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Todo } from './todo';

const apiUrl = "http://localhost:3000/todo";

@Injectable({
  providedIn: 'root'
})
export class TodoService {

  todos: Todo[] = [];

  constructor(private http: HttpClient) { }

  getAll(): Observable<Todo[]>{
    return this.http.get<Todo[]>(apiUrl);
  }

  createTodo(todo: Todo): Observable<Todo>{
    console.log(todo);
    return this.http.post<Todo>(apiUrl, todo);
  }

  deleteTodo(id: number): Observable<Todo>{
    return this.http.delete<Todo>(apiUrl+`/${id}`);
  }
}
