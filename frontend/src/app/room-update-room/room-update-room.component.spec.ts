import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { RoomUpdateRoomComponent } from './room-update-room.component';

describe('RoomUpdateRoomComponent', () => {
  let component: RoomUpdateRoomComponent;
  let fixture: ComponentFixture<RoomUpdateRoomComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ RoomUpdateRoomComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(RoomUpdateRoomComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
