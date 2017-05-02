package ru.boshyn.idiot.controllers;

public class CurrentStep {

  public boolean firstMove(Game game) {
    //заход текущего игрока под кроющегося
    int currentPlayer = game.getСurrentPlayer();
    Player player = game.getPlayer(currentPlayer);
    Block playerBlock = player.getPlayerBlock();
    Block stepBlock = game.getStepBlock();
    if (playerBlock.getSize() == 0) {
      return false;
    }
    int min = findIndexMinCart(playerBlock);
    Cart cart = playerBlock.ejectCart(min);
    player.setPlayerBlock(playerBlock);
    game.setPlayer(player);
    stepBlock.addCart(cart);
    game.setStepBlock(stepBlock);
    return true;
  }

  public boolean throwUp(Game game) {
    // подкидывание карт под кроющегося
    return false;
  }

  public boolean addOnCard(Game game) {
    // добор карт после отбоя
    return false;
  }

  public boolean cover(Game game) {
    // крыть карту
    int coverPlayer = nextPlayer(game);
    Player player = game.getPlayer(coverPlayer);
    Block playerBlock = player.getPlayerBlock();
    Block stepBlock = game.getStepBlock();
    if (stepBlock.getSize()%2 == 1) {
      return null;
    }
    Cart lastCart =  stepBlock.getCart(stepBlock.getSize() - 1);
    int index = playerBlock.findIndexCartMoo(cart, playerBlock);
    if (index >= 0) {
      Cart playerCart = playerBlock.ejectCart(index);
      player.setPlayerBlock(playerBlock);
      game.setPlayer(player);
      stepBlock.addCart(playerCart);
      game.setStepBlock(stepBlock);
      return true;
    } else {
      return false;
    }
  }

  public boolean getLose(Game game) {
    // забрать карты с кона если не может покрыть
    int coverPlayer = nextPlayer(game);
    Player player = game.getPlayer(coverPlayer);
    Block playerBlock = player.getPlayerBlock();
    Block stepBlock = game.getStepBlock();
    int size = stepBlock.getSize();
    for (int i = 0; i <= size; i++) {
      Cart cart = stepBlock.ejectCart(i);
      playerBlock.addCart(cart);
    }
    if (stepBlock.getSize() != 0) {
      return false;
    }
    player.setPlayerBlock(playerBlock);
    game.setPlayer(player);
    game.stepBlock(stepBlock);
    return true;
  }

  public void hangUp(Game game) {
    // отбой если отбился
    // карт в playerBlock.getSize = 0 или throwUp = 0 или gameBlock.size = 0
    Block stepBlock = game.getStepBlock();
    stepBlock = null;
    game.setStepBlock(stepBlock);
    return true;
  }

  public void changeCurrentPlayer(Game game) {
    game.setСurrentPlayer(nextPlayer(game));
  }

  public int nextPlayer(Game game) {
    int currentPlayer = game.getСurrentPlayer();
    if (currentPlayer == 3) {
      return 0;
    }
    int currentPlayer = game.getСurrentPlayer();
    currentPlayer++;
    return currentPlayer;
  }

}
