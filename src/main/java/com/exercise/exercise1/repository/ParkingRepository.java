
package com.exercise.exercise1.repository;

import com.exercise.exercise1.entity.Parking;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository

public interface ParkingRepository
        extends CrudRepository<Parking, Long> {
}
