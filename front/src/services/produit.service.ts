import { Injectable } from '@angular/core';
import {Produit} from '../model/produit.model';
import {Observable} from 'rxjs';
import {HttpClient} from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class ProduitService {
  private URL = 'http://localhost:8080/api/produit';

  constructor(private http: HttpClient) { }

  getProduits(): Observable<Array<Produit>> {
    return this.http.get<Array<Produit>>(this.URL);
  }

  getProduit(id: number): Observable<Produit> {
    return this.http.get<Produit>(`${this.URL}/${id}`);
  }

  createProduit(produit: Produit): Observable < Produit> {
    return this.http.post<Produit>(this.URL, produit);
  }

  updateProduit(produit: Produit): Observable<Produit> {
    return this.http.put<Produit>(`${this.URL}`, produit);
  }

  deleteProduit(id: number): Observable<Produit> {
    return this.http.delete<Produit>(`${this.URL}/${id}`);
  }
}
