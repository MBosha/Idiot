package ru.boshyn.idiot;

import ru.boshyn.idiot.model.Block;
import ru.boshyn.idiot.model.Cart;

import static ru.boshyn.idiot.model.Cart.newCart;

public class Main {

    public static void main (String args[]) {

      Game game = CreateGame();
      mixBlock(game.gameBlock);
      giveCardToPlayers(game);
      ConsoleView consoleView = new ConsoleView();

      while (!endGame()) {
        final Block block = new Block();
        Cart cart = new Cart();
        newCart(cart,1,1);
        block.addCart(cart);

        cart = block.getCart(0);
        System.out.println("Lear:" + cart.getLear(cart) + " Value:" + cart.getValue(cart) + " BlockSize: " + block.getSize());

      }
    }
}
