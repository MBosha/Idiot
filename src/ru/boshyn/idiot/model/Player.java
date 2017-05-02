package ru.boshyn.idiot.model;

import ru.boshyn.idiot.model.Block;

public class Player {

    private final String playerName;

    private Block playerBlock;

    public Player(final String name,
                  final Block block) {
        this.playerName = name;
        this.playerBlock = block;
    }

    public Block getPlayerBlock() {
        return this.playerBlock;
    }

    public void setPlayerBlock(Block block) {
        this.playerBlock = block;
    }

    public String getPlayerName() {
        return this.playerName;
    }

}
