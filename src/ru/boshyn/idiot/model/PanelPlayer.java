package ru.boshyn.idiot.model;

import javax.swing.*;
import java.awt.*;

public class PanelPlayer extends JPanel {

    public PanelPlayer(Color color, String playerName, int x, int y, int width, int height) {
        super();
        this.setLayout(null);
        this.setBackground(color);
        JLabel labelName = new JLabel(playerName);
        labelName.setSize(100,20);
        labelName.setLocation(0,0);
        this.add(labelName);
        this.setBounds(x, y, width, height);
    }
}
