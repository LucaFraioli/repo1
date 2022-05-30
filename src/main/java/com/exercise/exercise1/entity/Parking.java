
package com.exercise.exercise1.entity;

import lombok.*;

// Importing required classes
import javax.persistence.*;

@Entity
@Table(name = "park_ticket")
//@Data  Using @Data for JPA entities is not recommended. It can cause severe performance and memory consumption issues.
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
@Setter
@ToString
// Class
public class Parking {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    @Column(name = "id_ticket")      //quando chiamo parkingId lui capisce che è id_ticket
    private Long parkingId;
    @Column(name = "plate")
    private String parkingPlate;
    @Column(name = "entrance")
    private String parkingEntrance;
    @Column(name = "exit")
    private String parkingExit;
}