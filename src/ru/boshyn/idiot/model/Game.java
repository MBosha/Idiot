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

    public Player getPlayer(int index){
        return this.players.get(index);
    }

    public void setPlayer(int index, Player player){
      this.players[index] = player;
    }

    public Block getGameBlock() {
        return this.gameBlock;
    }

    public void setGameBlock(Block block) {
        this.gameBlock =  block;
    }

    public Block getStepBlock() {
        return stepBlock;
    }

    public void setStepBlock (Block block) {
        this.stepBlock =  block;
    }

    public String getGameName() {
        return gameName;
    }

    public int getСurrentPlayer() {
        return this.currentPlayer;
    }

    public void setСurrentPlayer(int index) {
        this.currentPlayer = indexw;
    }
}
