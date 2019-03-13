package ru.boshyn.idiot.view;

import javax.swing.*;
import java.awt.*;

public class ConsoleView extends JFrame {

    public static int indexExit = -1;

    public ConsoleView(String title) throws HeadlessException {
        super(title);
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE); //завершение программы при закрытии окна
        this.setLocation(200, 200); //положение окна
        this.setSize(600, 600); //размер окна
        this.setResizable(false); //запрет на изменение размера окна
        this.setLayout(null); // сброс кординатных привязок
    }
}

