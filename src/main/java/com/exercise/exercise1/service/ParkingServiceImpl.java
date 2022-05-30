
package com.exercise.exercise1.service;

import com.exercise.exercise1.entity.Parking;
import com.exercise.exercise1.entity.ParkingDTO;
import com.exercise.exercise1.repository.ParkingRepository;

import java.net.URI;
import java.util.List;
import java.util.Objects;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestOperations;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriBuilder;

@Service
@Slf4j

public class ParkingServiceImpl
implements ParkingService {

    @Autowired
    private ParkingRepository parkingRepository;


    // Save operation
    @Override
    public Parking saveParking(ParkingDTO parking, Long idUser)
    {
        Parking parkingEntity = new Parking();
        parkingEntity.setParkingPlate(parking.getParkingPlate()); // prendo il parkingplate da parking e lo assegno a quello di entity
        parkingEntity.setParkingExit(parking.getParkingExit());
        parkingEntity.setParkingEntrance(parking.getParkingEntrance());
        parkingEntity.setIdUser(idUser);
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

    @Override
    public Long retrieveIdByCode(String code) {
        URI url = URI.create("http://localhost:8084/api/customer/request/" + code);

        RestTemplate restTemplate = new RestTemplate();
        Long result = restTemplate.getForObject(url, Long.class);

       //RestTemplate restTemplate = new RestTemplate();
       //Long result = restTemplate.getForObject(url, Long.class);
        log.debug(result.toString());
        return result;
    }
}


