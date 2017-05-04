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

  public static void sortBlockAllPlayers(Game game) {
    //сортировка карт играющего
    //масти пики - крести - бубны - черви - козыри
    Block tempBlock = new Block();
    Block tempBlockLear = new Block();
    Cart tempCart;
    for (int pl = 0; pl < 4; pl++) {
      //цикл игроков
      Block playerBlock = game.getPlayerBlock(pl); // достали колоду игрока
      for (int l = 0; l < 4; l++) {
        //цикл по мастям
        //tempBlock = null;
        String lear = String.valueOf(CartLear.values()[l]);
        for (int p = 0; p < playerBlock.getSize(); p++) {
          //извлечение карт одной масти
          Cart playerCart = playerBlock.getCart(p);
          // достали карту
          String playerLear = playerCart.getLear(playerCart);
          if (lear == playerLear) {
            tempCart = playerBlock.ejectCart(playerBlock, p);
            tempBlockLear.addCart(tempCart);
          }
          //добавили карту d темп мастей
        }
        tempBlockLear = Logic.sortTemp(tempBlockLear);
        //сортировка по значениям
        for (int add = 0; add < tempBlock.getSize(); add++) {
          //добавление масти в темп колоду
          if (tempBlockLear == null) {
            break;
          } else {
            tempBlock.addCart(tempBlockLear.getCart(add));
          }
        }
      }
      game.setPlayerBlock(tempBlock, pl);
    }
  }

  public static Block sortTemp(Block block) {
    // сортировка по значению
    if (block.getSize() == 0) {
      return null;
    }
    Block tempBlock = new Block();
    Cart [] tempArray = new Cart[9];
    for (int i = 0; i < block.getSize(); i++) {
      Cart cart = block.getCart(i);
      String value = cart.getValue(cart);
      int index = IntValue(value);
      tempArray[index] = cart;
    }
    for (int i = 0; i < 9; i++) {
      if (tempArray[i] != null) {
        tempBlock.addCart(tempArray[i]);
      }
    }
    return tempBlock;
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
