package ru.boshyn.idiot.view;

import javafx.event.ActionEvent;
import ru.boshyn.idiot.model.Game;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.io.IOException;

import static java.awt.Color.cyan;


public class ConsoleView extends JFrame {

    public static int indexExit = -1;

    public ConsoleView(String s) {}

    public static void paintWindow(Game game, ConsoleView consoleView) throws IOException {

        //game_window = new ConsoleView("И Д И О Т"); //создание окна
        consoleView.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE); //завершение программы при закрытии окна
        consoleView.setLocation(200, 200); //положение окна
        consoleView.setSize(500, 500); //размер окна
        consoleView.setResizable(false); //запрет на изменение размера окна
        consoleView.setTitle("И Д И О Т"); // установка титула окна
        consoleView.setLayout(null); // сброс кординатных привязок

        PlayerPanel panel1 = new PlayerPanel(cyan, "Player_1", 0,0, 400, 100);
        consoleView.add(panel1);

        JPanel panel2 = new JPanel();
        panel2.setBackground(Color.BLUE);
        panel2.add(new JLabel("Player_2"));
        panel2.setBounds(400, 0, 100, 400);
        consoleView.add(panel2);

        JPanel panel3 = new JPanel();
        panel3.setBackground(Color.GREEN);
        panel3.add(new JLabel("Player_3"));
        panel3.setBounds(100, 400, 400, 100);
        consoleView.add(panel3);

        JPanel panel4 = new JPanel();
        panel4.setBackground(Color.MAGENTA);
        panel4.add(new JLabel("Player_4"));
        panel4.setBounds(0, 100, 100, 400);
        consoleView.add(panel4);

        JPanel panelC = new JPanel();
        JLabel labelC = new JLabel("CENTER");
        panelC.add(labelC);
        panelC.setBackground(Color.YELLOW);
        panelC.setBounds(100, 100, 300, 300);
        consoleView.add(panelC);

        //ShowCart.showAll(game, consoleView);

        consoleView.setVisible(true); //сделать окно видимым
    }

    public static JButton addButton() {

        JButton buttonNext = new JButton();
        JLabel labelNext = new JLabel("NEXT");
        buttonNext.add(labelNext);
        buttonNext.setBounds(250,350,70,30);
        return buttonNext;
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

    public static void weit(ConsoleView consoleView) {
        ConsoleView.indexExit = -1;
        while (ConsoleView.indexExit != 555) {
            JButton button = consoleView.addButton();
            consoleView.add(button);
            consoleView.buttonPress(button);
        }
    }
}

