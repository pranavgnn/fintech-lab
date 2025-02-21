[![Review Assignment Due Date](https://classroom.github.com/assets/deadline-readme-button-22041afd0340ce965d47ae6ef1cefeee28c7c493a6346c4f15d667ab976d596c.svg)](https://classroom.github.com/a/IWjcQDMP)

# Lab 5 and 6 - CRUD Operations API

## 1. Requirement of new CUSTOMER_NAME table

I added an [Entity](https://github.com/PRAKASH-K-A/lab5-and-lab-6-pranavgnn/blob/main/src/main/java/com/mit/entity/CustomerName.java) class and a [Repository](https://github.com/PRAKASH-K-A/lab5-and-lab-6-pranavgnn/blob/main/src/main/java/com/mit/repository/CustomerNameRepository.java) class for CUSTOMER_NAME.

I then did `@OneToOne` mapping between CUSTOMER_DETAILS and CUSTOMER_NAME tables.

---
## 2. Test

My dummy JSON data used for testing:

```json
{
  "customerName": {
    "firstName": "John",
    "middleName": "Michael",
    "lastName": "Doe"
  },
  "dateOfBirth": "1990-05-15",
  "customerContactInformations": [
    {
      "type": "Email",
      "value": "johndoe@example.com"
    },
    {
      "type": "Phone",
      "value": "+1234567890"
    }
  ],
  "customerIdentifications": [
    {
      "type": 1,
      "item": "Passport"
    },
    {
      "type": 2,
      "item": "Driver's License"
    }
  ],
  "customerProofOfIds": [
    {
      "type": "Aadhar Card",
      "value": "1234-5678-9012",
      "startDate": "2015-08-01",
      "endDate": "2035-08-01"
    },
    {
      "type": "PAN Card",
      "value": "ABCDE1234F",
      "startDate": "2010-04-10",
      "endDate": "2030-04-10"
    }
  ]
}
```

1. POST Request
![image](https://github.com/user-attachments/assets/6cfa85f0-084a-41fe-9772-b1915f1bcf1f)

2. GET Request (all records)
![image](https://github.com/user-attachments/assets/179f3bd9-5834-4288-b6e1-4f3bbd756298)

3. GET Request (by id)
![image](https://github.com/user-attachments/assets/bf2bae82-d2bd-4ae4-87da-34f8ec85ba66)

4. PUT Request
![image](https://github.com/user-attachments/assets/7f5fe886-4492-4523-a40a-0cb1d74d4a07)

5. DELETE Request
![image](https://github.com/user-attachments/assets/b8de913a-2183-465e-b328-ceb69925e4cd)

6. GET Request (all records) to verify DELETE
![image](https://github.com/user-attachments/assets/bf69d94a-de3c-4a51-8ed4-a92edd4a68ef)
