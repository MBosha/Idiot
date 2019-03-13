package ru.boshyn.idiot;

import ru.boshyn.idiot.controllers.CurrentStep;
import ru.boshyn.idiot.controllers.EndGame;
import ru.boshyn.idiot.controllers.StartGame;
import ru.boshyn.idiot.model.Block;
import ru.boshyn.idiot.model.Cart;
import ru.boshyn.idiot.model.Game;
import ru.boshyn.idiot.model.PanelPlayer;
import ru.boshyn.idiot.view.ConsoleView;
import ru.boshyn.idiot.view.ShowCart;
import ru.boshyn.idiot.view.ViewLogic;

import java.io.IOException;
import java.util.ArrayList;

import static java.awt.Color.*;

public class Main {

    public static void main(String args[]) throws IOException {

      //создание игры
      Game game = StartGame.CreateGame(); // создать игру
      EndGame.printGame(game, "Создание игры!", 1);
      StartGame.mixBlock(game); // перемешать колоду
      EndGame.printGame(game, "Перемешивание карт!", 1);
      StartGame.giveCardToPlayers(game); //раздать карты игрокам
      EndGame.printGame(game, "Раздача карт!", 1);

      //Logic.sortBlockAllPlayers(game); //сортировка карт у игроков
      EndGame.printGame(game, "Сортировка карт!", 1);

      //оздать фрейм
      ConsoleView consoleView = new ConsoleView("И Д И О Т");

      //создать массив панелей игроков
      ArrayList<PanelPlayer> playerPanels = new ArrayList<PanelPlayer>(5);
      playerPanels.add(new PanelPlayer(cyan, "Player_1", 0, 0, 200, 200));
      playerPanels.add(new PanelPlayer(pink, "Player_2", 400, 0, 200, 200));
      playerPanels.add(new PanelPlayer(green, "Player_3", 0, 400, 200, 200));
      playerPanels.add(new PanelPlayer(magenta, "Player_4", 400, 400, 200, 200));
      playerPanels.add(new PanelPlayer(yellow, "CENTER", 100, 200, 400, 200));

      //добавление карт на панель игрока
      for (int i = 0; i < 4; i++) {
        Block currPlayerBlock = game.getPlayer(i).getPlayerBlock();
        for (int j = 0; j < currPlayerBlock.getSize(); j++) {
          Cart currPlayerCart = currPlayerBlock.getCart(j);
          currPlayerCart.setLocation(j*25,25);
          playerPanels.get(i).add(currPlayerCart);
        }
        playerPanels.get(i).repaint();
      }


      //отобразить все на экран
      consoleView.repaint();
      //ConsoleView.setConsoleView(game, consoleView);
      for (int i =0; i < 5; i++) {
        consoleView.add(playerPanels.get(i));
      }
      consoleView.setVisible(true); //сделать окно видимым

      //пауза
      ViewLogic.weitClick(consoleView);
      ShowCart.showAll(game, consoleView);
      consoleView.repaint();

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
          ViewLogic.weitClick(consoleView);
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
          ViewLogic.weitClick(consoleView);
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
          ViewLogic.weitClick(consoleView);
          ShowCart.showAll(game, consoleView);

          CurrentStep.getLose(game);
          EndGame.printGame(game, "После взятия!", 0);
          ViewLogic.weitClick(consoleView);
          ShowCart.showAll(game, consoleView);
          // взять карты если не отбился
        }
        CurrentStep.addOnCard(game); // добрать карты из колоды
        EndGame.printGame(game, "После добора!", 0);
        ViewLogic.weitClick(consoleView);
        ShowCart.showAll(game, consoleView);

        //Logic.sortBlockAllPlayers(game);
        CurrentStep.changeCurrentPlayer(game); //сменить ходящего

      }
    }
}
