package com.hotel.backend.hosts;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "hosts")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Host {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;
   
    @Column(nullable = false)
    private String email;
   
    @Column(nullable = false)
    private String phone;

}
