package com.MyGameLibrary.demo.Controller;

import com.MyGameLibrary.demo.entities.Game;
import com.MyGameLibrary.demo.service.GameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class GameController {

    @Autowired
    GameService gameService;

    @PostMapping("/addGame")
    public String addGame(@RequestBody Game game){
        gameService.addAGame(game);
        return game.getName()+ "added successfully";
    }

    @GetMapping("/getAllGames")
    public List<Game> getAllGames(){
        return gameService.viewAllGames();
    }

    @PutMapping("/updateGame/{gameId}")
    public String updateGame(@PathVariable int gameId ,@RequestBody Game updatedGame){
        gameService.modifyGame(gameId,updatedGame);
        return updatedGame.getName() + "updated successfully";
    }

    @DeleteMapping("deleteAGame/{gameId}")
    public String deleteAGame(@PathVariable int gameId){
        gameService.deleteAGame(gameId);
        return "Game deleted successfully!";
    }

    @PostMapping("/addPlatformToGame/{gameId}/{platformId}")
    public void addPlatformToGame(@PathVariable int gameId , @PathVariable int platformId){
        gameService.addPlatformToGame(gameId,platformId);
    }
}
