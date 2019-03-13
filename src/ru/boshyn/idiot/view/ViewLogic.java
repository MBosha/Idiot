package ru.boshyn.idiot.view;

public class ViewLogic {
    public static void weitClick(ConsoleView consoleView) {
        ConsoleView.indexExit = -1;
        while (ConsoleView.indexExit != 555) {
            ButtonNext button = new ButtonNext("NEXT");
            consoleView.add(button);
            ButtonNext.buttonPress(button);
        }
    }
}
