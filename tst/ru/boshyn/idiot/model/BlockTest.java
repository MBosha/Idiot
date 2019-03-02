package ru.boshyn.idiot.model;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class BlockTest {
    @Test
    public void getSize() throws Exception {
        final Block block  = new Block();
        Cart cart = new Cart();
        int count = 0;
        for (int i = 0; i < 9; i++) {
            cart.changeCart(cart,0, i);
            count++;
            block.addCart(cart);
            System.out.println(i + " Карта " + cart.getLear() + " " + cart.getValue());
        }
        assertEquals(count, block.getSize());
    }

    @Test
    public void getCart() throws Exception {
        final Block block  = new Block();
        newBlock(block,4);
        Cart cart1 = new Cart();
        Cart cart2 = new Cart();
        cart1.changeCart(cart1, 0, 0);
        cart2.changeCart(cart2, 1, 1);
        Cart cart3 = block.getCart(0);
        Cart cart4 = block.getCart(1);
        String s1 = cart1.getLear();
        String s3 = cart3.getLear();
        String s2 = cart1.getValue();
        String s4 = cart3.getValue();
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
            cart.changeCart(cart, i, i);
            block.addCart(cart);
        }
        return block;
    }
}
