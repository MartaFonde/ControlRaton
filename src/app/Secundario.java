package app;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Secundario extends JDialog implements ActionListener, ItemListener {
    private JLabel lblTitulo;
    private JLabel lblColor;
    JTextField txfTitulo;
    JComboBox<String> listaIzq;
    JComboBox<String> listaDer;
    String[] coloresNombre = {"Rojo", "Azul", "Verde", "Naranja", "Rosa", "Blanco", "Magenta", "Amarillo"};
    Color[] colores = {Color.RED, Color.BLUE, Color.green, Color.ORANGE, Color.pink, Color.white, Color.MAGENTA, Color.YELLOW};
    private JButton btnOk;


    public Secundario(Principal f) {
        super(f, true);
        setLayout(new FlowLayout());
        setTitle("Configuración");

        lblTitulo = new JLabel("Nuevo título: ");
        add(lblTitulo);

        txfTitulo = new JTextField(20);
        txfTitulo.addActionListener(this);
        add(txfTitulo);

        lblColor = new JLabel("Colores botones");
        add(lblColor);

        listaIzq = new JComboBox<String>(coloresNombre);
        listaIzq.setSelectedIndex(0);
        listaIzq.addItemListener(this);
        add(listaIzq);

        listaDer = new JComboBox<String>(coloresNombre);
        listaDer.setSelectedIndex(1);
        listaDer.addItemListener(this);
        add(listaDer);

        btnOk = new JButton("OK");
        btnOk.addActionListener(this);
        add(btnOk);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == btnOk){
            Principal f = (Principal)this.getOwner();
            f.setTitle(txfTitulo.getText());
            f.titulo=(txfTitulo.getText());
            setVisible(false);
        }
    }

    @Override
    public void itemStateChanged(ItemEvent e) {
        Principal p = (Principal)this.getOwner();
        p.colorIzq = colores[listaIzq.getSelectedIndex()];
        p.colorDer = colores[listaDer.getSelectedIndex()];
    }
}