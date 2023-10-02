package com.example.S10BarcodeValidator.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class BarcodeValidatorService {

	private static final Logger logger = LoggerFactory.getLogger(BarcodeValidatorService.class);

	public boolean validateBarcode(String barcode) {

		logger.debug("Validating barcode: {}", barcode);

		if (barcode.length() != 13) {

			logger.error("Invalid barcode: {}", barcode);
			return false;
		}

		// Validate prefix
		String prefix = barcode.substring(0, 2);

		if (!prefix.matches("[A-Z]{2}")) {

			logger.error("Invalid prefix: {}", prefix);
			return false;
		}

		// Validate serial number
		String serialNumber = barcode.substring(2, 10);

		if (!serialNumber.matches("[0-9]{8}")) {

			logger.error("Invalid serialNumber: {}", serialNumber);
			return false;
		}

		// Calculate and validate check digit
		int sum = calculateSum(serialNumber);
		logger.info("Sum: {}", sum);

		// Calculate check digit from the first 8 digits
		int checkDigit = 11 - (sum % 11);
		if (checkDigit == 10) {
			checkDigit = 0;
		} else if (checkDigit == 11) {
			checkDigit = 5;
		}

		logger.info("Calculated check digit: {}", checkDigit);
		
		int actualCheckDigit = Integer.parseInt(barcode.substring(10, 11));
		logger.info("Actual check digit: {}", actualCheckDigit);

		if (checkDigit != actualCheckDigit) {
			logger.info("Invalid checkDigit: {}", checkDigit);
			return false;
		}

		// Validate country code
		String countryCode = barcode.substring(11);
		if (!countryCode.equals("GB")) {

			logger.debug("Invalid countryCode: {}", countryCode);
			return false;
		}

		logger.debug("Barcode is valid");
		return true;
	}

	private int calculateSum(String serialNumber) {
		int[] weights = { 8, 6, 4, 2, 3, 5, 9, 7 };
		int sum = 0;
		for (int i = 0; i < serialNumber.length(); i++) {
			sum += Integer.parseInt(serialNumber.substring(i, i + 1)) * weights[i];
		}
		return sum;
	}
}
