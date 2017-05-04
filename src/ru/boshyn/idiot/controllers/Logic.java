package ru.boshyn.idiot.controllers;

import ru.boshyn.idiot.model.Block;
import ru.boshyn.idiot.model.Cart;
import ru.boshyn.idiot.model.CartLear;
import ru.boshyn.idiot.model.Game;

public class Logic {

  public static int findIndexMinCart(Block block, String trump) {
    //найти индекс минимальной карты
    //масти пики - трефы - бубны - козыри
    int size = block.getSize();
    Cart cartMin = null;
    int intMin = -1;
    for (int l = 0; l < 4; l++) {
      String lear = String.valueOf(CartLear.values()[l]);
      if (lear == trump) {
        continue;
      }
      for (int v = 0; v < size; v++) {
        Cart cart = block.getCart(v);
        if (cart.getLear(cart) == lear) {
          if (cartMin == null) {
            cartMin = cart;
            intMin = v;
          } else {
            String cartValue = cart.getValue(cart);
            String minValue = cartMin.getValue(cartMin);
            int indexCart = IntValue(cartValue);
            int indexMin = IntValue(minValue);
            if (indexCart < indexMin) {
              cartMin = cart;
              intMin = v;
            }
          }
        }
      }
      if (intMin != -1) {
        return intMin;
      } else {
        return 0;
      }
    }
    return intMin;
  }

  public static int findIndexCartMoo(Cart cart, Block block) {
    //найти индекс карты бальше заданной
    int sizeBlock = block.getSize();
    String cartLear = cart.getLear(cart);
    String cartValue = cart.getValue(cart);
    int indexCartValue = Logic.IntValue(cartValue);
    for (int i = 0; i < sizeBlock; i++) {
      Cart cartPlayer = block.getCart(i);
      String cartPlayerLear = cartPlayer.getLear(cartPlayer);
      if (cartPlayerLear == cartLear) {
        String CartPlayerValue = cartPlayer.getValue(cartPlayer);
        int indexCartPlayerValue = Logic.IntValue(CartPlayerValue);
        if (indexCartPlayerValue > indexCartValue) {
          return i;
        }
      }
    }
    return -1;
  }

  public void sortBlock(Block block) {
    //сортировка карт играющего
    //масти козыри - черви - бубны - крести - пики
  }

  public static int findIndexCartValue(Game game, int index) {
    //найти карту по значению для подбрасывания
    Block stepBlock = game.getStepBlock();
    Block playerBlock = game.getPlayerBlock(index);
    for (int j = 0; j < stepBlock.getSize(); j++) {
      //перебор карт на кону
      Cart cartStepBlock = stepBlock.getCart(j);
      String valueСartStepBlock;
      if (cartStepBlock != null) {
        valueСartStepBlock = cartStepBlock.getValue(cartStepBlock);
      } else {
        valueСartStepBlock = null;
      }
      for (int k = 0; k < playerBlock.getSize(); k++) {
        //перебор карт игрока
        Cart cartPlayerBlock = playerBlock.getCart(k);
        String valueCartPlayerBlock = cartPlayerBlock.getValue(cartPlayerBlock);
        if (valueСartStepBlock == valueCartPlayerBlock) {
          //если нашли совпадение по значению
          return k;
        }
      }
    }

    return -1;
  }

  public static int IntLear (String lear) {
    if (lear.equals("Hearts")) {
      return 0;
    } else if (lear.equals("Diamonds")) {
      return 1;
    } else if (lear.equals("Clubs")) {
      return 2;
    } else if (lear.equals("Spades")) {
      return 3;
    }
    return -1;
  }

  public static int IntValue (String value) {
    if (value.equals("Six")) {
      return 0;
    } else if (value.equals("Seven")) {
      return 1;
    } else if (value.equals("Eight")) {
      return 2;
    } else if (value.equals("Nine")) {
      return 3;
    } else if (value.equals("Ten")) {
      return 4;
    } else if (value.equals("Jack")) {
      return 5;
    } else if (value.equals("Queen")) {
      return 6;
    } else if (value.equals("King")) {
      return 6;
    } else if (value.equals("Ace")) {
      return 6;
    }
    return -1;
  }
}
