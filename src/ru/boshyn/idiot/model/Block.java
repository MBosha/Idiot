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
      //получить карту из колоды по индексу без удаления ее из колоды????
        if (checkNumber(number)) {
            return block.get(number);
        } else {
            System.out.print("Wrong number card! " + number);
            return null;
        }
    }

    public Cart ejectCart(final int number) {
      //извлечь карту из колоды по индексу  с удалением ее из колоды
        //Cart cart = new Cart();
        if (checkNumber(number)) {
          return block.remove(number);
        } else {
          System.out.print("Wrong number card! " + number);
          return null;
        }
    }

    private boolean checkNumber(final int number) {
      //проверка запрашиваемого индекса карты
        if (block.size() == 0) {
            System.out.println("No more cards!");
            return false;
        } else if (block.size() >= number) {
            return true;
        } else {
            return false;
        }


    }
}
