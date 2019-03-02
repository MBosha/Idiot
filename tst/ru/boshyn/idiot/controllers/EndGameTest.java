package ru.boshyn.idiot.controllers;

import org.junit.Test;
import ru.boshyn.idiot.model.Game;

import static org.junit.Assert.*;
import static ru.boshyn.idiot.controllers.StartGame.mixBlock;

public class EndGameTest extends EndGame {

    @Test
    public void printGame() {

        Game game = StartGame.CreateGame(); // создать игру
        mixBlock(game); // перемешать колоду
        StartGame.giveCardToPlayers(game); //раздать карты игрокам
        Logic.sortBlockAllPlayers(game);
        System.out.println();
        for (int k = 0; k < 4; k++) {
            System.out.println( "Игрок " + game.getPlayer(k).getPlayerName() + " количество карт " + game.getPlayer(k).getPlayerBlock().getSize());
        }

        EndGame.printGame(game, "EndGame", 1);
    }
}