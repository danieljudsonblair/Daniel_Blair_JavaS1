package com.example.DanielBlairU1Capstone.controller;

import com.example.DanielBlairU1Capstone.exception.NotFoundException;
import com.example.DanielBlairU1Capstone.service.InvoiceInventoryService;
import com.example.DanielBlairU1Capstone.viewModel.ConsoleViewModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/consoles")
public class ConsoleInventoryController {

    @Autowired
    InvoiceInventoryService inventoryService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ConsoleViewModel createConsole(@RequestBody @Valid ConsoleViewModel cvm) {
        return inventoryService.saveConsole(cvm);
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public ConsoleViewModel getConsole(@PathVariable("id") int consoleId) {
        ConsoleViewModel cvm = inventoryService.findConsoleById(consoleId);
        if (cvm == null)
            throw new NotFoundException("Console could not be retrieved for id " + consoleId);
        return cvm;
    }

    @GetMapping("")
    @ResponseStatus(HttpStatus.OK)
    public List<ConsoleViewModel> getAllConsoles() {
        return inventoryService.findAllConsoles();
    }

    @GetMapping("/manufacturer/{manufacturer}")
    @ResponseStatus(HttpStatus.OK)
    public List<ConsoleViewModel> getConsoleByManufacturer(@PathVariable("manufacturer") String manufacturer) {
        return inventoryService.findConsolesByManufacturer(manufacturer);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteConsole(@PathVariable("id") int consoleId) {
        inventoryService.removeConsole(consoleId);
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void updateConsole(@PathVariable("id") int consoleId, @RequestBody ConsoleViewModel cvm) {
        if (cvm.getId() == 0)
            cvm.setId(consoleId);
        if (consoleId != cvm.getId())
            throw new IllegalArgumentException("No console object found to update @ ID " + consoleId);

        inventoryService.updateConsole(cvm);
    }
}
