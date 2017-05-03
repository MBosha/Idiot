package ru.boshyn.idiot.controllers;

import org.junit.Test;
import ru.boshyn.idiot.model.Block;
import ru.boshyn.idiot.model.Cart;
import ru.boshyn.idiot.model.Game;

import static org.junit.Assert.*;

public class StartGameTest {
    @Test
    public void createBlock() throws Exception {
    }

    @Test
    public void mixBlock() throws Exception {
        Block block = new Block();
        block = StartGame.createBlock();
        printBlock(block);
        Game game = StartGame.CreateGame();
        StartGame.mixBlock(game);
        printBlock(block);
    }

    @Test
    public void createPlayer() throws Exception {
    }

    @Test
    public void createGame() throws Exception {
    }

    @Test
    public void createBlockTest () {
        Block block = new Block();
        block = StartGame.createBlock();
        assertEquals(36, block.getSize());
        System.out.println(block.getSize());
    }

    private void printBlock(Block block) {
        for (int i = 0; i < 36; i++) {
            Cart cart = new Cart();
            cart = block.getCart(i);
            String s1 = cart.getLear(cart);
            String s2 = cart.getValue(cart);
            System.out.println("Lear: " + s1 + " | Value: " + s2);
        }
        System.out.println("Size: " + block.getSize());
        System.out.println(" ");
    }

}