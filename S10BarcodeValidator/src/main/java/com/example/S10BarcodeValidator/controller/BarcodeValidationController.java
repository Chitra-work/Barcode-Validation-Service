package com.example.S10BarcodeValidator.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.example.S10BarcodeValidator.service.BarcodeValidatorService;

@RestController
public class BarcodeValidationController {
	
	 @Autowired
	    private BarcodeValidatorService barcodeValidatorService;
	    
	    @GetMapping("/validate")
	    public boolean validateBarcode(@RequestParam String barcode) {
	        return barcodeValidatorService.validateBarcode(barcode);
	    }
}



