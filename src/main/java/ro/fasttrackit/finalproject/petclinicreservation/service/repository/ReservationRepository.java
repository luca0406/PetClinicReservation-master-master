package ro.fasttrackit.finalproject.petclinicreservation.service.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ro.fasttrackit.finalproject.petclinicreservation.model.ReservationType;
import ro.fasttrackit.finalproject.petclinicreservation.model.entity.Reservation;

public interface ReservationRepository extends JpaRepository <Reservation, Integer>{
}
