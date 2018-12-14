package Vista;

import Servicio.BoleteriaSistema;


import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

public class Proyeccion {
    private static JFrame frame;
    private JComboBox SalacomboBox;
    private JTextField horario;
    private JTextField precioTextField;
    private JTextField localidadTextField;
    private JTextField dia;
    private JComboBox PeliculacomboBox;
    private JButton agregarProyeccionButton;
    private JPanel rootPanel;
    private JTextField mes;
    private JTextField anio;
    BoleteriaSistema boleteriaSistema = BoleteriaSistema.getInstance();
    private ArrayList<Modelo.Sala> listaSalas;
    private ArrayList<Modelo.Pelicula> listaPeliculas;


    public Proyeccion() {
        listaSalas=boleteriaSistema.getListaSalas();
        listaPeliculas=boleteriaSistema.getListaPeliculas();

        for (int i = 0; i < listaSalas.size(); i++) {
            SalacomboBox.addItem(listaSalas.get(i).getNumeroSala());
        }

        for (int i = 0; i < listaPeliculas.size(); i++) {
            PeliculacomboBox.addItem(listaPeliculas.get(i).getIdPelicula());
        }

        agregarProyeccionButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                int numero_sala=Integer.parseInt(SalacomboBox.getSelectedItem().toString());
                int horario_pelicula=Integer.parseInt(horario.getText());
                int precio_proyeccion=Integer.parseInt(precioTextField.getText());
                String localidad=localidadTextField.getText();
                int dia1=Integer.parseInt(dia.getText());
                int mes1=Integer.parseInt(mes.getText());
                int anio1=Integer.parseInt(anio.getText());
                SimpleDateFormat sdf = new SimpleDateFormat("MM-dd-yyyy");

                Calendar cal = Calendar.getInstance();
                cal.set(Calendar.YEAR, anio1);
                cal.set(Calendar.MONTH, mes1 - 1); // <-- months start
                // at 0.
                cal.set(Calendar.DAY_OF_MONTH, dia1);

                java.sql.Date date = new java.sql.Date(cal.getTimeInMillis());


                Date fecha_proyeccion=date;
                int id_pelicula=Integer.parseInt(PeliculacomboBox.getSelectedItem().toString());
                boleteriaSistema.addProyeccion(new Modelo.Proyeccion(boleteriaSistema.getListaProyecciones().size(),boleteriaSistema.buscarPeliculaPorId(id_pelicula),horario_pelicula, (java.sql.Date)fecha_proyeccion,boleteriaSistema.buscarSalaPorNumero(numero_sala),localidad,precio_proyeccion));
                JOptionPane.showMessageDialog(null, "Proyeccion agregado con exito");

            }
        });
    }

    public static void main() {
        frame=new JFrame("App");
        frame.setContentPane(new Proyeccion().rootPanel);
        frame.pack();
        frame.setExtendedState(6);
        frame.setVisible(true);
    }
}
