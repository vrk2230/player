package com.example.player;

import java.util.ArrayList;

public interface PlayerRepository {
    ArrayList<Player> getAllPlayers();

    Player getPlayerbyId(int playerId);

    void addPlayer(Player player);

    void updatePlayer(int playerId, Player player);

    void deletePlayer(int playerId);
}
