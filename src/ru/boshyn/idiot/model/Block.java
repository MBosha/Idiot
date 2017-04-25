package ru.boshyn.idiot.model;

import java.util.ArrayList;

public class Block {

    private final int MIN_SIZE = 0;

    private int blockSize;

    private ArrayList<Cart> block = new ArrayList<Cart>();

    public Block() {
        this.block = block;
    }

    public int getSize() {
        return blockSize;
    }

    public void addCart(Cart cart) {
        this.block.add(cart);
    }

    public Cart getCart(final int number) {
        if (checkNumber(number)) {
            return block.get(number);
            //throw new InvalidPointException();
        } else {
            System.out.print("Wrong number cart! " + number);
            return null;
        }
    }

    private boolean checkNumber(final int number) {
        if (block.size() == 0) {
            System.out.println("No many carts!");
            return false;
        } else if (block.size() <= number) {
            return true;
        } else {
            return false;
        }


    }
}
