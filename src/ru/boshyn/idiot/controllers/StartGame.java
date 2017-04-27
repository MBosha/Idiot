package ru.boshyn.idiot.controllers;

import ru.boshyn.idiot.model.Block;
import ru.boshyn.idiot.model.Cart;
import ru.boshyn.idiot.model.Game;
import ru.boshyn.idiot.model.Player;

import java.util.ArrayList;
import java.util.Random;

public class StartGame {

    public static Block createBlock() {
        Block block = new Block();
        for (int lear = 0; lear < 4; lear++) {
            for (int value = 0; value < 9; value++) {
                Cart cart = new Cart();
                cart = cart.newCart(cart, lear,value);
                block.addCart(cart);
            }
        }
        return  block;
    }

    public static Block mixBlock(Block block) {
        for (int j = 0; j < 10; j++) {
            for (int i = 0; i < 35; i++) {
                Random random = new Random();
                int number = random.nextInt(35);
                Cart cart = new Cart();
                cart = block.ejectCart(block,number);
                block.addCart(cart);
            }
        }
        return block;
    }

    public ArrayList<Player> createPlayer() {
        ArrayList<Player> players = new ArrayList<Player>();
        for (int i = 0; i < 4; i++) {
            Block block = new Block();
            String name = "Player" + i;
            Player player = new Player(name, block);
            players.add(player);
        }
        return players;
    }

    public Game CreateGame(){
        ArrayList<Player> players = createPlayer();
        Block gameBlock = createBlock();
        Block stepBlock = new Block();
        Game gameIdiot = new Game(players, gameBlock, stepBlock, "IDIOT");
        return gameIdiot;
    }
}
