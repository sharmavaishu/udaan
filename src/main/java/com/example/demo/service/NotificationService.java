package com.example.demo.service;
import com.example.demo.entity.UserSubscription;
import com.example.demo.repository.UserSubscriptionRepository;

import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NotificationService {
    private final JavaMailSender mailSender;
    private final UserSubscriptionRepository subscriptionRepository;

    public NotificationService(JavaMailSender mailSender,UserSubscriptionRepository subscriptionRepository){
        this.mailSender = mailSender;
        this.subscriptionRepository = subscriptionRepository;
    }

    public void sendNotifications(String flightNumber,String status){
        List<UserSubscription> subscribers = subscriptionRepository.findByFlight_FlightNumber(flightNumber);

        for (UserSubscription subscriber : subscribers) {
            SimpleMailMessage message = new SimpleMailMessage();
            message.setTo(subscriber.getEmail());
            message.setSubject("Flight Status Update");
            message.setText("Your flight " + flightNumber + " is now " + status + ".");
            mailSender.send(message);
        }
    }
}
