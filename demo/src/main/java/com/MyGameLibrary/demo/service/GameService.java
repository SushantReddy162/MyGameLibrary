package com.MyGameLibrary.demo.service;

import com.MyGameLibrary.demo.Exceptions.GameNotFoundException;
import com.MyGameLibrary.demo.Exceptions.PlatformNotFoundException;
import com.MyGameLibrary.demo.entities.Game;
import com.MyGameLibrary.demo.entities.Platform;
import com.MyGameLibrary.demo.repository.GameRepository;
import com.MyGameLibrary.demo.repository.PlatformRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GameService {

    @Autowired
    GameRepository gameRepository;

    @Autowired
    PlatformRepository platformRepository;

    public Game addAGame(Game game){

        gameRepository.save(game);
        return game;
    }

    public List<Game> viewAllGames(){
        return gameRepository.findAll();
    }

    public Game modifyGame(int gameId , Game updatedGame){
        Game existingGame = gameRepository.findById(gameId)
                .orElseThrow(() -> new GameNotFoundException("Game not found with id "+ gameId));

        existingGame.setName(updatedGame.getName());
        existingGame.setGenre(updatedGame.getGenre());
        existingGame.setRating(updatedGame.getRating());
        existingGame.setPlatforms(updatedGame.getPlatforms());
        existingGame.setCustomNote(updatedGame.getCustomNote());

        gameRepository.save(existingGame);
        return existingGame;
    }

    public void deleteAGame(int gameId){
        gameRepository.deleteById(gameId);
    }


    public Game addPlatformToGame( int gameId , int platformId){
        Game game = gameRepository.findById(gameId)
                .orElseThrow(() -> new GameNotFoundException("Game not found with id " + gameId));

        Platform platform = platformRepository.findById(platformId)
                .orElseThrow(() -> new PlatformNotFoundException("Platform not found with id" + platformId));

        game.getPlatforms().add(platform);
        gameRepository.save(game);
        return game;

    }

    public Game getGameById( int gameId){
        Game game = gameRepository.findById(gameId)
                .orElseThrow(() -> new GameNotFoundException("Game not found with id "+ gameId));

        return game;
    }

}
