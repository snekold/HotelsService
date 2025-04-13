package org.example.hotelsservice.service;

import lombok.RequiredArgsConstructor;
import org.example.hotelsservice.model.entity.HotelRoom;
import org.example.hotelsservice.repository.HotelRoomRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
@RequiredArgsConstructor
public class HotelRoomService {
    private HotelRoomRepository hotelRoomRepository;

    public HotelRoom createHotelRoom(HotelRoom hotelRoom) {
        return hotelRoomRepository.save(hotelRoom);
    }


    public List<HotelRoom> getAllRooms() {
        return hotelRoomRepository.findAll();
    }


    public Optional<HotelRoom> getRoomById(Long id) {
        return hotelRoomRepository.findById(id);
    }


    public List<HotelRoom> getAvailableRooms() {
        return hotelRoomRepository.findByUserIsNull();
    }


    public void deleteRoom(Long id) {
        hotelRoomRepository.deleteById(id);
    }


    public HotelRoom updateRoom(Long id, HotelRoom hotelRoom) {
        HotelRoom existingRoom = hotelRoomRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Room not found"));
            existingRoom.setNumber(hotelRoom.getNumber());
            existingRoom.setData(hotelRoom.getData());
            existingRoom.setPrice(hotelRoom.getPrice());
            existingRoom.setUser(hotelRoom.getUser());
            return hotelRoomRepository.save(existingRoom);
    }
}


