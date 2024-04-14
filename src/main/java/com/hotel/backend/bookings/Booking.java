package com.hotel.backend.bookings;

import java.sql.Timestamp;

import com.hotel.backend.clients.Client;
import com.hotel.backend.hotels.Hotel;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "bookings")
public class Booking {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name="starts_at")
    private Timestamp startsAt;

    @Column(name="ends_at")
    private Timestamp endsAt;

    @Column(name="room_type")
    private String roomType;

    @ManyToOne
    @JoinColumn(name = "client_id")
    private Client client;

    @ManyToOne
    @JoinColumn(name = "hotel_id")
    private Hotel hotel;
}
