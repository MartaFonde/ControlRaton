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

        lbl = new JLabel("Teclas");
        lbl.setSize(150,60);
        lbl.setLocation(10,70);
        add(lbl);

        btnIzq = new JButton("Izq");
        btnIzq.setSize(btnIzq.getPreferredSize());
        btnIzq.setLocation(20,30);
        btnIzq.setBackground(Color.GRAY);
        btnIzq.addMouseListener(new MouseHandler());
        add(btnIzq);

        btnDer = new JButton("Der");
        btnDer.setSize(btnDer.getPreferredSize());
        btnDer.setLocation(80,30);
        btnDer.setBackground(Color.gray);
        btnDer.addMouseListener(new MouseHandler());
        add(btnDer);

        this.getContentPane().addMouseListener(new MouseHandler());
        addKeyListener(new KeyHandler());
        addWindowListener(new WindowHandler());
        s = new Secundario(this);
    }

    class MouseHandler extends MouseAdapter{
        public void mouseEntered(java.awt.event.MouseEvent e) {
            if(e.getXOnScreen() < 800 && e.getYOnScreen() < 600){
                setTitle(titulo+" - X:"+e.getXOnScreen()+", Y:"+e.getYOnScreen());
            }
        }

        public void mouseExited(java.awt.event.MouseEvent e) {
            setTitle(titulo);
        }

        public void mousePressed(java.awt.event.MouseEvent e) {
            if(e.getButton() == e.BUTTON1){
                btnIzq.setBackground(colorIzq);
            }
            if(e.getButton() == e.BUTTON3){
                btnDer.setBackground(colorDer);
            }
        }

        public void mouseReleased(java.awt.event.MouseEvent e) {
            if(e.getButton() == e.BUTTON1){
                btnIzq.setBackground(Color.GRAY);
            }
            if(e.getButton() == e.BUTTON3){
                btnDer.setBackground(Color.GRAY);
            }
        }
    }

    private class KeyHandler extends KeyAdapter{
        String texto=lbl.getText();
        
        public void keyPressed(java.awt.event.KeyEvent e) {
            lbl.setText("<html><body>Unicode: "+e.getKeyChar()+
            "<br>Código teclado: "+e.getKeyCode()+"</body></html>");
            
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