import { Injectable } from '@angular/core';
import {Produit} from '../model/produit.model';
import {Observable} from 'rxjs';
import {HttpClient} from '@angular/common/http';
import {FormGroup} from '@angular/forms';

@Injectable({
  providedIn: 'root'
})
export class ProduitService {
  private URL = 'http://localhost:8080/api/produits';

  constructor(private http: HttpClient) { }

  getProduits(): Observable<Array<Produit>> {
    return this.http.get<Array<Produit>>(this.URL);
  }

  getProduit(id: number): Observable<Produit> {
    return this.http.get<Produit>(`${this.URL}/${id}`);
  }

  createProduit(form: FormGroup): Observable <FormGroup> {
    return this.http.post<FormGroup>(this.URL, form.value);
  }

  updateProduit(form: FormGroup): Observable<FormGroup> {
    return this.http.put<FormGroup>(`${this.URL}`, form.value);
  }

  deleteProduit(id: number): Observable<Produit> {
    return this.http.delete<Produit>(`${this.URL}/${id}`);
  }
}
