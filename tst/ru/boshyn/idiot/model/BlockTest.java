package ru.boshyn.idiot.model;

import org.junit.Test;
import static org.junit.Assert.*;

public class BlockTest {
    @Test
    public void getSize() throws Exception {
        final Block block  = new Block();
        int count = 0;
        for (int i = 0; i < 10; i++) {
            final Cart cart  = new Cart(0, i);
            count = i;
            block.addCart(cart);
        }
        assertEquals(count, block.getSize());
    }

    @org.junit.Test
    public void getCart() throws Exception {

    }

}