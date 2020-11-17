import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';

import { RoomService } from '../room.service';
import { Room } from '../Room';

@Component({
  selector: 'app-room-update-room',
  templateUrl: './room-update-room.component.html',
  styleUrls: ['./room-update-room.component.css']
})
export class RoomUpdateRoomComponent implements OnInit {

  id: number;
  room: Room;
  submitted = false;

  constructor(private route: ActivatedRoute, private router: Router, private roomService: RoomService) { }

  ngOnInit(): void {
    this.room = new Room();
    this.id = this.route.snapshot.params['id'];
    this.roomService.readByIdRoom(this.id).subscribe(data => {
      console.log(data);
      this.room = data;
    }, error => console.log(error));
  }

  uptRoom(){
    this.roomService.updateRoom(this.room).subscribe(data => {
      console.log(data), error => console.log(error);
      this.room = new Room();
      this.gotoList();
    });
  }

  onSubmit(){
    this.uptRoom();
  }

  gotoList(){
    this.router.navigate(['/rooms']);
  }

}
