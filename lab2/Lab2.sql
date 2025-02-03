-- Creating the 6 necessary tables
CREATE TABLE Customer_Classification (
    CSTCL_ID INT PRIMARY KEY,
    CSTCL_TYP VARCHAR(100),
    CSTCL_TYP_VALUE VARCHAR(100),
    CSTCL_EFCTV_DT DATE,
    CSTCL_CRUD_VALUE CHAR(1),
    CSTCL_USER_ID VARCHAR(100),
    CSTCL_WS_ID VARCHAR(100),
    CSTCL_PRGM_ID VARCHAR(100),
    CSTCL_HOST_TS TIMESTAMP,
    CSTCL_LOCAL_TS TIMESTAMP,
    CSTCL_ACPT_TS TIMESTAMP,
    CSTCL_ACPT_TS_UTC_OFS TIMESTAMP,
    CSTCL_UUID VARCHAR(100) -- UUID for unique identification
);

CREATE TABLE Customer_Identification (
    CSTID_ID INT PRIMARY KEY,
    CSTID_TYP INT, -- References CSTCL_ID
    CSTID_ITEM VARCHAR(100),
    CSTID_EFCTV_DT DATE,
    FOREIGN KEY (CSTID_TYP) REFERENCES Customer_Classification(CSTCL_ID)
);

CREATE TABLE Customer_Details (
    CSTMR_NO INT PRIMARY KEY,
    CSTMR_TYP VARCHAR(50),
    CSTMR_FULL_NAME VARCHAR(255),
    CSTMR_DOB DATE,
    CSTMR_STATUS VARCHAR(50),
    CSTMR_CONTACT_NO VARCHAR(15),
    CSTMR_MOBILE_NO VARCHAR(15),
    CSTMR_EMAIL_ID VARCHAR(255),
    CSTMR_COUNTRY_ORIG VARCHAR(100),
    CSTMR_EFCTV_DT DATE
);

CREATE TABLE Customer_Name_Components (
    CSTMR_ID INT,
    CSTNM_COMPT_TYP INT, -- References CSTCL_ID
    CSTNM_COMPT_VALUE VARCHAR(255),
    CSTNM_EFCTV_DT DATE,
    PRIMARY KEY (CSTMR_ID, CSTNM_COMPT_TYP),
    FOREIGN KEY (CSTMR_ID) REFERENCES Customer_Details(CSTMR_NO) ON DELETE CASCADE,
    FOREIGN KEY (CSTNM_COMPT_TYP) REFERENCES Customer_Classification(CSTCL_ID) ON DELETE CASCADE
);

CREATE TABLE Customer_Proof_of_Identity (
    CSTMR_ID INT,
    CSTPO_ID_TYP INT, -- References CSTCL_ID for ID type
    CSTPO_TYP_VALUE VARCHAR(100),
    CSTPO_START_DT DATE,
    CSTPO_END_DT DATE,
    CSTPO_EFCTV_DT DATE,
    FOREIGN KEY (CSTMR_ID) REFERENCES Customer_Details(CSTMR_NO) ON DELETE CASCADE,
    FOREIGN KEY (CSTPO_ID_TYP) REFERENCES Customer_Classification(CSTCL_ID) ON DELETE SET NULL
);

CREATE TABLE Customer_Address_Components (
    CSTMR_ID INT,
    CSTAD_COMPT_TYP INT, -- References CSTCL_ID for Address type
    CSTAD_COMPT_VALUE VARCHAR(255),
    CSTAD_EFCTV_DT DATE,
    PRIMARY KEY (CSTMR_ID, CSTAD_COMPT_TYP),
    FOREIGN KEY (CSTMR_ID) REFERENCES Customer_Details(CSTMR_NO) ON DELETE CASCADE,
    FOREIGN KEY (CSTAD_COMPT_TYP) REFERENCES Customer_Classification(CSTCL_ID) ON DELETE CASCADE
);

-- Dummy values for testing
INSERT INTO Customer_Classification 
VALUES (1, 'Individual', 'Basic', '2025-02-03', 'C', 'user1', 'ws1', 'prog1', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP, 'uuid123456');

INSERT INTO Customer_Identification 
VALUES (1, 1, 'P123456789', '2025-02-03');

INSERT INTO Customer_Details 
VALUES (12345, 'Individual', 'John Doe', '1990-01-01', 'Active', '1234567890', '9876543210', 'johndoe@email.com', 'USA', '2025-02-03');

INSERT INTO Customer_Name_Components 
VALUES (12345, 1, 'John', '2025-02-03');

INSERT INTO Customer_Proof_of_Identity 
VALUES (12345, 1, 'P123456789', '2025-02-03', '2025-12-31', '2025-02-03');

INSERT INTO Customer_Address_Components 
VALUES (12345, 1, '123 Main St', '2025-02-03');

-- Selecting from tables to verify
SELECT * FROM customer_classification;
SELECT * FROM customer_identification;
SELECT * FROM customer_details;
SELECT * FROM customer_name_components;
SELECT * FROM customer_proof_of_identity;
SELECT * FROM customer_address_components;