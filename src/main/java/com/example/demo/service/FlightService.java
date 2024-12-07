package com.example.demo.service;
import com.example.demo.entity.Flight;
import com.example.demo.repository.FlightRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FlightService {
   private final FlightRepository flightRepository;

    public FlightService(FlightRepository flightRepository){
        this.flightRepository = flightRepository;
    }

    public List<Flight> getAllFlights(){
        return flightRepository.findAll();
    }

    public Flight updateFlightStatus(String flightNumber, String status){
        Flight flight = flightRepository.findByFlightNumber(flightNumber);

        if(flight != null){
            flight.setStatus(status);
            return flightRepository.save(flight);
        }

        return null;
    }
}
