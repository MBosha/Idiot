package ru.boshyn.idiot;

import ru.boshyn.idiot.controllers.CurrentStep;
import ru.boshyn.idiot.controllers.EndGame;
import ru.boshyn.idiot.controllers.StartGame;
import ru.boshyn.idiot.model.Block;
import ru.boshyn.idiot.model.Cart;
import ru.boshyn.idiot.model.Game;
import ru.boshyn.idiot.view.ConsoleView;

import static ru.boshyn.idiot.controllers.CurrentStep.throwUp;
import static ru.boshyn.idiot.controllers.StartGame.mixBlock;
import static ru.boshyn.idiot.model.Cart.newCart;

public class Main {

    public static void main (String args[]) {

      //создание игры
      Game game = StartGame.CreateGame(); // создать игру
      mixBlock(game.getGameBlock()); // перемешать колоду
      StartGame.giveCardToPlayers(game); //раздать карты игрокам
      ConsoleView consoleView = new ConsoleView(); //отобразить все на экране

      //игра
      while (!EndGame.endGame(game)) {
        //ход
        int count = 0; //счетчик подброшенных карт
        do {
          if (count == 0) {
            CurrentStep.firstMove(game); //первый заход
          } else {
            if (!throwUp(game)) {
              break;
            }; //подбрасывание карт
          }
          if (CurrentStep.cover(game)) {
            count++;
          } else {
            break;
          }
        } while (count != 6);
        if (count == 6) {
          CurrentStep.hangUp(game);
        } else {
          do {
            if (!throwUp(game)) {
              break;
            }; //подбрасывание карт
          } while (count != 6);
          CurrentStep.getLose(game);
        }
        CurrentStep.addOnCard(game); // добрать карты из колоды
        CurrentStep.changeCurrentPlayer(game); //сменить ходящего
      }
    }
}
