package ru.boshyn.idiot.model;

import java.util.ArrayList;

public class Cart {

    private ArrayList<String> cart;

    public Cart() {
        ArrayList<String> aList = new ArrayList<>();
        this.cart = aList;
    }

    //смена масти и значения карты с очисткой
    public static void changeCart(Cart cart, int intLear, int intValue) {
        cart.clear();
        cart.add(String.valueOf(CartLear.values()[intLear]));
        cart.add(String.valueOf(CartValue.values()[intValue]));
    }

    public int getSize() {
        return this.cart.size();
    }

    private void add(String str) {
        this.cart.add(str);
    }

    private void clear() {
        this.cart.clear();
    }

    public ArrayList<String> getCart() {
        return cart;
    }

    public String getLear() {
        if (!this.cart.isEmpty()) {
            return this.getCart().get(0);
        }
        return null;
    }

    public String getValue() {
        if (!this.cart.isEmpty()) {
            return this.getCart().get(1);
        }
        return null;
    }
}
