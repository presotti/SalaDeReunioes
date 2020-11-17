import { RoomDetailsComponent } from './room-details/room-details.component';
import { RoomUpdateRoomComponent } from './room-update-room/room-update-room.component';
import { CreateRoomComponent } from './create-room/create-room.component';
import { RoomListComponent } from './room-list/room-list.component';
import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';


const routes: Routes = [
  { path: 'rooms', component: RoomListComponent },
  { path: 'add', component: CreateRoomComponent },
  { path: 'update/:id', component: RoomUpdateRoomComponent },
  { path: 'details/:id', component: RoomDetailsComponent },
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
