package ru.boshyn.idiot.view;

import ru.boshyn.idiot.controllers.Logic;
import ru.boshyn.idiot.model.Block;
import ru.boshyn.idiot.model.Cart;
import ru.boshyn.idiot.model.Game;
import ru.boshyn.idiot.model.PanelCart;

import java.io.IOException;

public class ShowCart {

    //показать карты всех игроков
    public static void showAll (final Game game, final ConsoleView consoleView) throws IOException {
        consoleView.setVisible(false); //сделать окно невидимым
        consoleView.removeAll();

        horizontLineCart(10,25, 0, game, consoleView);
        horizontLineCart(110,425, 2, game, consoleView);
        verticalLineCart(410,25, 1, game, consoleView);
        verticalLineCart(10,125, 3, game, consoleView);

        consoleView.setVisible(true); //сделать окно видимым
    }


    //показ карт на экране в горизонтальный ряд
    public static void horizontLineCart(int startX, int startY, int indexPlayer, final Game game, final ConsoleView consoleView) throws IOException {
        Block playerBlock = game.getPlayerBlock(indexPlayer);
        for (int i = 0; i < playerBlock.getSize(); i++){
            Cart cart = playerBlock.getCart(i);
            String lear = cart.getLear();
            int indexLear = Logic.IntLear(lear);
            String value = cart.getValue();
            int indexValue = Logic.IntValue(value);
            PanelCart panelCart = new PanelCart(lear, value);
            consoleView.add(panelCart);
        }
    }

    //показ карт на экране в вертикальный ряд
    public static void verticalLineCart(int startX, int startY, int indexPlayer, Game game, ConsoleView consoleView) throws IOException {
        Block playerBlock = game.getPlayerBlock(indexPlayer);
        for (int i = 0; i < playerBlock.getSize(); i++){
            Cart cart = playerBlock.getCart(i);
            String lear = cart.getLear();
            int indexLear = Logic.IntLear(lear);
            String value = cart.getValue();
            int indexValue = Logic.IntValue(value);
            PanelCart panelCart = new PanelCart(lear, value);
            consoleView.add(panelCart);
        }
    }
}