package ru.boshyn.idiot.model;

import java.util.ArrayList;

public class Cart {

    private ArrayList<String> cart = new ArrayList<String>();

    public Cart() {
        this.cart = cart;
    }

    public static Cart newCart(final Cart cart, final int intLear, final int intValue) {
        //Cart cart = new Cart();
        cart.add(String.valueOf(CartLear.values()[intLear]));
        cart.add(String.valueOf(CartValue.values()[intValue]));
        return cart;
    }

    public int getSize() {
        return this.cart.size();
    }

    private void add(String s) {
        this.cart.add(s);
    }

    public ArrayList<String> getCart() {
        return cart;
    }

    public String getLear(Cart cart) {
        if (!this.cart.isEmpty()) {
            return cart.getCart().get(0);
        }
        return null;
    }

    public String getValue(Cart cart) {
        return cart.getCart().get(1);
    }
}
