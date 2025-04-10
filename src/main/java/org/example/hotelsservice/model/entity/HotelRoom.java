package org.example.hotelsservice.model.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name = "hotelRooms")
public class HotelRoom {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String number;
    private String data;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user = new User();
}


