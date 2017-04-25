package ru.boshyn.idiot.model;

import java.util.ArrayList;

public class Cart {

    private ArrayList<String> cart = new ArrayList<String>();

    public Cart(final int intLear, final int intValue) {
        CartLear cartLear = new CartLear();
        CartValue cartValue = new CartValue();
        this.cart = cart;
        cart.add(0,CartLear.cartLear.get(intLear));
        cart.add(1,CartValue.cartValue.get(intValue));
    }






}
