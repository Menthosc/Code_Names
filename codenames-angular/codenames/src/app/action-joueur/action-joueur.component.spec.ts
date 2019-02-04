import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { ActionJoueurComponent } from './action-joueur.component';

describe('ActionJoueurComponent', () => {
  let component: ActionJoueurComponent;
  let fixture: ComponentFixture<ActionJoueurComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ ActionJoueurComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(ActionJoueurComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
