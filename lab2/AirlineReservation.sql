CREATE TABLE Flight (
    flight_id INT PRIMARY KEY,
    flight_number VARCHAR(50),
    source_airport VARCHAR(100),
    destination_airport VARCHAR(100), 
    departure_time DATE,
    arrival_time DATE
);

CREATE TABLE Passenger (
    passenger_id INT PRIMARY KEY,
    first_name VARCHAR(50),
    last_name VARCHAR(50),
    email VARCHAR(100),
    phone_number VARCHAR(15)
);

CREATE TABLE Reservation (
    reservation_id INT PRIMARY KEY,
    passenger_id INT,
    flight_id INT,
    reservation_date DATE,
    seat_class VARCHAR(20),
    FOREIGN KEY (passenger_id) REFERENCES Passenger(passenger_id),
    FOREIGN KEY (flight_id) REFERENCES Flight(flight_id)
);

CREATE TABLE Ticket (
    ticket_id INT PRIMARY KEY,
    reservation_id INT,
    ticket_price DECIMAL(10, 2),
    status VARCHAR(20),
    FOREIGN KEY (reservation_id) REFERENCES Reservation(reservation_id)
);
