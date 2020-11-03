import { ComponentFixture, TestBed } from '@angular/core/testing';

import { UserViewListProductComponent } from './user-view-list-product.component';

describe('UserViewListProductComponent', () => {
  let component: UserViewListProductComponent;
  let fixture: ComponentFixture<UserViewListProductComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ UserViewListProductComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(UserViewListProductComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
