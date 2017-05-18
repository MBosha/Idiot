package ru.boshyn.idiot.view;

import org.jetbrains.annotations.Nullable;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.ImageObserver;
import java.io.IOException;
import java.text.AttributedCharacterIterator;


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

    private int indexLear;
    private int indexValue;



    //private ArrayList<Image> panelCarts = new ArrayList<Image>();

    @Nullable
    public static Image panelSetImgLear(int index) throws IOException {
        switch (index) {
            case 0 :
                return  ImageIO.read(ConsoleView.class.getResourceAsStream("hearts.png"));

            case 1 :
                return ImageIO.read(ConsoleView.class.getResourceAsStream("diamonds.png"));

            case 2 :
                return ImageIO.read(ConsoleView.class.getResourceAsStream("clubs.png"));

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

    public PanelCart newPanelCart(int x, int y, int indexL, int indexV) throws IOException {
        indexLear = indexL;
        indexValue = indexV;
        GameFields panelCart = new GameFields();
        panelCart.setBackground(Color.RED);
        panelCart.setBounds(x, y, 25, 50);
        return panelCart;
    }


    /*private void add(Image image) {
        this.panelCarts.add(image);
    }*/


    public static boolean paint(int x, int y){
        return graphics.drawImage (nine, x, y, null);
    }

    private static class GameFields extends PanelCart {

        @Override
        protected void paintComponent (Graphics g) {
            super.paintComponent(g);
            try {
                Image image = panelSetImgLear(indexLear);
                onRepaint(g, image, 2, 0);
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                onRepaint(g, panelSetImgValue(indexValue), 2, 26);
            } catch (IOException e) {
                e.printStackTrace();
            }
            //PanelCart.indexLear = -1;
            //PanelCart.indexValue = -1;
            repaint();

        }

    }

    private static void onRepaint (Graphics g, Image image, int x, int y){
        g.drawImage (image, x, y, null);
    }

    private static Graphics graphics = new Graphics() {
        @Override
        public Graphics create() {
            return null;
        }

        @Override
        public void translate(int x, int y) {

        }

        @Override
        public Color getColor() {
            return null;
        }

        @Override
        public void setColor(Color c) {

        }

        @Override
        public void setPaintMode() {

        }

        @Override
        public void setXORMode(Color c1) {

        }

        @Override
        public Font getFont() {
            return null;
        }

        @Override
        public void setFont(Font font) {

        }

        @Override
        public FontMetrics getFontMetrics(Font f) {
            return null;
        }

        @Override
        public Rectangle getClipBounds() {
            return null;
        }

        @Override
        public void clipRect(int x, int y, int width, int height) {

        }

        @Override
        public void setClip(int x, int y, int width, int height) {

        }

        @Override
        public Shape getClip() {
            return null;
        }

        @Override
        public void setClip(Shape clip) {

        }

        @Override
        public void copyArea(int x, int y, int width, int height, int dx, int dy) {

        }

        @Override
        public void drawLine(int x1, int y1, int x2, int y2) {

        }

        @Override
        public void fillRect(int x, int y, int width, int height) {

        }

        @Override
        public void clearRect(int x, int y, int width, int height) {

        }

        @Override
        public void drawRoundRect(int x, int y, int width, int height, int arcWidth, int arcHeight) {

        }

        @Override
        public void fillRoundRect(int x, int y, int width, int height, int arcWidth, int arcHeight) {

        }

        @Override
        public void drawOval(int x, int y, int width, int height) {

        }

        @Override
        public void fillOval(int x, int y, int width, int height) {

        }

        @Override
        public void drawArc(int x, int y, int width, int height, int startAngle, int arcAngle) {

        }

        @Override
        public void fillArc(int x, int y, int width, int height, int startAngle, int arcAngle) {

        }

        @Override
        public void drawPolyline(int[] xPoints, int[] yPoints, int nPoints) {

        }

        @Override
        public void drawPolygon(int[] xPoints, int[] yPoints, int nPoints) {

        }

        @Override
        public void fillPolygon(int[] xPoints, int[] yPoints, int nPoints) {

        }

        @Override
        public void drawString(String str, int x, int y) {

        }

        @Override
        public void drawString(AttributedCharacterIterator iterator, int x, int y) {

        }

        @Override
        public boolean drawImage(Image img, int x, int y, ImageObserver observer) {
            return true;
        }

        @Override
        public boolean drawImage(Image img, int x, int y, int width, int height, ImageObserver observer) {
            return false;
        }

        @Override
        public boolean drawImage(Image img, int x, int y, Color bgcolor, ImageObserver observer) {
            return false;
        }

        @Override
        public boolean drawImage(Image img, int x, int y, int width, int height, Color bgcolor, ImageObserver observer) {
            return false;
        }

        @Override
        public boolean drawImage(Image img, int dx1, int dy1, int dx2, int dy2, int sx1, int sy1, int sx2, int sy2, ImageObserver observer) {
            return false;
        }

        @Override
        public boolean drawImage(Image img, int dx1, int dy1, int dx2, int dy2, int sx1, int sy1, int sx2, int sy2, Color bgcolor, ImageObserver observer) {
            return false;
        }

        @Override
        public void dispose() {

        }
    };

}
