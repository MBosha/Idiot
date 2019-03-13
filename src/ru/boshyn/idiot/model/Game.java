package ru.boshyn.idiot.model;

import java.util.ArrayList;

public class Game {

    private ArrayList<Player> players;

    private Block gameBlock;

    private Block stepBlock;

    private final String gameName;

    private final String gameTrump;

    private int currentPlayer;



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

    public Player getPlayer(int index) {
        if (index < 4 && index >= 0) {
            return this.players.get(index);
        } else {
            return null;
        }


    }

    public void setPlayer(int index, Player player){
      this.players.set(index, player);
    }

    public Block getPlayerBlock(int index){
      //Player player = this.getPlayer(index);
      //Block playerBlock = player.getPlayerBlock();
      return this.players.get(index).getPlayerBlock();
    }

    public void setPlayerBlock(Block block, int index){
        this.players.get(index).setPlayerBlock(block);
        //Player player = this.getPlayer(index);
        //player.setPlayerBlock(block);
        //this.setPlayer(index, player);
    }

    public Block getGameBlock() {
        return this.gameBlock;
    }

    public void setGameBlock(Block block) {
        this.gameBlock =  block;
    }

    public Block getStepBlock() {
        return this.stepBlock;
    }

    public void setStepBlock (Block block) {
        this.stepBlock =  block;
    }

    public String getGameName() {
        return this.gameName;
    }

    public int getСurrentPlayer() {
        return this.currentPlayer;
    }

    public void setСurrentPlayer(int index) {
        this.currentPlayer = index;
    }

    public String getGameTrump() {
        return this.gameTrump;
    }

}
