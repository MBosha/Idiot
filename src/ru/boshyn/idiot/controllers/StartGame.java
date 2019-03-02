package ru.boshyn.idiot.controllers;

import ru.boshyn.idiot.model.*;

import java.util.ArrayList;
import java.util.Random;

public class StartGame {
    //создание игры и превоначальные действия

    public static Block createBlock() {
        //создание колоды карт
        Block block = new Block();
        for (int lear = 0; lear < 4; lear++) {
            for (int value = 0; value < 9; value++) {
                Cart cart = new Cart();
                cart.changeCart(cart, lear, value);
                block.addCart(cart);
            }
        }
        return  block;
    }

    public static void mixBlock(Game game) {
        //перемешивание созданной колоды
        Block gameBlock = game.getGameBlock();
        for (int j = 0; j < 35; j++) {
            for (int i = 0; i < 35; i++) {
                Random random = new Random();
                int number = random.nextInt(35);
                Cart cart;
                cart = gameBlock.ejectCart(gameBlock, number);
                gameBlock.addCart(cart);
            }
        }
        game.setGameBlock(gameBlock);
    }

    public static ArrayList<Player> createPlayer() {
        //создание игрока
        ArrayList<Player> players = new ArrayList<Player>();
        for (int i = 0; i < 4; i++) {
            Block block = new Block();
            String name = "Player" + i;
            Player player = new Player(name, block);
            players.add(player);
        }
        return players;
    }

    public static String setTrump() {
        //установить козырь
        Random random = new Random();
        int number = random.nextInt(3);
        String trump = String.valueOf(CartLear.values()[number]);
        return trump;
    }

    public static int setCurrentPlayer() {
        //установить текущего игрока (того что ходит)
        Random random = new Random();
        int number = random.nextInt(3); // выбор числа от 0 до 4
        return number;
    }

    public static Game CreateGame(){
        //создание игры
        ArrayList<Player> players = createPlayer();
        Block gameBlock = createBlock();
        Block stepBlock = new Block();
        String gameTrump = setTrump();
        String gameName = "IDIOT";
        int currentPlayer = setCurrentPlayer();
        Game gameIdiot = new Game(players, gameBlock, stepBlock, gameTrump, gameName, currentPlayer);
        return gameIdiot;
    }

    public static void giveCardToPlayers(Game game) {
        //раздать карты игрокам
        Block gameBlock = game.getGameBlock();
        for (int p = 0; p < 4; p++) {
            Player player = game.getPlayer(p);
            Block playerBlock = player.getPlayerBlock();
            for (int c = 0; c < 6; c++) {
                Cart cart = gameBlock.ejectCart(gameBlock, c);
                playerBlock.addCart(cart);
            }
            player.setPlayerBlock(playerBlock);
            game.setPlayer(p, player);
        }
        game.setGameBlock(gameBlock);
    }
}
