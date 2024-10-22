package org.example.redis.data.request;

import lombok.Data;
import lombok.experimental.Accessors;

import java.time.LocalDateTime;


@Data
@Accessors(chain = true)
public class BookingFlightRequest {

    private String flightCode;
    private String positionCode;
    private LocalDateTime from;
    private LocalDateTime to;
}
