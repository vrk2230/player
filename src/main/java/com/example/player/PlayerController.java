package com.example.player;

import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.PathVariable;
import java.util.ArrayList;

@RestController
public class PlayerController {
    PlayerService playerService;

    @GetMapping("/players")
    ArrayList<Player> getAllPlayers() {
        return playerService.getAllPlayers();
    }

    @PostMapping("/players")
    public void addPlayer(@RequestBody Player player) {
        playerService.addPlayer(player);
    }

    @GetMapping("/players/{playerId}")
    public Player getPlayerById(@PathVariable("playerId") int playerId) {
        return playerService.getPlayerbyId(playerId);
    }

    @PutMapping("/players/{playerId}")
    public void updatePlayer(@PathVariable("playerId") int playerId, @RequestBody Player player) {
        playerService.updatePlayer(playerId, player);
    }

    @DeleteMapping("/players/{playerId}")
    public void deletePlayer(@PathVariable("playerId") int playerId) {
        playerService.deletePlayer(playerId);
    }

}
