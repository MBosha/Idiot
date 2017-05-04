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
        if (checkNumber(number) && !this.block.isEmpty()) {
            return block.get(number);
        } else {
            System.out.print("Wrong number card! " + number);
            return null;
        }
    }

    public void addBlock(final Block block) {
        if (block != null) {
            int blockSize = block.getSize();
            for (int i = 0; i < blockSize; i++) {
                Cart cart = block.getCart(i);
                this.block.add(cart);
                }
        }

    }

    public Cart ejectCart(final Block block, final int number) {
      //извлечь карту из колоды по индексу  с удалением ее из колоды
        //Cart cart = new Cart();
        if (checkNumber(number)) {
            Cart cart = block.getCart(number);
            block.removeCart(number);
            return cart;
        } else {
          System.out.println("Wrong number card! " + number);
          return null;
        }
    }

    private void removeCart(int number) {
        this.block.remove(number);
    }

    private boolean checkNumber(final int number) {
      //проверка запрашиваемого индекса карты
        if (block.size() == 0) {
            System.out.println("No more cards!");
            return false;
        } else if (block.size() >= number) {
            return true;
        } else if (number < 0){
            System.out.println("Wrong number! N= " + number);
            return false;
        }
        return false;
    }
}