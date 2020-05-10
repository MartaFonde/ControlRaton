package app;

import javax.swing.JFrame;

public class App {
    public static void main(String[] args) throws Exception {
        Principal f = new Principal();
        f.setSize(500,300);
        f.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        f.setVisible(true);
    }
}