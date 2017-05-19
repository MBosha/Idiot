package ru.boshyn.idiot.view;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;

public class CustomListener {

    private JLabel eventLabel;

    public void mouseClicked(MouseEvent e) {
        JButton button = (JButton) e.getSource();
        String text = "<html><b>" + button.getText()
                + " mouseReleased() <br>" + button.getText()
                + " mouseClicked() </b><html>";
        eventLabel.setText(text);
    }

    public void mouseEntered(MouseEvent e) {
        JButton button = (JButton) e.getSource();
        eventLabel.setText(button.getText() + " mouseEntered()");
    }

    public void mouseExited(MouseEvent e) {
        JButton button = (JButton) e.getSource();
        eventLabel.setText(button.getText() + " mouseExited()");
    }

    public void mousePressed(MouseEvent e) {
        JButton button = (JButton) e.getSource();
        eventLabel.setText(button.getText() + " mousePressed()");
    }

    public void mouseReleased(MouseEvent e) {
        JButton button = (JButton) e.getSource();
        eventLabel.setText(button.getText() + " mouseReleased()");
    }
}
