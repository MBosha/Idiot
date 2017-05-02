package ru.boshyn.idiot.view;

import javax.swing.*;
import java.awt.*;

class GameFields extends JPanel {
    @Override
    protected void paintComponent (Graphics g) {
        super.paintComponent(g);
        onRepaint(g);
        repaint();
    }

    private void onRepaint(Graphics g) {
    }
}
