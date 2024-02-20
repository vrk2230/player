package com.example.player;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;
import java.util.HashMap;

@Service
public class PlayerService implements PlayerRepository {
    private HashMap<Integer, Player> team = new HashMap<>();

    public PlayerService() {
        team.put(1, new Player(1, "Alexander", 5, "All-rounder"));
        team.put(2, new Player(2, "Benjamin", 3, "All-rounder"));
        team.put(3, new Player(3, "Michael", 18, "Batsman"));
        team.put(4, new Player(4, "William", 45, "Batsman"));
        team.put(5, new Player(5, "Joshua", 19, "Batsman"));
        team.put(6, new Player(6, "Daniel", 10, "Bowler"));
        team.put(7, new Player(7, "Matthew", 34, "Bowler"));
        team.put(8, new Player(8, "Samuel", 17, "Batsman"));
        team.put(9, new Player(9, "John", 1, "Bowler"));
        team.put(10, new Player(10, "Earnest", 2, "All-rounder"));
        team.put(11, new Player(11, "Bob", 25, "Batsman"));
    }

    @Override
    public ArrayList<Player> getAllPlayers() {
        return new ArrayList<>(team.values());
    }

    @Override
    public Player getPlayerbyId(int playerId) {
        if (!team.containsKey(playerId)) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
        return team.get(playerId);
    }

    @Override
    public void addPlayer(Player player) {
        int newPlayerId = team.size() + 1;
        player.setPlayerId(newPlayerId);
        team.put(newPlayerId, player);
    }

    @Override
    public void updatePlayer(int playerId, Player player) {
        if (!team.containsKey(playerId)) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
        team.put(playerId, player);
    }

    @Override
    public void deletePlayer(int playerId) {
        if (!team.containsKey(playerId)) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
        team.remove(playerId);
    }
}
