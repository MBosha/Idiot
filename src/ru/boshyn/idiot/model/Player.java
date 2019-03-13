package ru.boshyn.idiot.model;

import javax.swing.*;

public class Player {

    private final String playerName;

    private Block playerBlock;

    private final JPanel playerPanel ;

    public Player(final String name,
                  final Block block) {
        playerName = name;
        playerBlock = block;
        playerPanel = new JPanel();
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
