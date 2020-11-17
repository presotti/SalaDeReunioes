
import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Room } from './Room';


@Injectable({
  providedIn: 'root'
})
export class RoomService {

  private baseURL = 'http://localhost:8080/api/v1/rooms';

  constructor(private http: HttpClient) { }

  createRoom(room: Room): Observable<Room> {
    return this.http.post<Room>( this.baseURL, room);
  }

  readRooms(): Observable<Room[]> {
    return this.http.get<Room[]>(this.baseURL);
  }

  readByIdRoom(id: number): Observable<Room> {
    const url = `${this.baseURL}/${id}`;
    return this.http.get<Room>(url);
  }

  updateRoom(room: Room): Observable<Room> {
    const url = `${this.baseURL}/${room.id}`;
    return this.http.put<Room>(url, room);
  }

  deleteRoom(id: number): Observable<Room> {
    const url = `${this.baseURL}/${id}`;
    return this.http.delete<Room>(url);
  }
}
