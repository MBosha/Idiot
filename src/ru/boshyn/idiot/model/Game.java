package ru.boshyn.idiot.model;

import java.util.ArrayList;

public class Game {

    private ArrayList<Player> players = new ArrayList<Player>();

    private final Block gameBlock;

    private final Block stepBlock;

    private final String gameName;

    private final String gameTrump;

    private final int currentPlayer;

    public Game(final ArrayList<Player> players,
                final Block gameBlock,
                Block stepBlock,
                final String gameTrump,
                final String gameName,
                int currentPlayer) {
        this.players = players;
        this.gameBlock = gameBlock;
        this.stepBlock = stepBlock;
        this.gameTrump = gameTrump;
        this.gameName = gameName;
        this.currentPlayer = currentPlayer;
    }

    public ArrayList<Player> getPlayers() {
        return players;
    }

    public Player getPlayer(int number, ArrayList<Player> players){
        return players.get(number);
    }

    public Block getGameBlock() {
        return gameBlock;
    }

    public Block getStepBlock() {
        return stepBlock;
    }

    public String getGameName() {
        return gameName;
    }
}
