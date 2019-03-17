package ru.boshyn.idiot.view;

import static ru.boshyn.idiot.model.Cart.cartLear;
import static ru.boshyn.idiot.model.Cart.cartValue;

public class VirtualCart extends JPanel{


    public VirtualCart(int type, int indexL, int indexV) {
        super();
        this.setLayout(new BorderLayout());
        if (type == 0) {
            this.setSize (25, 50);
            JLabel labelL = new JLabel(cartLear[indexL]);
            this.add(labelL, BorderLayout.WEST);
            JLabel labelV = new JLabel(cartValue[indexV]);
            this.add(labelV, BorderLayout.EAST);
        }
        if (type == 1) {
            this.setSize (50, 25);
            JLabel labelL = new JLabel(cartLear[indexL]);
            this.add(labelL, BorderLayout.SOUTH);
            JLabel labelV = new JLabel(cartValue[indexV]);
            this.add(labelV, BorderLayout.NORTH);
        }

    }

    private void add(Object object) {
        this.add(object);
    }







}

