package ru.boshyn.idiot.controllers;

import ru.boshyn.idiot.model.Block;
import ru.boshyn.idiot.model.Cart;
import ru.boshyn.idiot.model.Game;
import ru.boshyn.idiot.model.Player;

public class EndGame {

  public static boolean endGame(Game game) {
    //признак окончания игры карты остались только у одного игрока
    int count = 0;
    for (int p = 0; p < 4; p++) {
      Player player = game.getPlayer(p);
      Block block = player.getPlayerBlock();
      if (block.getSize() > 0) {
        count++;
      }
    }
    if (count == 1) {
      return true;
    } else {
      return false;
    }
  }

  public void getWinner(Game game) {
    //поиск выигравшего
  }

  public static void printGame(Game game, String s, int index) {

    Cart cart1 = null;
    String cart1Lear = null;
    String cart1Value = null;
    String cart2Lear = null;
    String cart2Value = null;

    if (game.getStepBlock().getSize() != 0) {
      cart1 = game.getStepBlock().getCart(0);

      cart1Lear = cart1.getLear(cart1);
      cart1Value = cart1.getValue(cart1);

      Cart cart2 = game.getStepBlock().getCart(1);
      cart2Lear = cart2.getLear(cart2);
      cart2Value = cart2.getValue(cart2);
    }
    System.out.println(s);
    System.out.println("Ход      " + cart1Lear + " " + cart1Value);
    System.out.println("Ответ    " + cart2Lear + " " + cart2Value);
    /*System.out.println("Ход             " + index);
    System.out.println("Карт в колоде   " + game.getGameBlock().getSize());
    System.out.println("Карт у игрока 0 " + game.getPlayerBlock(0).getSize());
    System.out.println("Карт у игрока 1 " + game.getPlayerBlock(1).getSize());
    System.out.println("Карт у игрока 2 " + game.getPlayerBlock(2).getSize());
    System.out.println("Карт у игрока 3 " + game.getPlayerBlock(3).getSize());*/
    System.out.println();
  }
}
