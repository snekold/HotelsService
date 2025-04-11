package org.example.hotelsservice.model.entity;

import jakarta.persistence.*;
import lombok.Data;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String username;
    private String password;
    private String history;

    @OneToMany(mappedBy = "user",cascade = CascadeType.ALL)
    private List<HotelRoom> hotelRooms = new ArrayList<>();
}
