import { ComponentFixture, TestBed } from '@angular/core/testing';

import { UserViewTypeProduitListComponent } from './user-view-type-produit-list.component';

describe('UserViewTypeProduitListComponent', () => {
  let component: UserViewTypeProduitListComponent;
  let fixture: ComponentFixture<UserViewTypeProduitListComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ UserViewTypeProduitListComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(UserViewTypeProduitListComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
