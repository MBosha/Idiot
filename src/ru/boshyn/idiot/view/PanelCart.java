package ru.boshyn.idiot.view;

import org.jetbrains.annotations.Nullable;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.io.IOException;


class PanelCart extends JPanel {

    private static Image clubs;
    private static Image diamonds;
    private static Image hearts;
    private static Image spades;
    private static Image six;
    private static Image seven;
    private static Image eight;
    private static Image nine;
    private static Image ten;
    private static Image jack;
    private static Image queen;
    private static Image king;
    private static Image ace;

    //private ArrayList<Image> panelCarts = new ArrayList<Image>();

    @Nullable
    public static Image panelSetImgLear(int index) throws IOException {
        switch (index) {
            case 0 :
                return  ImageIO.read(ConsoleView.class.getResourceAsStream("clubs.png"));

            case 1 :
                return ImageIO.read(ConsoleView.class.getResourceAsStream("diamonds.png"));

            case 2 :
                return ImageIO.read(ConsoleView.class.getResourceAsStream("hearts.png"));

            case 3 :
                return ImageIO.read(ConsoleView.class.getResourceAsStream("spades.png"));
        }

        return null;

    }

    @Nullable
    public static Image panelSetImgValue(int index) throws IOException {
        switch (index) {
            case 0 :
            return  ImageIO.read(ConsoleView.class.getResourceAsStream("six.png"));

            case 1 :
                return  ImageIO.read(ConsoleView.class.getResourceAsStream("seven.png"));

            case 2 :
                return ImageIO.read(ConsoleView.class.getResourceAsStream("eight.png"));

            case 3 :
                return ImageIO.read(ConsoleView.class.getResourceAsStream("nine.png"));

            case 4 :
                return ImageIO.read(ConsoleView.class.getResourceAsStream("ten.png"));

            case 5 :
                return ImageIO.read(ConsoleView.class.getResourceAsStream("jack.png"));

            case 6 :
                return ImageIO.read(ConsoleView.class.getResourceAsStream("queen.png"));

            case 7 :
                return ImageIO.read(ConsoleView.class.getResourceAsStream("king.png"));

            case 8 :
                return ImageIO.read(ConsoleView.class.getResourceAsStream("ace.png"));
        }

        return null;
    }

    /*public PanelCart() {
        this.panelCarts = panelCarts;
    }*/

    public static PanelCart newPanelCart() throws IOException {
        GameFields panelCart = new GameFields();
        panelCart.setBackground(Color.RED);
        panelCart.setBounds(200, 150, 25, 50);
        return panelCart;
    }


    /*private void add(Image image) {
        this.panelCarts.add(image);
    }*/


    private static void onRepaint (Graphics g, Image image, int x, int y){
        g.drawImage (image, x, y, null);
    }


    private static class GameFields extends PanelCart {
        @Override
        protected void paintComponent (Graphics g) {
            super.paintComponent(g);
            Image image = null;
            try {
                image = panelSetImgValue(0);
            } catch (IOException e) {
                e.printStackTrace();
            }
            onRepaint(g, image, 2, 0);
            try {
                image = panelSetImgLear(0);
            } catch (IOException e) {
                e.printStackTrace();
            }
            onRepaint(g, image, 2, 26);


            repaint();

        }

    }
}
