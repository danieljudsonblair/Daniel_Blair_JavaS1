package com.example.DanielBlairU1Capstone.controller;

import com.example.DanielBlairU1Capstone.exception.NotFoundException;
import com.example.DanielBlairU1Capstone.service.InvoiceInventoryService;
import com.example.DanielBlairU1Capstone.viewModel.TshirtViewModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/tshirts")
public class TshirtInventoryController {

    @Autowired
    InvoiceInventoryService inventoryService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public TshirtViewModel createTshirt(@RequestBody @Valid TshirtViewModel tvm) {
        return inventoryService.saveTshirt(tvm);
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public TshirtViewModel getTshirt(@PathVariable("id") int tshirtId) {
        TshirtViewModel tvm = inventoryService.findTshirtById(tshirtId);
        if (tvm == null)
            throw new NotFoundException("Tshirt could not be retrieved for id " + tshirtId);
        return tvm;
    }

    @GetMapping("")
    @ResponseStatus(HttpStatus.OK)
    public List<TshirtViewModel> getAllTshirts() {
        return inventoryService.findAllTshirts();
    }

    @GetMapping("/tshirt/{color}")
    @ResponseStatus(HttpStatus.OK)
    public List<TshirtViewModel> getTshirtByColor(@PathVariable("color") String color) {
        return inventoryService.findTshirtsByColor(color);
    }

    @GetMapping("/tshirt/{size}")
    @ResponseStatus(HttpStatus.OK)
    public List<TshirtViewModel> getTshirtBySize(@PathVariable("size") String size) {
        return inventoryService.findTshirtsBySize(size);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteTshirt(@PathVariable("id") int tshirtId) {
        inventoryService.removeTshirt(tshirtId);
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void updateTshirt(@PathVariable("id") int tshirtId, @RequestBody TshirtViewModel tvm) {
        if (tvm.getId() == 0)
            tvm.setId(tshirtId);
        if (tshirtId != tvm.getId())
            throw new IllegalArgumentException("No t-shirt found to update @ ID " + tshirtId);

        inventoryService.updateTshirt(tvm);
    }
}