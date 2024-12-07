package com.example.demo.controller;
import com.example.demo.entity.Flight;
import com.example.demo.service.FlightService;
import com.example.demo.service.NotificationService;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FlightController {

    private final FlightService flightService;
    private final NotificationService notificationService;

    public  FlightController(FlightService flightService,NotificationService notificationService){
        this.flightService = flightService;
        this.notificationService = notificationService;
    }

    @PutMapping("/{flightNumber}/status")
    public String updateFlightStatus(@PathVariable String flightNumber, @RequestParam String status) {
        Flight updatedFlight = flightService.updateFlightStatus(flightNumber, status);
        if (updatedFlight != null) {
            notificationService.sendNotifications(flightNumber, status);
            return "Status updated and notifications sent.";
        }
        return "Flight not found.";
    }

}
