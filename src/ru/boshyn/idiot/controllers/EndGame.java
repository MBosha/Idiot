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

  public boolean getWinner(Game game) {
    return false;
  }

  public static boolean endCArt(Game game) {
    //поиск выигравшего
    int coverPlayer = CurrentStep.nextPlayer(game);
    Block playerBlock = game.getPlayerBlock(coverPlayer);
    if (playerBlock.getSize() == 0) {
      return true;
    } else {
      return false;
    }
  }



  public static void printGame(Game game, String s, int index) {

    Cart cart1 = null;
    Cart cart2 = null;
    String cart1Lear = null;
    String cart1Value = null;
    String cart2Lear = null;
    String cart2Value = null;
    int i1 = 0;
    int i2 = 0;
    switch (index) {
      case 1:
        i1 = 0;
        i2 = 1;
        break;
      case 2:
        i1 = 2;
        i2 = 3;
        break;
      case 3:
        i1 = 4;
        i2 = 5;
        break;
      case 4:
        i1 = 6;
        i2 = 7;
        break;
      case 5:
        i1 = 8;
        i2 = 9;
        break;
      case 6:
        i1 = 10;
        i2 = 11;
        break;
    }
    if (game.getStepBlock() != null) {
      if ((game.getStepBlock().getSize() - 1) >= i1) {

        cart1 = game.getStepBlock().getCart(i1);
        cart1Lear = cart1.getLear(cart1);
        cart1Value = cart1.getValue(cart1);
      }
      if ((game.getStepBlock().getSize() - 1) >= i2) {
        cart2 = game.getStepBlock().getCart(i2);
        cart2Lear = cart2.getLear(cart2);
        cart2Value = cart2.getValue(cart2);
      }
    }
    System.out.println(s);
    System.out.println("Текщий игрок    " + game.getСurrentPlayer());
    System.out.println("Ход             " + index);
    System.out.println("Ход             " + cart1Lear + " " + cart1Value);
    System.out.println("Ответ           " + cart2Lear + " " + cart2Value);
    System.out.println("Карт в колоде   " + game.getGameBlock().getSize());
    System.out.println("Карт в на столе " + game.getStepBlock().getSize());
    System.out.println("Карт у игрока 0 " + game.getPlayerBlock(0).getSize());
    System.out.println("Карт у игрока 1 " + game.getPlayerBlock(1).getSize());
    System.out.println("Карт у игрока 2 " + game.getPlayerBlock(2).getSize());
    System.out.println("Карт у игрока 3 " + game.getPlayerBlock(3).getSize());
    System.out.println();
  }
}
