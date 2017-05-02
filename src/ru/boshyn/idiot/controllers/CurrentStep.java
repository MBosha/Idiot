package ru.boshyn.idiot.controllers;

public class CurrentStep {

  public boolean firstMove(Game game) {
    //заход текущего игрока под кроющегося
    int currentPlayer = game.currentPlayer;
    Player player = game.players[currentPlayer];
    Block block = player.playerBlock;
    if (block.getSize() == 0) {
      return false;
    }
    int min = findIndexMinCart(block);
    Cart cart = block.ejectCart(min);
    game.stepBlock.addCart(cart);
    return true;
  }

  public boolean throwUp(Game game) {
    // подкидывание карт под кроющегося
    return false;
  }

  public boolean cover(Game game) {
    // крыть карты
    int coverPlayer = nextPlayer(game);
    Player player = game.players[currentPlayer];
    Block playerBlock = player.playerBlock;
    Block gameBlock = game.gameBlock;
    Block stepBlock = game.stepBlock;
    if (stepBlock.getSize()%2 == 1) {
      return null;
    }
    Cart lastCart =  stepBlock.getCart(stepBlock.getSize() - 1);
    int index = findIndexCartMoo(cart, playerBlock);
    if (index >= 0) {
      Cart playerCart = playerBlock.ejectCart(index);
      game.stepBlock.addCart(playerCart);
      return true;
    } else {
      return false;
    }
  }

  public boolean getLose(Game game) {
    // забрать карты с кона если не может покрыть
    return false;
  }

  public void hangUp(Game game) {
    // отбой если отбился
    // карт в stepBlock = 12 или throwUp = 0 или gameBlock.size = 0
  }

  public void changeCurrentPlayer(Game game) {
    game.currentPlayer = nextPlayer(game);
  }

  public int nextPlayer(Game game) {
    int currentPlayer = game.currentPlayer;
    currentPlayer++;
    if (currentPlayer == 4) {
      currentPlayer = 0;
    }
    return currentPlayer;
  }

}
