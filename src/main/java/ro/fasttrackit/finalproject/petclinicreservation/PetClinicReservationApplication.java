package ro.fasttrackit.finalproject.petclinicreservation;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import ro.fasttrackit.finalproject.petclinicreservation.model.ReservationType;
import ro.fasttrackit.finalproject.petclinicreservation.model.entity.Reservation;
import ro.fasttrackit.finalproject.petclinicreservation.service.repository.ReservationRepository;

import java.util.List;

@SpringBootApplication
public class PetClinicReservationApplication {

    public static void main( String[] args ){
        SpringApplication.run(PetClinicReservationApplication.class, args);
    }

    @Bean
    CommandLineRunner asStartUp( ReservationRepository repository ){
        return args -> {
            repository.saveAll(List.of(
                    new Reservation("Alex Tanase", 255.5, ReservationType.WASHED),
                    new Reservation("Alex Tanase", 150.1, ReservationType.HOTEL),
                    new Reservation("Cristian Radulescu", 100, ReservationType.VACCINE)
            ));
        };
    }

}
