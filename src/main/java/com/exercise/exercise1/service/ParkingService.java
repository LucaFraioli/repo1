
package com.exercise.exercise1.service;

import com.exercise.exercise1.entity.Parking;
import java.util.List;

public interface ParkingService {

    // Save operation
    Parking saveParking(Parking parking);

    // Read operation
    List<Parking> fetchParkingList();

    // Update operation
    Parking updateParking(Parking parking,Long parkingId);

    // Delete operation
    void deleteParkingById(Long parkingId);

}
