package org.example.redis.controller;


import org.example.redis.data.request.BookingFlightRequest;
import org.example.redis.service.FlightService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/flight-service/api/v1")
public class FlightController {

    private final FlightService flightService;

    public FlightController(FlightService flightService) {
        this.flightService = flightService;
    }

    @PostMapping("/booking")
    public String booking(BookingFlightRequest bookingFlightRequest){
        return flightService.booking(bookingFlightRequest);
    }
}
