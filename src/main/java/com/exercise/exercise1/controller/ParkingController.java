
package com.exercise.exercise1.controller;

import com.exercise.exercise1.entity.Parking;
import com.exercise.exercise1.service.ParkingService;
import java.util.List;

import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController

public class ParkingController {

    @Autowired private ParkingService parkingService;

    // Save operation
    @PostMapping("/departments")
    public Parking saveParking(
            @Valid
            @RequestBody Parking parking)
    {
        return parkingService.saveParking(parking);
    }

    // Read operation
    @GetMapping("/departments")
    public List<Parking> fetchParkingList()
    {
        return parkingService.fetchParkingList();
    }

    // Update operation
    @PutMapping("/departments/{id}")
    public Parking updateParking(@RequestBody Parking parking,@PathVariable("id") Long parkingId)
    {
        return parkingService.updateParking(
                parking, parkingId);
    }

    // Delete operation
    @DeleteMapping("/departments/{id}")
    public String deleteParkingById(@PathVariable("id")
                                       Long parkingId)
    {
       parkingService.deleteParkingById(
                parkingId);

        return "Deleted Successfully";
    }
}