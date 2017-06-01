package ru.boshyn.idiot.view;

import org.jetbrains.annotations.Nullable;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.io.IOException;


class PanelCart extends JPanel {

    private int indexLear;
    private int indexValue;
    private int type;

    public int getIndexLear() {
        return indexLear;
    }

    public int getIndexValue() {
        return indexValue;
    }

    public int getType() {
        return type;
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
            case 0:
                return ImageIO.read(ConsoleView.class.getResourceAsStream("img/hearts.png"));
            case 1:
                return ImageIO.read(ConsoleView.class.getResourceAsStream("img/diamonds.png"));
            case 2:
                return ImageIO.read(ConsoleView.class.getResourceAsStream("img/clubs.png"));
            case 3:
                return ImageIO.read(ConsoleView.class.getResourceAsStream("img/spades.png"));
        }
        return null;
    }

    @Nullable
    public static Image panelSetImgValue(int index) throws IOException {
        switch (index) {
            case 0:
                return ImageIO.read(ConsoleView.class.getResourceAsStream("img/six.png"));
            case 1:
                return ImageIO.read(ConsoleView.class.getResourceAsStream("img/seven.png"));
            case 2:
                return ImageIO.read(ConsoleView.class.getResourceAsStream("img/eight.png"));
            case 3:
                return ImageIO.read(ConsoleView.class.getResourceAsStream("img/nine.png"));
            case 4:
                return ImageIO.read(ConsoleView.class.getResourceAsStream("img/ten.png"));
            case 5:
                return ImageIO.read(ConsoleView.class.getResourceAsStream("img/jack.png"));
            case 6:
                return ImageIO.read(ConsoleView.class.getResourceAsStream("img/queen.png"));
            case 7:
                return ImageIO.read(ConsoleView.class.getResourceAsStream("img/king.png"));
            case 8:
                return ImageIO.read(ConsoleView.class.getResourceAsStream("img/ace.png"));
        }
        return null;
    }

    public PanelCart(final int type, final int x, final int y, final int indexL, final int indexV) throws IOException {
        if (type == 0) {
            //вертикальное расопложение карт
            VirtualCart virtualCart = new VirtualCart(type, indexL, indexV);
            this.setIndexLear(indexL);
            this.setIndexValue(indexV);
            this.setBackground(Color.white);
            this.setBounds(x, y, 25, 50);
        } else if (type == 1) {
            VirtualCart virtualCart = new VirtualCart(type, indexL, indexV);
            this.setIndexLear(indexL);
            this.setIndexValue(indexV);
            this.setBackground(Color.white);
            this.setBounds(x, y, 50, 25);
        }
    }

    private static class VirtualCart extends JPanel {
        private int x1;
        private int y1;
        private int x2;
        private int y2;
        private int type;
        private int indexL;
        private int indexV;
        private Graphics g;

        public VirtualCart (int type, int indexL, int indexV) throws IOException {
            super();
            this.type = type;
            this.indexL = indexL;
            this.indexV = indexV;
            this.paintComponent(g);
        }

        @Override
        protected void paintComponent(Graphics g) {
            if (type == 0) {
                x1 = 2;
                y1 = 2;
                x2 = 26;
                y2 = 2;
            }
            if (type == 1) {
                x1 = 2;
                y1 = 2;
                x2 = 2;
                y2 = 26;
            }
            //this.paintComponent(g);
            try {
                onRepaint(g, panelSetImgLear(indexL), x1, y1);
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                onRepaint(g, panelSetImgValue(indexV), x2, y2);
            } catch (IOException e) {
                e.printStackTrace();
            }
            repaint();
        }

        private void onRepaint(Graphics g, Image image, int x, int y) {
            g.drawImage(image, x, y, null);
        }
    }
}

