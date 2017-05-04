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

          EndGame.printGame(game, "После Хода!", count);

          if (CurrentStep.cover(game)) {
            if (EndGame.endCArt(game)) {
              count = 6;
            } else {
              count++;
            }
            // кроемся
          } else {
            break;
            //выход если не отбился
          }
          EndGame.printGame(game, "После отбоя!", count);

          if (count == 6) {
            CurrentStep.hangUp(game);
            //отбой
          }
        } while (count != 6);

        if (count != 6) {
          while (count != 6) {
            CurrentStep.throwUp(game);
            //подбрасывание карт проигравшему
            count++;
          }
          EndGame.printGame(game, "После подбрасывания!", 0);
          CurrentStep.getLose(game);
          EndGame.printGame(game, "После взятия!", 0);
          // взять карты если не отбился
        }
        CurrentStep.addOnCard(game); // добрать карты из колоды
        EndGame.printGame(game, "После добора!", 0);
        CurrentStep.changeCurrentPlayer(game); //сменить ходящего
      }
    }
}
