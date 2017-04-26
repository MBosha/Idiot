package ru.boshyn.idiot.model;

import java.util.ArrayList;

public class Cart {

    private ArrayList<String> cart = new ArrayList<String>();
    private ArrayList<String> cartLear = new ArrayList<String>();
    private ArrayList<String> cartValue = new ArrayList<String>();

    public Cart() {
        this.cart = cart;
    }

    private void Lear() {
        ArrayList<String> cartLear = new ArrayList<String>();
        this.cartLear = cartLear;
        cartLear.add(0, String.valueOf(CartLear.values()[1]));
        cartLear.add(1, String.valueOf(CartLear.values()[2]));
        cartLear.add(2, String.valueOf(CartLear.values()[3]));
        cartLear.add(3, String.valueOf(CartLear.values()[4]));
    }

    private void Value() {
        this.cartValue = cartValue;
        cartValue.add(0, String.valueOf(CartValue.values()[1]));
        cartValue.add(1,String.valueOf(CartValue.values()[2]));
        cartValue.add(2,String.valueOf(CartValue.values()[3]));
        cartValue.add(3,String.valueOf(CartValue.values()[4]));
        cartValue.add(4,String.valueOf(CartValue.values()[5]));
        cartValue.add(5,String.valueOf(CartValue.values()[6]));
        cartValue.add(6,String.valueOf(CartValue.values()[7]));
        cartValue.add(7,String.valueOf(CartValue.values()[8]));
        cartValue.add(8,String.valueOf(CartValue.values()[9]));
    }

    public void newCart(final Cart cart, final int intLear, final int intValue) {
        /*CartLear();
        CartValue();*/
        cart.cart.add(0,cartLear.get(intLear));
        cart.cart.add(1,cartValue.get(intValue));
    }
}
