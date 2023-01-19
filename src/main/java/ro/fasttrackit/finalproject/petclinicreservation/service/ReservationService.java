package ro.fasttrackit.finalproject.petclinicreservation.service;

import org.springframework.stereotype.Service;
import ro.fasttrackit.finalproject.petclinicreservation.model.entity.Reservation;
import ro.fasttrackit.finalproject.petclinicreservation.service.repository.ReservationRepository;

import java.util.List;
import java.util.Optional;

@Service
public class ReservationService {
    private final ReservationRepository repository;

    public ReservationService( ReservationRepository repository ){
        this.repository = repository;
    }

    public List<Reservation> getAll(){
        return repository.findAll();
    }

    public Reservation create( Reservation newReservation ){
        newReservation.setId(null);
        return repository.save(newReservation);
    }

    public Reservation deleteReservation( int reservationId ){
        Optional<Reservation> reservation = repository.findById(reservationId);
        reservation.ifPresent(repository::delete);
        return reservation.orElse(null);
    }

    public Optional<Reservation> replaceReservation( int reservationId, Reservation reservation ){
        return repository.findById(reservationId)
                .map(dbReservation -> patchReservation(dbReservation, reservation))
                .map(repository::save);
    }

    private Reservation patchReservation( Reservation dbReservation, Reservation reservation ){
        dbReservation.setName(reservation.getName());
        dbReservation.setPrice(reservation.getPrice());
        dbReservation.setType(reservation.getType());
        return dbReservation;
    }

    public Optional<Reservation> getReservationId( int reservationId ){
        return repository.findById(reservationId);
    }
}
