package Vista;

import Servicio.BoleteriaSistema;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Cliente {
    private JTextField nombreCliente;
    private JTextField RUTClienteTextField;
    private JTextField emailCliente;
    private JTextField telefonoCliente;
    private JButton agregarButton;
    private JPanel rootPanel;
    private JButton listarClientesButton;
    private JTextArea listadoClientes;
    BoleteriaSistema boleteriaSistema = BoleteriaSistema.getInstance();

    public Cliente() {
        agregarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                String nombre_Cliente=nombreCliente.getText();
                String rut_Cliente=RUTClienteTextField.getText();
                String email_Cliente=emailCliente.getText();
                int telefono_Cliente=Integer.parseInt(telefonoCliente.getText());

                Modelo.Cliente cliente=new Modelo.Cliente(nombre_Cliente,rut_Cliente,email_Cliente,telefono_Cliente);
                boleteriaSistema.addCliente(cliente);
                nombreCliente.setText("");
                RUTClienteTextField.setText("");
                emailCliente.setText("");
                telefonoCliente.setText("");
                JOptionPane.showMessageDialog(null, "Cliente agregado con exito");

            }
        });

        listarClientesButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                listadoClientes.insert(boleteriaSistema.clientesToString(),0);
            }
        });
    }
    public static void main() {
        JFrame frame=new JFrame("App");
        frame.setContentPane(new Cliente().rootPanel);

        frame.pack();
        frame.setExtendedState(6);
        frame.setVisible(true);
    }
}
