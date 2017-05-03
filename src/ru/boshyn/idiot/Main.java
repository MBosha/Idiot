package ru.boshyn.idiot;

import ru.boshyn.idiot.controllers.CurrentStep;
import ru.boshyn.idiot.controllers.EndGame;
import ru.boshyn.idiot.controllers.StartGame;
import ru.boshyn.idiot.model.Block;
import ru.boshyn.idiot.model.Cart;
import ru.boshyn.idiot.model.Game;
import ru.boshyn.idiot.view.ConsoleView;

import java.io.IOException;

import static ru.boshyn.idiot.controllers.StartGame.mixBlock;
import static ru.boshyn.idiot.model.Cart.newCart;

public class Main {

    public static void main(String args[]) throws IOException {

      //создание игры
      Game game = StartGame.CreateGame(); // создать игру
      mixBlock(game); // перемешать колоду
      StartGame.giveCardToPlayers(game); //раздать карты игрокам
      ConsoleView consoleView = new ConsoleView(); //отобразить все на экране
      //ConsoleView.paintWindow();

      //игра
      while (!EndGame.endGame(game)) {
        //ход
        int count = 0; //счетчик подброшенных карт
        do {
          if (count == 0) {
            CurrentStep.firstMove(game);
            //первый заход
          } else {
            CurrentStep.throwUp(game);
            //подбрасывание карт при ходе
          }

          if (CurrentStep.cover(game)) {
            count++;
            // кроемся
          } else {
            break;
            //выход если не отбился
          }

          if (count == 6) {
            CurrentStep.hangUp(game);
            //отбой
          }
          EndGame.printGame(game, "После отбоя!", 1);
        } while (count != 6);

        //EndGame.printGame(game, "После цикла", count);

        if (count != 6) {
          while (count != 6) {
            CurrentStep.throwUp(game);
            //подбрасывание карт проигравшему
            count++;
          }
          CurrentStep.getLose(game);
          // взять карты если не отбился
        }
        CurrentStep.addOnCard(game); // добрать карты из колоды
        CurrentStep.changeCurrentPlayer(game); //сменить ходящего


      }
    }
}
