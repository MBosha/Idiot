package ru.boshyn.idiot.controllers;

import ru.boshyn.idiot.model.Block;
import ru.boshyn.idiot.model.Cart;
import ru.boshyn.idiot.model.Game;

public class Logic {

  public static int findIndexMinCart(Block block, String trump) {
    //найти индекс минимальной не козырной карты
    //масти пики - трефы - бубны - козыри
    int size = block.getSize();
    Cart cartMin = null;
    int intMin = -1;
    for (int l = 0; l < 4; l++) {
      String lear = cartMin.getLear();
      if (lear == trump) {
        continue;
      }
      for (int v = 0; v < size; v++) {
        Cart cart = block.getCart(v);
        if (cart.getLear() == lear) {
          if (cartMin == null) {
            cartMin = cart;
            intMin = v;
          } else {
            String cartValue = cart.getValue();
            String minValue = cartMin.getValue();
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
    String cartLear = cart.getLear();
    String cartValue = cart.getValue();
    int indexCartValue = Logic.IntValue(cartValue);
    for (int i = 0; i < sizeBlock; i++) {
      Cart cartPlayer = block.getCart(i);
      String cartPlayerLear = cartPlayer.getLear();
      if (cartPlayerLear == cartLear) {
        String CartPlayerValue = cartPlayer.getValue();
        int indexCartPlayerValue = Logic.IntValue(CartPlayerValue);
        if (indexCartPlayerValue > indexCartValue) {
          return i;
        }
      }
    }
    return -1;
  }

  public static void sortBlockAllPlayers(final Game game) {
    //сортировка карт играющего
    //масти пики - крести - бубны - черви - козыри
    Block tempBlock = new Block();
    Block spades = new Block();
    Block clubs = new Block();
    Block diamonds = new Block();
    Block hearts = new Block();
    Block tempPlayerBlock = new Block();


    for (int pl = 0; pl < 4; pl++) {
      //цикл игроков
      tempPlayerBlock = game.getPlayerBlock(pl);
      // достали колоду игрока
      for (int p = 0; p < 6; p++) {
        //цикл по картам колоды
        Cart playerCart = tempPlayerBlock.getCart(p);
        String playerLear = playerCart.getLear();
        //"♠", "♣", "♦", "♥"
        switch (playerLear) {
          case "♠":
            spades.addCart(playerCart);
            break;
          case "♣":
            clubs.addCart(playerCart);
            break;
          case "♦":
            diamonds.addCart(playerCart);
            break;
          case "♥":
            hearts.addCart(playerCart);
            break;
        }
      }
      spades.sortTemp();
      clubs.sortTemp();
      diamonds.sortTemp();
      hearts.sortTemp();

      tempBlock.addBlock(spades);
      tempBlock.addBlock(clubs);
      tempBlock.addBlock(diamonds);
      tempBlock.addBlock(hearts);

      spades.clearBlock();
      clubs.clearBlock();
      diamonds.clearBlock();
      hearts.clearBlock();
      tempPlayerBlock.clearBlock();
      tempPlayerBlock.addBlock(tempBlock);

      game.setPlayerBlock(tempPlayerBlock, pl);
      tempBlock.clearBlock();
    }
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
        valueСartStepBlock = cartStepBlock.getValue();
      } else {
        valueСartStepBlock = null;
      }
      for (int k = 0; k < playerBlock.getSize(); k++) {
        //перебор карт игрока
        Cart cartPlayerBlock = playerBlock.getCart(k);
        String valueCartPlayerBlock = cartPlayerBlock.getValue();
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
    if (value.equals("6")) {
      return 0;
    } else if (value.equals("7")) {
      return 1;
    } else if (value.equals("8")) {
      return 2;
    } else if (value.equals("9")) {
      return 3;
    } else if (value.equals("10")) {
      return 4;
    } else if (value.equals("J")) {
      return 5;
    } else if (value.equals("Q")) {
      return 6;
    } else if (value.equals("K")) {
      return 6;
    } else if (value.equals("A")) {
      return 6;
    }
    return -1;
  }
}
