package ru.boshyn.idiot.controllers;

public class EndGame {

  public boolean endGame(Game game) {
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
}
