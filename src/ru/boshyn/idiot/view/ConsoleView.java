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


    /*private static Image background;
    private static Image game_over;
    private static Image drop;
    private static float drop_left = 100;
    private static float drop_top = -100;
    private static float drop_v = 10;
    private static int score =0;*/

    public ConsoleView(String s) {
    }

    public static void paintWindow() throws IOException {

        game_window = new ConsoleView("И Д И О Т"); //создание окна
        game_window.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE); //завершение программы при закрытии окна
        game_window.setLocation(200, 200); //положение окна
        game_window.setSize(500, 500); //размер окна
        game_window.setResizable(false); //запрет на изменение размера окна
        game_window.setTitle("И Д И О Т");
        game_window.setLayout(null);

        last_ftame_time = System.nanoTime(); // задание таймера обновления

        JPanel panel1 = new JPanel();
        panel1.setBackground(Color.lightGray);
        panel1.add(new JLabel("Player_1"));

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
        JLabel labelC = new JLabel("CENTER");
        panelC.add(labelC);
        panelC.setBackground(Color.YELLOW);

        panel1.setBounds(0, 0, 400, 100);
        game_window.add(panel1);

        panel2.setBounds(400, 0, 100, 400);
        game_window.add(panel2);


        panel3.setBounds(100, 400, 400, 100);
        game_window.add(panel3);

        panel4.setBounds(0, 100, 100, 400);
        game_window.add(panel4);

        panelC.setBounds(100, 100, 300, 300);
        game_window.add(panelC);

        game_window.add(PanelCart.newPanelCart(100, 100, 0, 0));
        game_window.add(PanelCart.newPanelCart(200, 200, 1, 3));
        game_window.add(PanelCart.newPanelCart(300, 300, 2, 5));
        game_window.add(PanelCart.newPanelCart(400, 400, 3, 8));

        PanelCart.paint(50,50);

        //GameFields game_field = new GameFields();

        panelC.addMouseListener(new MouseAdapter() {
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

        game_window.setVisible(true); //сделать окно видимым

    }
}
