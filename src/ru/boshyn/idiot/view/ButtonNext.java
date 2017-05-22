package ru.boshyn.idiot.view;

import javafx.event.ActionEvent;

import javax.swing.*;
import java.awt.event.ActionListener;

public class ButtonNext extends JButton{

    public ButtonNext() {

        JLabel labelNext = new JLabel("NEXT");
        this.add(labelNext);
        this.setBounds(250,350,70,30);
    }

    public static void buttonPress (final JButton button) {

        button.addActionListener(new ActionListener(){

            @Override
            public void actionPerformed(java.awt.event.ActionEvent e) {
                ConsoleView.indexExit = 555;
            }
            public void actionPerformed(ActionEvent e){
                ConsoleView.indexExit = 555;
            }
        });
    }
}
