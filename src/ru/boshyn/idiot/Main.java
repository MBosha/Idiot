package ru.boshyn.idiot;

import ru.boshyn.idiot.controllers.CurrentStep;
import ru.boshyn.idiot.controllers.EndGame;
import ru.boshyn.idiot.controllers.StartGame;
import ru.boshyn.idiot.model.Game;
import ru.boshyn.idiot.view.ConsoleView;
import ru.boshyn.idiot.view.PlayerPanel;
import ru.boshyn.idiot.view.ShowCart;

import java.io.IOException;
import java.util.ArrayList;

import static java.awt.Color.*;

public class Main {

    public static void main(String args[]) throws IOException {

      //создание игры
      Game game = StartGame.CreateGame(); // создать игру
      EndGame.printGame(game, "Создание игры!", 1);
      StartGame.mixBlock(game); // перемешать колоду
      EndGame.printGame(game, "Перемешивание карт!", -1);
      StartGame.giveCardToPlayers(game); //раздать карты игрокам
      EndGame.printGame(game, "Раздача карт!", -1);

      //sortBlockAllPlayers(game); //сортировка карт у игроков
      EndGame.printGame(game, "Сортировка карт!", -1);

      //оздать фрейм
      ConsoleView consoleView = new ConsoleView();

      ArrayList<PlayerPanel> playerPanels = new ArrayList<PlayerPanel>(4);
      playerPanels.add(new PlayerPanel(cyan, "Player_1", 0, 0, 400, 100));
      playerPanels.add(new PlayerPanel(blue, "Player_2", 400, 0, 100, 400));
      playerPanels.add(new PlayerPanel(green, "Player_3", 100, 400, 400, 100));
      playerPanels.add(new PlayerPanel(magenta, "Player_4", 0, 100, 100, 400));
      playerPanels.add(new PlayerPanel(yellow, "CENTER", 100, 100, 300, 300));

      //отобразить все на экране
        consoleView.repaint();
      //ConsoleView.setConsoleView(game, consoleView);
      for (int i =0; i < 5; i++) {
        consoleView.add(playerPanels.get(i));
      }
      consoleView.setVisible(true); //сделать окно видимым

      //пауза
      ConsoleView.weitClick(consoleView);
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
          ConsoleView.weitClick(consoleView);
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
          ConsoleView.weitClick(consoleView);
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
          ConsoleView.weitClick(consoleView);
          ShowCart.showAll(game, consoleView);

          CurrentStep.getLose(game);
          EndGame.printGame(game, "После взятия!", 0);
          ConsoleView.weitClick(consoleView);
          ShowCart.showAll(game, consoleView);
          // взять карты если не отбился
        }
        CurrentStep.addOnCard(game); // добрать карты из колоды
        EndGame.printGame(game, "После добора!", 0);
        ConsoleView.weitClick(consoleView);
        ShowCart.showAll(game, consoleView);

        //Logic.sortBlockAllPlayers(game);
        CurrentStep.changeCurrentPlayer(game); //сменить ходящего

      }
    }
}
