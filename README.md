# Flight Notification App

A Spring Boot based Flight Notification application that sends notifications to users based on flight updates. This app provides a service to subscribe users to flight status notifications and send them via email when there are updates regarding their subscribed flights.

## Features

- User can subscribe to flight notifications.
- Notifications are sent via email when the flight status changes.
- Users can view and manage their subscriptions.
- H2 database for managing user subscriptions (can be switched to MySQL or other databases).

## Technologies Used

- **Spring Boot**: For building the backend of the application.
- **H2 Database**: For storing user subscriptions (can be replaced with MySQL).
- **Thymeleaf**: For rendering web pages.
- **Spring Data JPA**: For managing the database interactions.
- **Spring Boot Mail**: For sending email notifications.
- **Lombok**: For reducing boilerplate code.

## Prerequisites

- JDK 21 or higher
- Maven (for building and managing dependencies)
- IDE like IntelliJ IDEA or Eclipse (Optional)

## Setup and Installation

### 1. Clone the Repository
Clone the repository to your local machine:
```bash
git clone https://github.com/yourusername/flight-notification-app.git
