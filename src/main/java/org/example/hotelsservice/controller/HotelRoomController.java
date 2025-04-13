package org.example.hotelsservice.controller;


import lombok.AllArgsConstructor;
import org.example.hotelsservice.model.entity.HotelRoom;
import org.example.hotelsservice.service.HotelRoomService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/hotelRooms")
@AllArgsConstructor
public class HotelRoomController {
    private HotelRoomService hotelRoomService;

    @PostMapping
    public ResponseEntity<HotelRoom> createHotelRoom(@RequestBody HotelRoom hotelRoom) {
        HotelRoom createsHotelRoom = hotelRoomService.createHotelRoom(hotelRoom);
        return ResponseEntity.status(HttpStatus.CREATED).body(createsHotelRoom);
    }

    @GetMapping
    public ResponseEntity<List<HotelRoom>> getAllRooms() {
        List<HotelRoom> rooms = hotelRoomService.getAllRooms();
        return ResponseEntity.ok(rooms);
    }

    @GetMapping("/{id}")
    public ResponseEntity<HotelRoom> getRoomById(@PathVariable Long id) {
        return hotelRoomService.getRoomById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping("/available")
    public ResponseEntity<List<HotelRoom>> getAvailableRooms() {
        List<HotelRoom> freeRooms = hotelRoomService.getAvailableRooms();
        if (freeRooms.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        return ResponseEntity.ok(freeRooms);
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteRoom(@PathVariable Long id) {
        hotelRoomService.deleteRoom(id);
        return ResponseEntity.noContent().build();
    }


}
