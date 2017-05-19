package ru.boshyn.idiot.view;


import javax.swing.*;
import java.awt.*;

public class PlayerPanel extends JPanel{

    public PlayerPanel(Color color, String playerName, int x, int y, int width, int height) {
        JPanel panel = new JPanel();
        panel.setBackground(color);
        panel.add(new JLabel(playerName));
        panel.setBounds(x, y, width, height);
    }



}
