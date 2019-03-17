package ru.boshyn.idiot.model;

import javax.swing.*;
import java.awt.*;

public class Cart extends JPanel {

    private PanelCart panelCart;
    private String lear;
    private String value;
    private int type;

    final static String[] cartLear = {"♠", "♣", "♦", "♥"};
    final static String[] cartValue = {"6", "7", "8", "9", "10", "J", "Q", "K", "A"};

    //создание карты с указанием масти и значения, а так же создается панель карты для визуализации
    public String getLear() {
        if (!this.lear.isEmpty()) {
            return this.lear;
        }
        return null;
    }

    public Cart(int learS, int valueS) {
        super();
        this.setBackground(Color.ORANGE);
        this.setLayout(null);
        this.setSize(20, 40);
        this.lear = cartLear[learS];
        this.value = cartValue[valueS];

        JLabel labelL = new JLabel(this.lear);
        labelL.setSize(20, 20);
        if ((this.lear == cartLear[2]) || (this.lear == cartLear[3])) {
            labelL.setForeground(Color.red);
        }
        labelL.setLocation(0,0);
        this.add(labelL);

        JLabel labelV = new JLabel(this.value);
        labelV.setSize(20, 20);
        labelV.setLocation(0,20);
        this.add(labelV);
    }

    public String getValue() {
        if (!this.value.isEmpty()) {
            return this.value;
        }
        return null;
    }

    public static String getLears(int index) {
        return cartLear[index];
    }
}