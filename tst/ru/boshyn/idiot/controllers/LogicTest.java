package ru.boshyn.idiot.controllers;

import org.junit.Test;
import ru.boshyn.idiot.model.Block;
import ru.boshyn.idiot.model.Cart;
import ru.boshyn.idiot.model.Game;

import static ru.boshyn.idiot.controllers.StartGame.mixBlock;

public class LogicTest {
    @Test
    public void sortBlockAllPlayers() throws Exception {
        Game game = StartGame.CreateGame(); // создать игру
        mixBlock(game); // перемешать колоду
        StartGame.giveCardToPlayers(game); //раздать карты игрокам
        Logic.sortBlockAllPlayers(game);
        System.out.println();
        for (int k = 0; k < 4; k++) {
            System.out.println( "Игрок " + game.getPlayer(k).getPlayerName() + " количество карт " + game.getPlayer(k).getPlayerBlock().getSize());
        }
        System.out.println();

        for (int j = 0; j < 4; j++) {
            Block block = game.getPlayerBlock(j);
            String name = game.getPlayer(j).getPlayerName();
            for (int i = 0; i < 6; i++) {
                Cart cart = block.getCart(i);
                if (cart == null) {
                    System.out.println();
                    System.out.println("Нулевая карта");
                    break;
                }
                String lear = cart.getLear();
                String value = cart.getValue();
                System.out.println( (i+1) + " Игрок " + name + " Масть " + lear + " Значение " + value);
            }
            System.out.println();
        }

    }

}