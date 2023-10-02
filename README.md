# Barcode-Validation-Service

To run this Spring Boot application locally, you'll need:

Java Development Kit (JDK)
Maven
Spring Boot

Follow these steps to get started:

  1) Clone this repository to your local machine: git clone https://github.com/yourusername/S10BarcodeValidator.git
  2) Navigate to the project directory: cd S10BarcodeValidator
  3) Build and run the application using Maven: mvn spring-boot:run

Endpoints
The following API endpoint is available:

GET /validate?barcode={barcode}: Validates the provided barcode.

GET http://localhost:8080/validate?barcode=AA473124829GB - Response true

GET http://localhost:8080/validate?barcode=AA473124828GB - Response false

Tests
This project includes unit tests to ensure the correctness of the BarcodeValidatorService. 
To run the tests, use the following Maven command: mvn test
