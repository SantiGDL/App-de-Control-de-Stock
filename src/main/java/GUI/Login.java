package GUI;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Login {
    private JPanel PanelPrincipal;
    private JPanel Panel_Izquierdo;
    private JButton crearProveedorButton;
    private JButton comprarItemButton;


    public Login() {}

    public static void main(String[] args) {
        JFrame frame = new JFrame("EstacionDeTrabajo");
        frame.setContentPane(new Login().PanelPrincipal);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setSize(500, 500);
        frame.setVisible(true);
    }
}
