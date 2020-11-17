package com.digital.crud.saladereuniao.saladereuniao.controller;

import com.digital.crud.saladereuniao.saladereuniao.exception.resourceNotFoundException;
import com.digital.crud.saladereuniao.saladereuniao.model.Room;
import com.digital.crud.saladereuniao.saladereuniao.repository.roomRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("api/v1/rooms")
public class roomController {

    @Autowired
    private roomRepository _roomRepository;

    @GetMapping()
    public List<Room> getAllRooms(){
        return _roomRepository.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Room>getRoomById(@PathVariable(value = "id") Long roomId) throws resourceNotFoundException{
            Room room = _roomRepository.findById(roomId).orElseThrow(()-> new resourceNotFoundException("Room not found: " + roomId));
            return ResponseEntity.ok(room);
    }

    @PostMapping()
    public Room createRoom(@Valid @RequestBody Room room) {
        return _roomRepository.save(room);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Room> updateRoom(@PathVariable (value = "id") Long roomId, @Valid @RequestBody Room roomDetails) throws resourceNotFoundException{
        Room room = _roomRepository.findById(roomId).orElseThrow(()-> new resourceNotFoundException("Room not found for this id: " + roomId));
        room.setName(roomDetails.getName());
        room.setDate(roomDetails.getDate());
        room.setStartHour(roomDetails.getStartHour());
        room.setEndHour(roomDetails.getEndHour());
        final Room updateRoom = _roomRepository.save(room);
        return ResponseEntity.ok(updateRoom);
    }

    @DeleteMapping("/{id}")
    public Map<String, Boolean> deleteRoom(@PathVariable(value = "id") Long roomId) throws  resourceNotFoundException{
        Room room = _roomRepository.findById(roomId).orElseThrow(()->new resourceNotFoundException("Room not found for this id: " + roomId));
        _roomRepository.delete(room);
        Map<String, Boolean> response = new HashMap<>();
        response.put("deleted", Boolean.TRUE);
        return response;

    }
}
