
package com.exercise.exercise1.controller;

import com.exercise.exercise1.entity.Parking;
import com.exercise.exercise1.entity.ParkingDTO;
import com.exercise.exercise1.service.ParkingService;
import java.util.List;

import javax.validation.Valid;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

@Slf4j
@RestController
public class ParkingController {

    @Autowired private ParkingService parkingService;

    // Save operation
    @PostMapping("/departments")
    public Parking saveParking(
            @Valid
            @RequestBody ParkingDTO parking)
    {
        String uri = "http://localhost:8084/api/customer/request/" + parking.getCf();
        RestTemplate restTemplate = new RestTemplate();
        Long result = restTemplate.getForObject(uri, Long.class);
        return parkingService.saveParking(parking, result);
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