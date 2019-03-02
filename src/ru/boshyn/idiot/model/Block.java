package ru.boshyn.idiot.model;

import java.util.ArrayList;

import static ru.boshyn.idiot.controllers.Logic.IntValue;

public class Block {

    private ArrayList<Cart> block;

    public Block() {
        ArrayList<Cart> aList = new ArrayList<>();
        this.block = aList;
    }

    public int getSize() {
        return this.block.size();
    }

    public void addCart(Cart cart) {
        this.block.add(cart);
    }

    public void clearBlock() {
        this.block.clear();
    }

    public Cart getCart(final int number) {
      //получить карту из колоды по индексу без удаления ее из колоды????
        if (checkNumber(number) && !this.block.isEmpty()) {
            return block.get(number);
        } else {
            System.out.print("Wrong number card! Число: " + number + " Длина колоды: " + this.block.size());
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
          System.out.println("Wrong number card! Число: " + number + " Длина колоды: " + block.getSize());
          return null;
        }
    }

    private void removeCart(int number) {
        this.block.remove(number);
    }

    private boolean checkNumber(int number) {
      //проверка запрашиваемого индекса карты
        if (block.size() == 0) {
            System.out.println("No more cards!");
            return false;
        } else if (block.size() > number) {
            return true;
        } else if (number < 0){
            System.out.println("Wrong number! N= " + number);
            return false;
        }
        return false;
    }

    public void clear(Block block) {
        if (block.getSize() >= 0) {
                block.block.clear();
        }
    }

    public void sortTemp() {
        // сортировка по значению
        Block sortBlock = new Block();
        Cart [] tempArray = new Cart[9];
        for (int i = 0; i < this.block.size(); i++) {
            Cart cart = this.block.get(i);
            String value = cart.getValue();
            int index = IntValue(value);
            tempArray[index] = cart;
        }
        for (int i = 0; i < 9; i++) {
            if (tempArray[i] != null) {
                sortBlock.addCart(tempArray[i]);
            }
        }
    }
}