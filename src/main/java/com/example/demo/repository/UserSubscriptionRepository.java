package com.example.demo.repository;

import com.example.demo.entity.UserSubscription;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserSubscriptionRepository extends JpaRepository<UserSubscription, Long> {
    List<UserSubscription> findByFlight_FlightNumber(String flightNumber);
}
