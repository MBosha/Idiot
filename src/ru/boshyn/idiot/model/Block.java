package ru.boshyn.idiot.model;

import java.util.ArrayList;

public class Block {

    private ArrayList<Cart> block = new ArrayList<Cart>();

    public Block() {
        this.block = block;
    }

    public int getSize() {
        return this.block.size();
    }

    public void addCart(Cart cart) {
        this.block.add(cart);
    }

    public Cart getCart(final int number) {
        if (checkNumber(number)) {
            return block.get(number);
        } else {
            System.out.print("Wrong number cart! " + number);
            return null;
        }
    }

    public Cart ejectCart(Block block, final int number) {
        Cart cart = new Cart();
        cart = block.block.get(number);
        block.block.remove(number);
        return cart;
    }



    private boolean checkNumber(final int number) {
        if (block.size() == 0) {
            System.out.println("No many carts!");
            return false;
        } else if (block.size() >= number) {
            return true;
        } else {
            return false;
        }


    }
}
