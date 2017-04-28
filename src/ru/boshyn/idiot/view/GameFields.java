package ru.boshyn.idiot.view;

private static class GameFields extends JPanel {
    @Override
    protected void paintComponent (Graphics g) {
        super.paintComponent(g);
        onRepaint(g);
        repaint();
    }
}
