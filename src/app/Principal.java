package app;

import javax.swing.*;
import java.awt.Color;
import java.awt.event.*;

public class Principal extends JFrame {
    JButton btnIzq;
    JButton btnDer;
    private JLabel lbl;
    Color colorIzq = Color.red;
    Color colorDer = Color.blue;
    Secundario s;
    String titulo;
    

    public Principal() {
        super("Control de Ratón");
        titulo = getTitle();
        setLayout(null);
        setFocusable(true);
        setFocusTraversalKeysEnabled(false);

        lbl = new JLabel("Teclas");
        lbl.setSize(150,60);
        lbl.setLocation(10,70);
        add(lbl);

        btnIzq = new JButton("Izq");
        btnIzq.setSize(btnIzq.getPreferredSize());
        btnIzq.setLocation(20,30);
        btnIzq.setBackground(Color.GRAY);
        btnIzq.addMouseListener(new MouseHandler());
        btnIzq.addMouseMotionListener(new MouseHandler());
        add(btnIzq);

        btnDer = new JButton("Der");
        btnDer.setSize(btnDer.getPreferredSize());
        btnDer.setLocation(80,30);
        btnDer.setBackground(Color.gray);
        btnDer.addMouseListener(new MouseHandler());
        btnDer.addMouseMotionListener(new MouseHandler());
        add(btnDer);

        addMouseListener(new MouseHandler());
        addMouseMotionListener(new MouseHandler());
        addKeyListener(new KeyHandler());
        addWindowListener(new WindowHandler());
        s = new Secundario(this);
    }

    class MouseHandler extends MouseAdapter{
        @Override
        public void mouseMoved(java.awt.event.MouseEvent e) {
            if(e.getSource() == btnIzq) {
                setTitle(titulo+" - (X:"+(btnIzq.getX()+ e.getX())+", Y:"+(btnIzq.getY() + e.getY() + 25)+")");
 
            }else if(e.getSource() == btnDer) {
                setTitle(titulo+" - (X:"+(btnDer.getX() + e.getX())+", Y:"+(btnDer.getY() + e.getY() + 25)+")");
 
            } else {
                setTitle(titulo+" - (X:"+e.getX()+", Y:"+e.getY() + ")");
            }
        }

        @Override
        public void mousePressed(java.awt.event.MouseEvent e) {
            if(e.getButton() == e.BUTTON1){
                btnIzq.setBackground(colorIzq);
            }
            if(e.getButton() == e.BUTTON3){
                btnDer.setBackground(colorDer);
            }
            requestFocus();
        }

        @Override
        public void mouseReleased(java.awt.event.MouseEvent e) {
            if(e.getButton() == e.BUTTON1){
                btnIzq.setBackground(Color.GRAY);
            }
            if(e.getButton() == e.BUTTON3){
                btnDer.setBackground(Color.GRAY);
            }
            requestFocus();
        }
    }

    private class KeyHandler extends KeyAdapter{
        String texto=lbl.getText();
        
        public void keyPressed(java.awt.event.KeyEvent e) {
            lbl.setText("<html><body>Código Unicode: " + (int) e.getKeyChar() +
            "<br>Código teclado: " + e.getKeyCode() + "</body></html>");
            
            if(e.isControlDown() && e.getKeyCode() == 'C'){
                s.pack();
                s.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                s.setVisible(true);
            }
        }
        
        public void keyReleased(java.awt.event.KeyEvent e) {
            lbl.setText(texto);
        }
    }

    private class WindowHandler extends WindowAdapter{
        @Override
        public void windowClosing(WindowEvent e){
            int res = JOptionPane.showConfirmDialog(null, "¿Quieres cerrar el programa?", "Eventos teclado", JOptionPane.YES_NO_OPTION);
            if(res == JOptionPane.YES_OPTION){
                e.getWindow().dispose();
            }
        }
    }
}