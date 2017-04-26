package ru.boshyn.idiot;

import ru.boshyn.idiot.model.Block;
import ru.boshyn.idiot.model.Cart;

public class Main {

    public static void main (String args[]) {

        final Block block = new Block();
        final Cart cart = new Cart();
        cart.newCart(cart,0,0);
        block.addCart(cart);

        System.out.println(block.getCart(0));
        System.out.println(block.getSize());


    }
}
