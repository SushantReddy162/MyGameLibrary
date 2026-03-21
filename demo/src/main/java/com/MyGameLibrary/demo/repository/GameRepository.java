package com.MyGameLibrary.demo.repository;

import com.MyGameLibrary.demo.entities.Game;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GameRepository extends JpaRepository<Game,Integer> {

}
