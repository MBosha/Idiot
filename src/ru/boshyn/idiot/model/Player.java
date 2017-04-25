package ru.boshyn.idiot.model;

import ru.boshyn.idiot.model.Block;

public class Player {

    private final String playerName;

    private final Block playerBlock;

    public Player(final String name,
                  final Block block) {
        this.playerName = name;
        this.playerBlock = block;
    }

    public Block getPlayerBlock() {
        return playerBlock;
    }

    public String getPlayerName() {
        return playerName;
    }

}
