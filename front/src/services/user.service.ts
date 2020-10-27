import { Injectable } from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {Observable} from 'rxjs';
import {User} from '../model/user.model';


@Injectable({
  providedIn: 'root'
})

export class UserService {
  private URL = 'http://localhost:8080/api/user';

  constructor(private http: HttpClient) { }

  getUsers(): Observable<Array<User>> {
    return this.http.get<Array<User>>(this.URL);
  }

  getUser(id: number): Observable<User> {
    return this.http.get<User>(`${this.URL}/${id}`);
  }

  createUser(user: User): Observable < User> {
    return this.http.post<User>(this.URL, user);
  }

  updateUser(user: User): Observable<User> {
    return this.http.put<User>(`${this.URL}`, user);
  }

  deleteUser(id: number): Observable<User> {
    return this.http.delete<User>(`${this.URL}/${id}`);
  }

}
