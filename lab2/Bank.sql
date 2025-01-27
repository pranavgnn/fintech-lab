CREATE TABLE Customer (
    customer_id INT PRIMARY KEY,
    first_name VARCHAR(50),
    last_name VARCHAR(50),
    email VARCHAR(100),
    phone_number VARCHAR(15),
    address VARCHAR(200),
    date_of_birth DATE
);

CREATE TABLE Credit (
    credit_id INT PRIMARY KEY,
    customer_id INT,
    amount DECIMAL(10, 2),
    transaction_date DATE,
    FOREIGN KEY (customer_id) REFERENCES Customer (customer_id)
);

CREATE TABLE Debit (
    debit_id INT PRIMARY KEY,
    customer_id INT, 
    amount DECIMAL(10, 2),
    transaction_date DATE,
    FOREIGN KEY (customer_id) REFERENCES Customer (customer_id)
);
