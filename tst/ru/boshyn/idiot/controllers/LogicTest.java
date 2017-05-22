package ru.boshyn.idiot.controllers;

import org.junit.Test;
import ru.boshyn.idiot.model.Block;
import ru.boshyn.idiot.model.Cart;
import ru.boshyn.idiot.model.Game;
import ru.boshyn.idiot.view.ConsoleView;

import static org.junit.Assert.*;
import static ru.boshyn.idiot.controllers.StartGame.mixBlock;

public class LogicTest {
    @Test
    public void sortBlockAllPlayers() throws Exception {
        Game game = StartGame.CreateGame(); // создать игру
        mixBlock(game); // перемешать колоду
        StartGame.giveCardToPlayers(game); //раздать карты игрокам
        Logic.sortBlockAllPlayers(game);
        for (int j = 0; j < 4; j++) {
            for (int i = 0; i < 6; i++) {
                Block block = game.getPlayerBlock(j);
                Cart cart = block.getCart(i);
                String lear = cart.getLear();
                String value = cart.getValue();
                System.out.println("Масть " + lear + " Значение " + value);
            }
            System.out.println();
        }

    }

}