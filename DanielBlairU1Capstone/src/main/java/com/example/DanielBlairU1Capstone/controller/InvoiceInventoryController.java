package com.example.DanielBlairU1Capstone.controller;

import com.example.DanielBlairU1Capstone.exception.NotFoundException;
import com.example.DanielBlairU1Capstone.service.InvoiceInventoryService;
import com.example.DanielBlairU1Capstone.viewModel.InvoiceViewModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/invoices")

public class InvoiceInventoryController {

    @Autowired
    InvoiceInventoryService inventoryService;

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public InvoiceViewModel getInvoice(@PathVariable("id") int invoiceId) {
        InvoiceViewModel ivm = inventoryService.findInvoiceById(invoiceId);
        if (ivm == null)
            throw new NotFoundException("Invoice could not be retrieved for id " + invoiceId);
        return ivm;
    }

    @GetMapping("")
    @ResponseStatus(HttpStatus.OK)
    public List<InvoiceViewModel> getAllInvoices() {
        return inventoryService.findAllInvoices();
    }
}
