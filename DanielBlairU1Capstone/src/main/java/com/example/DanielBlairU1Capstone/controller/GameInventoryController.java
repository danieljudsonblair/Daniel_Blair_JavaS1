package com.example.DanielBlairU1Capstone.controller;

import com.example.DanielBlairU1Capstone.exception.NotFoundException;
import com.example.DanielBlairU1Capstone.service.InvoiceInventoryService;
import com.example.DanielBlairU1Capstone.viewModel.GameViewModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/games")
public class GameInventoryController {

    @Autowired
    InvoiceInventoryService inventoryService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public GameViewModel createGame(@RequestBody @Valid GameViewModel game) {
        return inventoryService.saveGame(game);
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public GameViewModel getGame(@PathVariable("id") int gameId) {
        GameViewModel gvm = inventoryService.findGameById(gameId);
        if (gvm == null)
            throw new NotFoundException("Game could not be retrieved for id " + gameId);
        return gvm;
    }

    @GetMapping("")
    @ResponseStatus(HttpStatus.OK)
    public List<GameViewModel> getAllGames() {
        return inventoryService.findAllGames();
    }

    @GetMapping("/studio/{studio}")
    @ResponseStatus(HttpStatus.OK)
    public List<GameViewModel> getGameByStudio(@PathVariable("studio") String studio) {
        return inventoryService.findGamesByStudio(studio);
    }

    @GetMapping("/esrb/{esrb_rating}")
    @ResponseStatus(HttpStatus.OK)
    public List<GameViewModel> getGameByEsrb(@PathVariable("esrb_rating") String esrb_rating) {
        return inventoryService.findGamesByESRBRating(esrb_rating);
    }

    @GetMapping("/title/{title}")
    @ResponseStatus(HttpStatus.OK)
    public List<GameViewModel> getGameByTitle(@PathVariable("title") String title) {
        return inventoryService.findGamesByTitle(title);
    }

    @DeleteMapping("{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteGame(@PathVariable("id") int gameId) {
        inventoryService.removeGame(gameId);
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void updateGame(@PathVariable("id") int gameId, @RequestBody GameViewModel gvm) {
        if (gvm.getId() == 0)
            gvm.setId(gameId);
        if (gameId != gvm.getId())
            throw new IllegalArgumentException("No game object found to update @ ID " + gameId);

        inventoryService.updateGame((gvm));
    }
}
