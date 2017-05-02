package ru.boshyn.idiot;

import ru.boshyn.idiot.model.Block;
import ru.boshyn.idiot.model.Cart;

import static ru.boshyn.idiot.model.Cart.newCart;

public class Main {

    public static void main (String args[]) {

      //создание игры
      Game game = CreateGame(); // создать игру
      mixBlock(game.gameBlock); // перемешать колоду
      giveCardToPlayers(game); //раздать карты игрокам
      ConsoleView consoleView = new ConsoleView(); //отобразить все на экране

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
}
