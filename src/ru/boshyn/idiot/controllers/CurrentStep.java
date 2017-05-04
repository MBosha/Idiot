package ru.boshyn.idiot.controllers;

import ru.boshyn.idiot.model.Block;
import ru.boshyn.idiot.model.Cart;
import ru.boshyn.idiot.model.Game;

public class CurrentStep {

  public static boolean firstMove(Game game) {
    //заход текущего игрока под кроющегося
    int currentPlayer = game.getСurrentPlayer();
    Block playerBlock = game.getPlayerBlock(currentPlayer);
    Block stepBlock = game.getStepBlock();
    if (playerBlock.getSize() == 0) {
      return false;
    }
    int min = Logic.findIndexMinCart(playerBlock, game.getGameTrump());
    Cart cart = playerBlock.ejectCart(playerBlock, min);
    //game.setPlayerBlock(playerBlock, currentPlayer);
    stepBlock.addCart(cart);
    game.setStepBlock(stepBlock);
    return true;
  }

  public static boolean throwUp(Game game) {
    // подкидывание карт под кроющегося
    int throwUpPlayer = 0;
    Block stepBlock = game.getStepBlock();
    int stepBlockSize = stepBlock.getSize();
    for (int i = 0; i < 3; i++) {
      switch(i){
        case 0 :
          throwUpPlayer = game.getСurrentPlayer();
          break;
        case 1 :
          throwUpPlayer = nextNextPlayer(game);
          break;
        case 2 :
          throwUpPlayer = pervsPlayer(game);
          break;
      }
      Block playerBlock = game.getPlayerBlock(throwUpPlayer);
      for (int j = 0; j < stepBlockSize; j++) {
        //перебор карт на кону
        Cart cartStepBlock = stepBlock.getCart(j);
        String valueСartStepBlock;
        if (cartStepBlock != null) {
          valueСartStepBlock = cartStepBlock.getValue(cartStepBlock);
        } else {
          valueСartStepBlock = "";
        }
        int playerBlockSize = playerBlock.getSize();
        for (int k = 0; k < playerBlockSize; k++) {
          //перебор карт игрока
          Cart cartPlayerBlock = playerBlock.getCart(k);
          String valueCartPlayerBlock = cartPlayerBlock.getValue(cartPlayerBlock);
          if (valueСartStepBlock == valueCartPlayerBlock) {
            //если нашли совпадение по значению
            Cart newCartPlayerBlock = playerBlock.ejectCart(playerBlock, k);
            //game.setPlayerBlock(playerBlock, k);
            stepBlock.addCart(newCartPlayerBlock);
            game.setStepBlock(stepBlock);
            return true;
          }
        }
      }
    }
    return false;
  }

  public static boolean addOnCard(Game game) {
    // добор карт после отбоя
    Block gameBlock = game.getGameBlock();
    int sizeGameBlock = gameBlock.getSize();
    if (sizeGameBlock == 0) {
      return false;
    }
    //добор карт ходящим
    int addOnPlayer = game.getСurrentPlayer();
    for (int i = 0; i < 6; i++) {
      addOn(game,addOnPlayer);
    }
    //добор карт подкидывающим №1
    addOnPlayer = nextNextPlayer(game);
    for (int i = 0; i < 6; i++) {
      addOn(game,addOnPlayer);
    }

    //добор карт подкидывающим №2
    addOnPlayer = pervsPlayer(game);
    for (int i = 0; i < 6; i++) {
      addOn(game,addOnPlayer);
    }

    //добор карт уроющимся
    addOnPlayer = nextPlayer(game);
    for (int i = 0; i < 6; i++) {
      addOn(game,addOnPlayer);
    }

    return true;
  }

  public static void addOn(Game game, int index) {
    Block playerBlock = game.getPlayerBlock(index);
    Block gameBlock = game.getGameBlock();
    if ((gameBlock.getSize() != 0) && (playerBlock.getSize() < 6)) {
      Cart cart = gameBlock.ejectCart(gameBlock, 0);
      playerBlock.addCart(cart);
      game.setPlayerBlock(playerBlock, index);
    }
  }

  public static boolean cover(Game game) {
    // крыть карту
    int coverPlayer = nextPlayer(game);
    Block playerBlock = game.getPlayerBlock(coverPlayer);
    Block stepBlock = game.getStepBlock();
    Cart lastCart =  stepBlock.getCart(stepBlock.getSize() - 1);
    int index = Logic.findIndexCartMoo(lastCart, playerBlock);
    if (index >= 0) {
      Cart playerCart = playerBlock.ejectCart(playerBlock, index);
      game.setPlayerBlock(playerBlock, coverPlayer);
      stepBlock.addCart(playerCart);
      game.setStepBlock(stepBlock);
      return true;
    } else {
      return false;
    }
  }

  public static boolean getLose(Game game) {
    // забрать карты с кона если не может покрыть
    int coverPlayer = nextPlayer(game);
    Block playerBlock = game.getPlayerBlock(coverPlayer);
    Block stepBlock = game.getStepBlock();
    int size = stepBlock.getSize();
    for (int i = 0; i < size; i++) {
      Cart cart = stepBlock.ejectCart(stepBlock, 0);
      playerBlock.addCart(cart);
    }
    if (stepBlock.getSize() != 0) {
      return false;
    }
    game.setPlayerBlock(playerBlock, coverPlayer);
    game.setStepBlock(stepBlock);
    CurrentStep.changeCurrentPlayer(game); //сменить ходящего
    return true;
  }

  public static boolean hangUp(Game game) {
    // отбой если отбился
    // карт в playerBlock.getSize = 0 или throwUp = 0 или gameBlock.size = 0
    Block  stepBlock = game.getStepBlock();
    int size = stepBlock.getSize();
    for (int i = 0; i < size; i++) {
      stepBlock.ejectCart(stepBlock, 0);
    }
    game.setStepBlock(stepBlock);
    return true;
  }

  public static void changeCurrentPlayer(Game game) {
    do {
      game.setСurrentPlayer(nextPlayer(game));
    } while (game.getPlayerBlock(game.getСurrentPlayer()).getSize() == 0);
  }

  public static int nextPlayer(Game game) {
    int currentPlayer = game.getСurrentPlayer();
    if (currentPlayer == 3) {
      return 0;
    }
    currentPlayer++;
    return currentPlayer;
  }

  public static int nextNextPlayer(Game game) {
    int currentPlayer = game.getСurrentPlayer();
    int nextNextPlayer = 0;
    switch(currentPlayer){
      case 0 :
        nextNextPlayer = 2;
        break;
      case 1 :
        nextNextPlayer = 3;
        break;
      case 2 :
        nextNextPlayer = 0;
        break;
      case 3 :
        nextNextPlayer = 1;
        break;
    }
    return nextNextPlayer;
  }

  public static int pervsPlayer(Game game) {
    int currentPlayer = game.getСurrentPlayer();
    int prevsPlayer = 0;
    switch(currentPlayer){
      case 0 :
        prevsPlayer = 3;
        break;
      case 1 :
        prevsPlayer = 0;
        break;
      case 2 :
        prevsPlayer = 1;
        break;
      case 3 :
        prevsPlayer = 2;
        break;
    }
    return prevsPlayer;

  }
}
