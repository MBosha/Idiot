package ru.boshyn.idiot.controllers;

import ru.boshyn.idiot.model.Block;
import ru.boshyn.idiot.model.Cart;
import ru.boshyn.idiot.model.Game;
import ru.boshyn.idiot.model.Player;

public class CurrentStep {

  public static boolean firstMove(Game game) {
    //заход текущего игрока под кроющегося
    int currentPlayer = game.getСurrentPlayer();
    Player player = game.getPlayer(currentPlayer);
    Block playerBlock = player.getPlayerBlock();
    Block stepBlock = game.getStepBlock();
    if (playerBlock.getSize() == 0) {
      return false;
    }
    int min = Logic.findIndexMinCart(playerBlock);
    Cart cart = playerBlock.ejectCart(playerBlock, min);
    player.setPlayerBlock(playerBlock);
    game.setPlayer(currentPlayer, player);
    stepBlock.addCart(cart);
    game.setStepBlock(stepBlock);
    return true;
  }

  public static boolean throwUp(Game game) {
    // подкидывание карт под кроющегося
    return false;
  }

  public static boolean addOnCard(Game game) {
    // добор карт после отбоя
    return false;
  }

  public static boolean cover(Game game) {
    // крыть карту
    int coverPlayer = nextPlayer(game);
    Player player = game.getPlayer(coverPlayer);
    Block playerBlock = player.getPlayerBlock();
    Block stepBlock = game.getStepBlock();
    /*if (stepBlock.getSize()%2 == 1) {
      return false;
    }*/
    Cart lastCart =  stepBlock.getCart(stepBlock.getSize() - 1);
    int index = Logic.findIndexCartMoo(lastCart, playerBlock);
    if (index >= 0) {
      Cart playerCart = playerBlock.ejectCart(playerBlock, index);
      player.setPlayerBlock(playerBlock);
      game.setPlayer(coverPlayer, player);
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
    Player player = game.getPlayer(coverPlayer);
    Block playerBlock = player.getPlayerBlock();
    Block stepBlock = game.getStepBlock();
    int size = stepBlock.getSize();
    for (int i = 0; i < size; i++) {
      Cart cart = stepBlock.ejectCart(stepBlock, i);
      playerBlock.addCart(cart);
    }
    if (stepBlock.getSize() != 0) {
      return false;
    }
    player.setPlayerBlock(playerBlock);
    game.setPlayer(coverPlayer, player);
    game.setStepBlock(stepBlock);
    return true;
  }

  public static boolean hangUp(Game game) {
    // отбой если отбился
    // карт в playerBlock.getSize = 0 или throwUp = 0 или gameBlock.size = 0
    Block stepBlock = game.getStepBlock();
    stepBlock = null;
    game.setStepBlock(stepBlock);
    return true;
  }

  public static void changeCurrentPlayer(Game game) {
    game.setСurrentPlayer(nextPlayer(game));
  }

  public static int nextPlayer(Game game) {
    int currentPlayer = game.getСurrentPlayer();
    if (currentPlayer == 3) {
      return 0;
    }
    currentPlayer++;
    return currentPlayer;
  }

}
