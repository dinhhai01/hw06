package org.example.redis.service;


import lombok.SneakyThrows;
import org.example.redis.caching.repository.FlightRepository;
import org.example.redis.data.request.BookingFlightRequest;
import org.springframework.stereotype.Service;

@Service
public class FlightService {

    private final FlightRepository flightRepository;

    public FlightService(FlightRepository flightRepository) {
        this.flightRepository = flightRepository;
    }

    @SneakyThrows
    public String booking(BookingFlightRequest bookingFlightRequest){
        String key = bookingFlightRequest.getFlightCode() + bookingFlightRequest.getPositionCode();
        if(flightRepository.isExistingKey(key)){
            return "fail";
        }
        // TODO....

        flightRepository.unlink(key);
        return "success";
    }
}
