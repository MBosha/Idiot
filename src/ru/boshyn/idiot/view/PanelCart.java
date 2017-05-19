package ru.boshyn.idiot.view;

import org.jetbrains.annotations.Nullable;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.IOException;


class PanelCart extends JPanel {

    /*private static Image clubs;
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
    private static Image ace;*/

    private int indexLear;
    private int indexValue;

    public int getIndexLear() {
        return indexLear;
    }

    public int getIndexValue() {
        return indexValue;
    }

    public void setIndexLear(int indexLear) {
        this.indexLear = indexLear;
    }

    public void setIndexValue(int indexValue) {
        this.indexValue = indexValue;
    }

    @Nullable
    public static Image panelSetImgLear(int index) throws IOException {
        switch (index) {
            case 0 :
                return  ImageIO.read(ConsoleView.class.getResourceAsStream("img/hearts.png"));

            case 1 :
                return ImageIO.read(ConsoleView.class.getResourceAsStream("img/diamonds.png"));

            case 2 :
                return ImageIO.read(ConsoleView.class.getResourceAsStream("img/clubs.png"));

            case 3 :
                return ImageIO.read(ConsoleView.class.getResourceAsStream("img/spades.png"));
        }

        return null;

    }

    @Nullable
    public static Image panelSetImgValue(int index) throws IOException {
        switch (index) {
            case 0 :
            return  ImageIO.read(ConsoleView.class.getResourceAsStream("img/six.png"));

            case 1 :
                return  ImageIO.read(ConsoleView.class.getResourceAsStream("img/seven.png"));

            case 2 :
                return ImageIO.read(ConsoleView.class.getResourceAsStream("img/eight.png"));

            case 3 :
                return ImageIO.read(ConsoleView.class.getResourceAsStream("img/nine.png"));

            case 4 :
                return ImageIO.read(ConsoleView.class.getResourceAsStream("img/ten.png"));

            case 5 :
                return ImageIO.read(ConsoleView.class.getResourceAsStream("img/jack.png"));

            case 6 :
                return ImageIO.read(ConsoleView.class.getResourceAsStream("img/queen.png"));

            case 7 :
                return ImageIO.read(ConsoleView.class.getResourceAsStream("img/king.png"));

            case 8 :
                return ImageIO.read(ConsoleView.class.getResourceAsStream("img/ace.png"));
        }

        return null;
    }


    public PanelCart newPanelCartVertical(int x, int y, int indexL, int indexV) throws IOException {
        GameFieldsVertical panelCart = new GameFieldsVertical();
        panelCart.setIndexLear(indexL);
        panelCart.setIndexValue(indexV);
        panelCart.setBackground(Color.white);
        panelCart.setBounds(x, y, 25, 50);
        return panelCart;
    }

    public PanelCart newPanelCartHorizontal(int x, int y, int indexL, int indexV) throws IOException {
        GameFieldsHorizontal panelCart = new GameFieldsHorizontal();
        panelCart.setIndexLear(indexL);
        panelCart.setIndexValue(indexV);
        panelCart.setBackground(Color.white);
        panelCart.setBounds(x, y, 50, 25);
        return panelCart;
    }



    private static class GameFieldsVertical extends PanelCart {

        @Override
        protected void paintComponent (Graphics g) {
            super.paintComponent(g);
            try {
                Image image = panelSetImgLear(this.getIndexLear());
                onRepaint(g, image, 2, 0);
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                onRepaint(g, panelSetImgValue(this.getIndexValue()), 2, 26);
            } catch (IOException e) {
                e.printStackTrace();
            }
            repaint();
        }
    }

    private static class GameFieldsHorizontal extends PanelCart {

        @Override
        protected void paintComponent (Graphics g) {
            super.paintComponent(g);
            try {
                Image image = panelSetImgLear(this.getIndexLear());
                onRepaint(g, image, 2, 0);
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                onRepaint(g, panelSetImgValue(this.getIndexValue()), 26, 0);
            } catch (IOException e) {
                e.printStackTrace();
            }
            repaint();
        }
    }

    private static void onRepaint (Graphics g, Image image, int x, int y){
        g.drawImage (image, x, y, null);
    }

    public static void click(PanelCart panelCart) {
        final int[] x = {-1};
        final int[] y = {-1};
        while (x[0] < 0) {
            panelCart.addMouseListener(new MouseAdapter() {

                @Override
                public void mousePressed(MouseEvent e) {
                    super.mousePressed(e);
                    x[0] = e.getX();
                    y[0] = e.getY();
                }
            });
        }
    }
}
