package com.exercise.exercise1.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@NoArgsConstructor
@Getter
@Setter
@ToString
public class ParkingDTO {
    private String cf;
    private String parkingPlate;
    private String parkingEntrance;
    private String parkingExit;
}
