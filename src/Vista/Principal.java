package Vista;

import Modelo.Director;

import Servicio.BoleteriaSistema;


import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Principal {
    private JButton peliculasButton;
    private JButton clienteButton;
    private JButton salasButton;
    private JButton proyeccionesButton;
    private JPanel rootPanel;
    private JButton VENTASButton;
    BoleteriaSistema boleteriaSistema = BoleteriaSistema.getInstance();

    public Principal() {
        Director d1=new Director("Juan","11.111.111-9", "Chileno");
        Director d2=new Director("Pedro", "22.222.222-4", "Chileno");
        Director d3=new Director("Fabian", "99.999.999-5", "Chileno");
        boleteriaSistema.addDirector(d1);
        boleteriaSistema.addDirector(d2);
        boleteriaSistema.addDirector(d3);


        peliculasButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                Pelicula pelicula=new Pelicula();
                pelicula.main();
            }
        });
        clienteButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                Cliente cliente=new Cliente();
                cliente.main();
            }
        });
        salasButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                Sala sala=new Sala();
                sala.main();
            }
        });
        proyeccionesButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                Vista.Proyeccion proyeccion=new Vista.Proyeccion();
                proyeccion.main();
            }
        });
        VENTASButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                Venta venta=new Venta();
                venta.main();
            }
        });
    }

    public static void main() {


        JFrame frame=new JFrame("App");
        frame.setContentPane(new Principal().rootPanel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setExtendedState(6);
        frame.pack();
        frame.setVisible(true);
    }
}
