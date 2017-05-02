package ru.boshyn.idiot;

import ru.boshyn.idiot.model.Block;
import ru.boshyn.idiot.model.Cart;

import static ru.boshyn.idiot.model.Cart.newCart;

public class Main {

    public static void main (String args[]) {

      //создание игры
      Game game = CreateGame();
      mixBlock(game.gameBlock);
      giveCardToPlayers(game);
      ConsoleView consoleView = new ConsoleView();

      //игра
      while (!endGame()) {
        //ход
        int count = 0; //счетчик подброшенных карт
        do {
          if (count == 0) {
            firstMove(game); //первый заход
          } else {
            if (!throwUp(game)) {
              break;
            }; //подбрасывание карт
          }
          if (cover(game)) {
            count++;
          } else {
            break;
          }
        } while (count != 6);
        if (count == 6) {
          hangUp(game);
        } else {
          do {
            if (!throwUp(game)) {
              break;
            }; //подбрасывание карт
          } while (count != 6);
          getLose(game);
        }
        addOnCard(game); // добрать карты из колоды
        changeCurrentPlayer(game); //сменить ходящего
      }
    }

	public static class Builder {

		public Main create() {

		}
	}

	public static class Builder {

		public Main create() {

		}
	}

	public static class Builder {

		public Main create() {

		}
	}
}
