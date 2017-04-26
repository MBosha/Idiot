package ru.boshyn.idiot.model;

import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.*;

public class BlockTest {
    @Test
    public void getSize() throws Exception {
        final Block block  = new Block();
        Cart cart = null;
        int count = 0;
        for (int i = 0; i < 10; i++) {
            cart.newCart(cart,0, i);
            count++;
            block.addCart(cart);
        }
        assertEquals(count, block.getSize());
    }

    @org.junit.Test
    public void getCart() throws Exception {

    }

}