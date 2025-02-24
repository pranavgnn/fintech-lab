[![Review Assignment Due Date](https://classroom.github.com/assets/deadline-readme-button-22041afd0340ce965d47ae6ef1cefeee28c7c493a6346c4f15d667ab976d596c.svg)](https://classroom.github.com/a/OP2M79po)

# Lab 4 - Creating a REST API

## Part 1: Establishing connections with tables

I created entities and repositories for the following tables:

| Table Name                   | Entity Link | Repository Link |
|------------------------------|------------|----------------|
| CUSTOMER_DETAILS             | [CustomerDetails.java](https://github.com/PRAKASH-K-A/lab3-and-lab-4-pranavgnn/blob/main/src/main/java/com/mit/entity/CustomerDetails.java) | [CustomerDetailsRepository.java](https://github.com/PRAKASH-K-A/lab3-and-lab-4-pranavgnn/blob/main/src/main/java/com/mit/repository/CustomerDetailsRepository.java) |
| CUSTOMER_IDENTIFICATION      | [CustomerIdentification.java](https://github.com/PRAKASH-K-A/lab3-and-lab-4-pranavgnn/blob/main/src/main/java/com/mit/entity/CustomerIdentification.java) | [CustomerIdentificationRepository.java](https://github.com/PRAKASH-K-A/lab3-and-lab-4-pranavgnn/blob/main/src/main/java/com/mit/repository/CustomerIdentificationRepository.java) |
| CUSTOMER_CONTACT_INFORMATION | [CustomerContactInformation.java](https://github.com/PRAKASH-K-A/lab3-and-lab-4-pranavgnn/blob/main/src/main/java/com/mit/entity/CustomerContactInformation.java) | [CustomerContactInformationRepository.java](https://github.com/PRAKASH-K-A/lab3-and-lab-4-pranavgnn/blob/main/src/main/java/com/mit/repository/CustomerContactInformationRepository.java) |
| CUSTOMER_PROOF_OF_ID         | [CustomerProofOfId.java](https://github.com/PRAKASH-K-A/lab3-and-lab-4-pranavgnn/blob/main/src/main/java/com/mit/entity/CustomerProofOfId.java) | [CustomerProofOfIdRepository.java](https://github.com/PRAKASH-K-A/lab3-and-lab-4-pranavgnn/blob/main/src/main/java/com/mit/repository/CustomerProofOfIdRepository.java) |

---
## Part 2: Setting up basic GET and POST requests

I created services for these 4 entities, that allow me to send a GET request to fetch all data, and a POST request to add records to the tables.

| Table Name                   | Service Link | Controller Link |
|------------------------------|--------------|-----------------|
| CUSTOMER_DETAILS             | [CustomerDetailsService.java](https://github.com/PRAKASH-K-A/lab3-and-lab-4-pranavgnn/blob/main/src/main/java/com/mit/service/CustomerDetailsService.java) | [CustomerDetailsController.java](https://github.com/PRAKASH-K-A/lab3-and-lab-4-pranavgnn/blob/main/src/main/java/com/mit/controller/CustomerDetailsController.java) |
| CUSTOMER_IDENTIFICATION      | [CustomerIdentificationService.java](https://github.com/PRAKASH-K-A/lab3-and-lab-4-pranavgnn/blob/main/src/main/java/com/mit/service/CustomerIdentificationService.java) | [CustomerIdentificationController.java](https://github.com/PRAKASH-K-A/lab3-and-lab-4-pranavgnn/blob/main/src/main/java/com/mit/controller/CustomerIdentificationController.java) |
| CUSTOMER_CONTACT_INFORMATION | [CustomerContactInformationService.java](https://github.com/PRAKASH-K-A/lab3-and-lab-4-pranavgnn/blob/main/src/main/java/com/mit/service/CustomerContactInformationService.java) | [CustomerContactInformationController.java](https://github.com/PRAKASH-K-A/lab3-and-lab-4-pranavgnn/blob/main/src/main/java/com/mit/controller/CustomerContactInformationController.java) |
| CUSTOMER_PROOF_OF_ID         | [CustomerProofOfIdService.java](https://github.com/PRAKASH-K-A/lab3-and-lab-4-pranavgnn/blob/main/src/main/java/com/mit/service/CustomerProofOfIdService.java) | [CustomerProofOfIdController.java](https://github.com/PRAKASH-K-A/lab3-and-lab-4-pranavgnn/blob/main/src/main/java/com/mit/controller/CustomerProofOfIdController.java) |

---
## Tests

My dummy JSON data used for testing:
```json
{
  "fullName": "John Doe",
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

### 1. POST Request
![image](https://github.com/user-attachments/assets/fdb003e5-640d-4911-9c9b-84ca819ffb5b)

### 2. GET Request
![image](https://github.com/user-attachments/assets/858bafca-de05-4bfe-9f13-34130cca304f)
