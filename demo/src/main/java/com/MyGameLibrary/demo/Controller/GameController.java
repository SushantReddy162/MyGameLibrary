package com.MyGameLibrary.demo.Controller;

import com.MyGameLibrary.demo.entities.Game;
import com.MyGameLibrary.demo.service.GameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class GameController {

    @Autowired
    GameService gameService;

    @PostMapping("/games")
    public ResponseEntity<Game> addGame( @Validated @RequestBody Game game){
        Game gameToAdd = gameService.addAGame(game);
        return new ResponseEntity<>( gameToAdd, HttpStatus.CREATED);
    }

    //for listing all games
    @GetMapping("/games")
    public ResponseEntity<List<Game>> getAllGames(){
        List<Game> gameList = gameService.viewAllGames();
        return new ResponseEntity<>(gameList , HttpStatus.OK);
    }

    //for listing a game with specific id
    @GetMapping("/games/{gameId}")
    public ResponseEntity<Game> getGameById(@PathVariable int gameId){
        Game game = gameService.getGameById(gameId);
        return new ResponseEntity<>(game , HttpStatus.OK);
    }

    @PutMapping("/games/{gameId}")
    public ResponseEntity<Game> updateGame(@PathVariable int gameId ,@RequestBody Game updatedGame){

        Game newGame = gameService.modifyGame(gameId,updatedGame);
        return new ResponseEntity<>(newGame , HttpStatus.OK);
    }

    @DeleteMapping("games/{gameId}")
    public ResponseEntity<String> deleteAGame(@PathVariable int gameId){
        gameService.deleteAGame(gameId);
        return new ResponseEntity<>("Game deleted successfully" , HttpStatus.OK);
    }

    @PostMapping("/games/{gameId}/platforms/{platformId}")
    public ResponseEntity<Game> addPlatformToGame(@PathVariable int gameId , @PathVariable int platformId){
        Game newGame = gameService.addPlatformToGame(gameId,platformId);
        return new ResponseEntity<>(newGame , HttpStatus.OK);
    }
}
