package ru.boshyn.idiot;

import ru.boshyn.idiot.controllers.CurrentStep;
import ru.boshyn.idiot.controllers.EndGame;
import ru.boshyn.idiot.controllers.Logic;
import ru.boshyn.idiot.controllers.StartGame;
import ru.boshyn.idiot.model.Block;
import ru.boshyn.idiot.model.Cart;
import ru.boshyn.idiot.model.Game;
import ru.boshyn.idiot.view.ConsoleView;
import ru.boshyn.idiot.view.CustomListener;
import ru.boshyn.idiot.view.ShowCart;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.image.ImageObserver;
import java.io.IOException;
import java.text.AttributedCharacterIterator;

import static ru.boshyn.idiot.controllers.Logic.sortBlockAllPlayers;
import static ru.boshyn.idiot.controllers.StartGame.mixBlock;
import static ru.boshyn.idiot.model.Cart.newCart;

public class Main {

    public static void main(String args[]) throws IOException {

      //создание игры
      Game game = StartGame.CreateGame(); // создать игру
      EndGame.printGame(game, "Создание игры!", -1);
      mixBlock(game); // перемешать колоду
      EndGame.printGame(game, "Перемешивание карт!", -1);
      StartGame.giveCardToPlayers(game); //раздать карты игрокам
      EndGame.printGame(game, "Раздача карт!", -1);

      //sortBlockAllPlayers(game);

      EndGame.printGame(game, "Сортировка карт!", -1);

      //отобразить все на экране
      ConsoleView consoleView = new ConsoleView("И Д И О Т");
      ConsoleView.paintWindow(game, consoleView);

      //пауза
      ConsoleView.weit(consoleView);
      ShowCart.showAll(game, consoleView);

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
          ConsoleView.weit(consoleView);
          ShowCart.showAll(game, consoleView);

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
          ConsoleView.weit(consoleView);
          ShowCart.showAll(game, consoleView);

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
          ConsoleView.weit(consoleView);
          ShowCart.showAll(game, consoleView);

          CurrentStep.getLose(game);
          EndGame.printGame(game, "После взятия!", 0);
          ConsoleView.weit(consoleView);
          ShowCart.showAll(game, consoleView);
          // взять карты если не отбился
        }
        CurrentStep.addOnCard(game); // добрать карты из колоды
        EndGame.printGame(game, "После добора!", 0);
        ConsoleView.weit(consoleView);
        ShowCart.showAll(game, consoleView);

        //Logic.sortBlockAllPlayers(game);
        CurrentStep.changeCurrentPlayer(game); //сменить ходящего

      }
    }
}
