package ru.boshyn.idiot.model;

import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.*;

public class BlockTest {
    @Test
    public void getSize() throws Exception {
        final Block block  = new Block();
        Cart cart = new Cart();
        int count = 0;
        for (int i = 0; i < 10; i++) {
            cart.newCart(cart, 0, i);
            count++;
            block.addCart(cart);
        }
        assertEquals(count, block.getSize());
    }

    @Test
    public void getCart() throws Exception {
        final Block block  = new Block();
        newBlock(block,4);
        Cart cart1 = new Cart();
        Cart cart2 = new Cart();
        cart1.newCart(cart1, 0, 0);
        cart2.newCart(cart2, 1, 1);
        Cart cart3 = block.getCart(0);
        Cart cart4 = block.getCart(1);
        String s1 = cart1.getLear(cart1);
        String s3 = cart3.getLear(cart3);
        String s2 = cart1.getValue(cart1);
        String s4 = cart3.getValue(cart3);
        assertEquals(s1, s3);
        assertEquals(s2, s4);
        System.out.println();
    }

    @Test
    public void ejectCart() throws Exception {

    }

    private Block newBlock(Block block, int count) {
        for (int i = 0; i < count; i++) {
            Cart cart = new Cart();
            cart.newCart(cart, i, i);
            block.addCart(cart);
        }
        return block;
    }
}