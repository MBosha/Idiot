package ru.boshyn.idiot.view;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;

public class ConsoleView extends JFrame {
    private static ConsoleView game_window;
    private static long last_ftame_time;


    public ConsoleView(String s) {
    }
    /*private static Image background;
    private static Image game_over;
    private static Image drop;
    private static float drop_left = 100;
    private static float drop_top = -100;
    private static float drop_v = 10;
    private static int score =0;*/

    public static void paintWindow() throws IOException {
        /*background = ImageIO.read(GameWindow.class.getResourceAsStream("background.jpg"));
        game_over = ImageIO.read(GameWindow.class.getResourceAsStream("game_over.jpg"));
        drop = ImageIO.read(GameWindow.class.getResourceAsStream("drop.jpg"));*/
        game_window = new ConsoleView("И Д И О Т"); //создание окна
        game_window.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE); //завершение программы при закрытии окна
        game_window.setLocation(200, 200); //положение окна
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
                //float drop_right = drop_left + drop.getWidth(null);
                //float drop_bottom = drop_top + drop.getHeight(null);
                /*boolean is_drop = x > drop_left && x <= drop_right && y >= drop_top && y < drop_bottom;
                if (is_drop){
                    drop_top = -100;
                    drop_left = (int) Math.random() * (game_field.getWidth() - drop.getWidth(null));
                    drop_v = drop_v +5;
                    score++;
                    game_window.setTitle("Score: " + score);
                }*/
            }
        });

        game_field.setName("Name");

        Panel panel = new Panel();
        panel.setLocation(10,10);
        panel.setBackground(Color.lightGray);



        TextArea textArea = new TextArea();
        textArea.append("Hello");

        JLabel label = new JLabel();
        label.setText("Hello");
        label.setVerticalTextPosition(SwingConstants.CENTER);
        label.setHorizontalTextPosition(SwingConstants.CENTER);



        game_window.setTitle("И Д И О Т");



        game_window.add(panel);
        panel.setLocation(100,100);
        panel.add(label);
        //game_window.add(textArea);
        //game_window.add(label);
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

            /*drop_top = drop_top + drop_v * delta_time;
            drop_left = drop_left + drop_v * delta_time;
            g.drawImage (background, 0, 0, null);
            g.drawImage (drop, (int) drop_left, (int) drop_top, null);
            if (drop_top > game_window.getHeight()) g.drawImage(game_over, 0, 0, null);
            g.drawImage (game_over, 200, 200, null);*/
        }
    }
}
