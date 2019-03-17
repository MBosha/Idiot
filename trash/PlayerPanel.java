package ru.boshyn.idiot.view;

public class PlayerPanel extends JPanel{

    public PlayerPanel(Color color, String playerName, int x, int y, int width, int height) {
        super();
        this.setBackground(color);
        this.add(new JLabel(playerName));
        this.setBounds(x, y, width, height);
    }


}
