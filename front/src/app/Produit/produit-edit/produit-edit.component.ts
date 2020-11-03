import { Component, OnInit } from '@angular/core';
import {ActivatedRoute, Router} from '@angular/router';
import {FormBuilder, FormControl, FormGroup, Validators} from '@angular/forms';
import {Categorie} from '../../../model/categorie.model';
import {Type} from '../../../model/type.model';
import {ProduitService} from '../../../services/produit.service';
import {Produit} from '../../../model/produit.model';

@Component({
  selector: 'app-produit-edit',
  templateUrl: './produit-edit.component.html',
  styleUrls: ['./produit-edit.component.css']
})
export class ProduitEditComponent implements OnInit {

  forms: FormGroup;
  type = Type;
  typekeys = Object.keys(this.type);
  categorie = Categorie;
  categoriekeys = Object.keys(this.categorie);
  produit: Produit;


  constructor(private router: Router,
              private formBuilder: FormBuilder,
              private activatedRoute: ActivatedRoute,
              private produitService: ProduitService) {}

  ngOnInit(): void {
    this.initForm();
    this.activatedRoute.queryParams.subscribe(
      (params) => {
        const id = params.id;
        if (id) {
          this.patchValue(id);
        }
      });
  }

  initForm(): void {
    this.forms = this.formBuilder.group({
      id: [''],
      name: ['', Validators.required],
      categorie: [null, Validators.required],
      type: [null, Validators.required],
      description: ['', Validators.required],
      origine: ['', Validators.required],
      prixHT: ['', Validators.required],
      tva: ['', Validators.required],
      //  picture: ['', Validators.required],
      isAvaible: ['', Validators.required],
      descriptionStock: ['', Validators.required]
    });
  }

  onSubmit(): void {
    if (!this.produit || this.produit.id == null) {
      this.produitService.createProduit(this.forms).subscribe(
        next => this.router.navigate(['/admin/products'])
      );
    } else {
      this.produitService.updateProduit(this.forms).subscribe(
        next => this.router.navigate(['/admin/products'])
      );
    }
  }


  private patchValue(id: any): void {
    this.produitService.getProduit(id).subscribe( data => {
      this.produit = data;
      this.forms.patchValue({
        id: data.id,
        name: data.name,
        categorie: data.categorie,
        type: data.type,
        description: data.description,
        origine: data.origine,
        prixHT: data.prixHT,
        tva: data.tva,
        isAvaible: data.isAvaible,
        descriptionStock: data.descriptionStock,
      });
    });
  }
}
