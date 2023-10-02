package com.example.S10BarcodeValidator;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.example.S10BarcodeValidator.service.BarcodeValidatorService;

public class BarcodeValidatorServiceTest {

    private BarcodeValidatorService barcodeValidatorService;

    @BeforeEach
    public void setUp() {
        barcodeValidatorService = new BarcodeValidatorService();
    }

    @Test
    public void testValidBarcode() {
        String validBarcode = "AB123456785GB"; 
        assertTrue(barcodeValidatorService.validateBarcode(validBarcode));
    }

    @Test
    public void testInvalidLength() {
        String invalidBarcode = "AB12345GB";
        assertFalse(barcodeValidatorService.validateBarcode(invalidBarcode));
    }

    @Test
    public void testInvalidPrefix() {
        String invalidBarcode = "XY1234567895GB";
        assertFalse(barcodeValidatorService.validateBarcode(invalidBarcode));
    }

    @Test
    public void testInvalidSerialNumber() {
        String invalidBarcode = "AB12345ABC5GB";
        assertFalse(barcodeValidatorService.validateBarcode(invalidBarcode));
    }

    @Test
    public void testInvalidCheckDigit() {
        String invalidBarcode = "AB1234567896GB";
        assertFalse(barcodeValidatorService.validateBarcode(invalidBarcode));
    }

    @Test
    public void testInvalidCountryCode() {
        String invalidBarcode = "AB1234567895US";
        assertFalse(barcodeValidatorService.validateBarcode(invalidBarcode));
    }

 
    @Test
    public void testInValidCheckDigit0() {
        String validBarcode = "AB1234567893GB";
        assertFalse(barcodeValidatorService.validateBarcode(validBarcode));
    } 
}
