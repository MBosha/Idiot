package ru.boshyn.idiot.model;

import javax.swing.*;
import java.awt.*;


public class PanelCart extends JPanel {

    public PanelCart(String lear, String value) {

        super();
        this.setBackground(Color.ORANGE);
        this.setLayout(null);
        //вертикальное расопложение карт
        this.setSize(30, 60);
        JLabel labelL = new JLabel(lear,SwingConstants.CENTER);
        labelL.setSize(30, 30);
        labelL.setLocation(0,0);
        this.add(labelL);
        JLabel labelV = new JLabel(value, SwingConstants.CENTER);
        labelV.setSize(30, 30);
        labelV.setLocation(0,30);
        this.add(labelV);
    }
}



