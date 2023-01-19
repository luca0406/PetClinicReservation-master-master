package ro.fasttrackit.finalproject.petclinicreservation.controller;

import org.springframework.web.bind.annotation.*;
import ro.fasttrackit.finalproject.petclinicreservation.model.entity.Reservation;
import ro.fasttrackit.finalproject.petclinicreservation.service.ReservationService;

@RestController
@RequestMapping("api/reservations")
public class ReservationController {
    private final ReservationService service;

    public ReservationController( ReservationService service ){
        this.service = service;
    }

    @PostMapping
    Reservation addReservation( @RequestBody Reservation newReservation ){
        return service.create(newReservation);
    }

    @PutMapping("{reservationId}")
    Reservation replaceReservation( @PathVariable int reservationId, @RequestBody Reservation reservation ){
        return service.replaceReservation(reservationId, reservation)
                .orElseThrow(() -> new RuntimeException("Could not find reservation with id " + reservationId));
    }

    @DeleteMapping("{reservationId}")
    Reservation reservationDelete( @PathVariable int reservationId ){
        return service.deleteReservation(reservationId);
    }



}
