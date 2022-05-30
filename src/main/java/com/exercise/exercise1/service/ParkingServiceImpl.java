
package com.exercise.exercise1.service;

import com.exercise.exercise1.entity.Parking;
import com.exercise.exercise1.entity.ParkingDTO;
import com.exercise.exercise1.repository.ParkingRepository;

import java.util.List;
import java.util.Objects;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service

public class ParkingServiceImpl
implements ParkingService {

    @Autowired
    private ParkingRepository parkingRepository;

    // Save operation
    @Override
    public Parking saveParking(ParkingDTO parking)
    {
        Parking parkingEntity = new Parking();
        parkingEntity.setParkingPlate(parking.getParkingPlate()); // prendo il parkingplate da parking e lo assegno a quello di entity
        parkingEntity.setParkingExit(parking.getParkingExit());
        parkingEntity.setParkingEntrance(parking.getParkingEntrance());
        return parkingRepository.save(parkingEntity); // qui devo mettere il dto ma visto che non è un entity non posso usare direttamente il metodo save
    }

    // Read operation
    @Override
    public List<Parking> fetchParkingList()
    {
        return (List<Parking>)
                parkingRepository.findAll();
    }

    // Update operation
    @Override
    public Parking
    updateParking(Parking parking, Long parkingId)
    {
        Parking parkDB = parkingRepository.findById(parkingId).get();

        if (Objects.nonNull(parking.getParkingPlate())
                && !"".equalsIgnoreCase(parking.getParkingPlate())) {
            parkDB.setParkingPlate(parking.getParkingPlate());
        }

        if (Objects.nonNull(parking.getParkingEntrance())
                && !"".equalsIgnoreCase(parking.getParkingEntrance())) {
            parkDB.setParkingEntrance(parking.getParkingEntrance());
        }

        if (Objects.nonNull(parking.getParkingExit())
                && !"".equalsIgnoreCase(parking.getParkingExit())) {
            parkDB.setParkingExit(parking.getParkingExit());
        }

        return parkingRepository.save(parkDB);
    }

    // Delete operation
    @Override
    public void deleteParkingById(Long parkingId)
    {
        parkingRepository.deleteById(parkingId);
    }
}


