import { ComponentFixture, TestBed } from '@angular/core/testing';

import { NeckpiecesComponent } from './neckpieces.component';

describe('NeckpiecesComponent', () => {
  let component: NeckpiecesComponent;
  let fixture: ComponentFixture<NeckpiecesComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ NeckpiecesComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(NeckpiecesComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
