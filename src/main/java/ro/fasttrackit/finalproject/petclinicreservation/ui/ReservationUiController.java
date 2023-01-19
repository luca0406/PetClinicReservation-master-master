package ro.fasttrackit.finalproject.petclinicreservation.ui;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import ro.fasttrackit.finalproject.petclinicreservation.service.ReservationService;

import java.util.Optional;

@Controller
@RequestMapping("reservations")
public class ReservationUiController {
    private final ReservationService service;

    public ReservationUiController( ReservationService service ){
        this.service = service;
    }

    @GetMapping
    String reservationPage( Model model, @RequestParam(required = false) Integer showReservation ){
        model.addAttribute("reservations", service.getAll());
        Optional.ofNullable(showReservation)
                .flatMap(service::getReservationId)
                .ifPresent(reservation -> model.addAttribute("showReservation", reservation));
        return "reservations";
    }

}
