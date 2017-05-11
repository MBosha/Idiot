package ru.boshyn.idiot.view;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.io.IOException;

public class ConsoleView extends JFrame {
    private static ConsoleView game_window;
    private static long last_ftame_time;


    public ConsoleView(String s) {
    }

    private static Image clubs;

    /*private static Image background;
    private static Image game_over;
    private static Image drop;
    private static float drop_left = 100;
    private static float drop_top = -100;
    private static float drop_v = 10;
    private static int score =0;*/

    public static void paintWindow() throws IOException {
        clubs = ImageIO.read(ConsoleView.class.getResourceAsStream("Clubs.jpg"));

        /*background = ImageIO.read(GameWindow.class.getResourceAsStream("background.jpg"));
        game_over = ImageIO.read(GameWindow.class.getResourceAsStream("game_over.jpg"));
        drop = ImageIO.read(GameWindow.class.getResourceAsStream("drop.jpg"));*/

        game_window = new ConsoleView("И Д И О Т"); //создание окна
        game_window.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE); //завершение программы при закрытии окна
        game_window.setLocation(200, 200); //положение окна
        game_window.setSize(500, 500); //размер окна
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

        game_window.setTitle("И Д И О Т");

        JPanel panel0 = new JPanel();
        panel0.setSize(200,200);

        JPanel panel1 = new JPanel();
        panel1.setBackground(Color.lightGray);
        panel1.add(new JLabel("Player_1"));
        panel1.setSize(200,200);

        JPanel panel2 = new JPanel();
        panel2.setBackground(Color.BLUE);
        panel2.add(new JLabel("Player_2"));

        JPanel panel3 = new JPanel();
        panel3.setBackground(Color.GREEN);
        panel3.add(new JLabel("Player_3"));

        JPanel panel4 = new JPanel();
        panel4.setBackground(Color.MAGENTA);
        panel4.add(new JLabel("Player_4"));

        JPanel panelC = new JPanel();
        panelC.setBackground(Color.YELLOW);
        panel4.setSize(100,100);
        panelC.add(new JLabel("CENTER"));

        panel0.setLayout(null);



        panel0.setBounds(0, 0, 500, 500);
        game_window.add(panel0);


        panel1.setBounds(0, 0, 400, 100);
        panel0.add(panel1);

        panel2.setBounds(0, 100, 100, 400);
        panel0.add(panel2);

        panel3.setBounds(400, 0, 100, 400);
        panel0.add(panel3);

        panel4.setBounds(100, 400, 400, 100);
        panel0.add(panel4);

        panelC.setBounds(100, 100, 400, 400);
        panel0.add(panelC);

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
