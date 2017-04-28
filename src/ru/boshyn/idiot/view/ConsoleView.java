package ru.boshyn.idiot.view;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;

public class ConsoleView extends JFrame{
    private static ConsoleView game_window;
    private static long last_ftame_time;
    /*private static Image background;
    private static Image game_over;
    private static Image drop;*/
    private static float drop_left = 100;
    private static float drop_top = -100;
    private static float drop_v = 10;
    private static int score =0;

    public static void paintWindow() throws IOException{
        /*background = ImageIO.read(GameWindow.class.getResourceAsStream("background.jpg"));
        game_over = ImageIO.read(GameWindow.class.getResourceAsStream("game_over.jpg"));
        drop = ImageIO.read(GameWindow.class.getResourceAsStream("drop.jpg"));*/
        game_window.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE); //завершение программы при закрытии окна
        game_window.setLocation(50, 50); //положение окна
        game_window.setSize(906, 478); //размер окна
        game_window.setResizable(false); //запрет на изменение размера окна
        last_ftame_time = System.nanoTime(); // задание таймера обновления
        GameFields game_field = new GameFields();
        game_field.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                super.mousePressed(e);
                int x = e.getX();
                int y = e.getY();
                if (is_drop){
                    drop_top = -100;
                    drop_left = (int) Math.random() * (game_field.getWidth() - drop.getWidth(null));
                    drop_v = drop_v +5;
                    score++;
                    game_window.setTitle("Score: " + score);
            }
        });
        game_window.add (game_field);
        game_window.setVisible(true); //сделать окно видимым
    }

    private static void onRepaint (Graphics g){
        for (int i = 1; i <= 100; i++) {
            int x1 = 5 * i;
            int y1 = 6 * i;
            int x2 = 7 * i;
            int y2 = 8 * i;
            long current_time = System.nanoTime();
            float delta_time = (current_time - last_ftame_time) * 0.000000001f;
            last_ftame_time = current_time;

            drop_left = drop_left + drop_v * delta_time;
            g.drawImage (background, 0, 0, null);
            g.drawImage (drop, (int) drop_left, (int) drop_top, null);
        }

    }

    private static class GameFields extends JPanel {
        @Override
        protected void paintComponent (Graphics g) {
            super.paintComponent(g);
            onRepaint(g);
            repaint();

        }
    }
}
