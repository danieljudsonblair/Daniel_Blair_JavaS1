package com.example.DanielBlairU1Capstone.controller;

import com.example.DanielBlairU1Capstone.service.InvoiceInventoryService;
import com.example.DanielBlairU1Capstone.viewModel.InvoiceViewModel;
import com.example.DanielBlairU1Capstone.viewModel.PurchaseViewModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/purchase")
public class PurchaseController {

    @Autowired
    InvoiceInventoryService inventoryService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public InvoiceViewModel createPurchase(@RequestBody @Valid PurchaseViewModel pvm) {
        return inventoryService.saveInvoice(pvm);
    }
}
