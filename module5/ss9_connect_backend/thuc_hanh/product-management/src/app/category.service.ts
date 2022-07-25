import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { environment } from 'src/environments/environment';
import { Catagory } from './catagory';
const API_URL = `${environment.apiUrl}`;

@Injectable({
  providedIn: 'root'
})
export class CategoryService {

  constructor(private http: HttpClient) { }

  getAll(): Observable<Catagory[]>{
    return this.http.get<Catagory[]>(API_URL + '/category');
  }

  saveCategory(category): Observable<Catagory>{
    return this.http.post<Catagory>(API_URL + '/category', category);
  }

  findById(id: number): Observable<Catagory> {
    return this.http.get<Catagory>(`${API_URL}/category/${id}`);
  }

  updateCategory(id: number, category: Catagory): Observable<Catagory> {
    return this.http.put<Catagory>(`${API_URL}/category/${id}`, category);
  }

  deleteCategory(id: number): Observable<Catagory> {
    return this.http.delete<Catagory>(`${API_URL}/category/${id}`);
  }
}
