package ru.boshyn.idiot.view;

import javax.swing.*;

public class ConsoleView extends JFrame {

    public static int indexExit = -1;

    public ConsoleView() {
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE); //завершение программы при закрытии окна
        this.setLocation(200, 200); //положение окна
        this.setSize(500, 500); //размер окна
        this.setResizable(false); //запрет на изменение размера окна
        this.setTitle("И Д И О Т"); // установка титула окна
        this.setLayout(null); // сброс кординатных привязок
    }

    public static void weitClick(ConsoleView consoleView) {
        ConsoleView.indexExit = -1;
        while (ConsoleView.indexExit != 555) {
            ButtonNext button = new ButtonNext();
            consoleView.add(button);
            ButtonNext.buttonPress(button);
        }
    }
}

