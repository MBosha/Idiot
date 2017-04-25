package ru.boshyn.idiot.model;

public class Game {

    private final Player[] players;

    private final Block gameBlock;

    private final String gameName;

    public Game(final Player[] players,
                final Block gameBlock,
                final String gameName) {
        this.players = players;
        this.gameBlock = gameBlock;
        this.gameName = gameName;
    }

    public Player[] getPlayers() {
        return players;
    }

    public Block getGameBlock() {
        return gameBlock;
    }

    public String getGameName() {
        return gameName;
    }
}
