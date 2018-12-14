package Vista;

import Modelo.VentaInternet;
import Modelo.VentaPresencial;
import Modelo.VentaTelefonica;
import Servicio.BoleteriaSistema;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.lang.reflect.Array;
import java.util.ArrayList;

public class Venta{

    private JTextField monto;
    private JButton agregarButton;
    private JComboBox TipoVenta;
    private JPanel rootPanel;
    private JTextField nroasientos;
    private JComboBox rutClienteCombobox;
    private JComboBox idProyeccionCombobox;
    BoleteriaSistema boleteriaSistema = BoleteriaSistema.getInstance();

    public Venta() {
        ArrayList<Modelo.Cliente> listaClientes=boleteriaSistema.getListaClientes();
        for (int i = 0; i <listaClientes.size(); i++) {
            rutClienteCombobox.addItem(listaClientes.get(i).getRut());
        }
        rutClienteCombobox.setSelectedIndex(0);
        ArrayList<Modelo.Proyeccion> listaProyeccion=boleteriaSistema.getListaProyecciones();
        for (int i = 0; i < listaProyeccion.size(); i++) {
            idProyeccionCombobox.addItem(listaProyeccion.get(i).getIdProyeccion());
        }
        idProyeccionCombobox.setSelectedIndex(0);

        agregarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                String rut_Cliente = rutClienteCombobox.getSelectedItem().toString();
                int id_Proyeccion = Integer.parseInt(idProyeccionCombobox.getSelectedItem().toString());
                int monto_Venta = Integer.parseInt(monto.getText());
                String tipo_Venta = TipoVenta.getSelectedItem().toString();
                int cantidad_Asientos=Integer.parseInt(nroasientos.getText());

                if("Presencial".equalsIgnoreCase(tipo_Venta)){
                    if (cantidad_Asientos>5) {
                        JOptionPane.showMessageDialog(null, "Puede comprar máximo 5 entradas");
                    }else {
                        boleteriaSistema.addCompra(new VentaPresencial(boleteriaSistema.ClientePorRut(rut_Cliente), boleteriaSistema.ProyeccionPorId(id_Proyeccion), boleteriaSistema.compraAsientos(boleteriaSistema.ProyeccionPorId(id_Proyeccion).getSala(), cantidad_Asientos), monto_Venta));

                        JOptionPane.showMessageDialog(null, "Compra Presencial realizada con exito");
                    }
                    }else{
                    if("Internet".equalsIgnoreCase(tipo_Venta)){
                        boleteriaSistema.addCompra(new VentaInternet(boleteriaSistema.ClientePorRut(rut_Cliente),boleteriaSistema.ProyeccionPorId(id_Proyeccion), boleteriaSistema.compraAsientos(boleteriaSistema.ProyeccionPorId(id_Proyeccion).getSala(),cantidad_Asientos),monto_Venta));
                        JOptionPane.showMessageDialog(null, "Compra Internet realizada con exito");
                    }else{
                        if ("Telefonica".equalsIgnoreCase(tipo_Venta)){
                            if (cantidad_Asientos>7) {
                                JOptionPane.showMessageDialog(null, "Puede comprar máximo 7 entradas");
                            }else {

                                boleteriaSistema.addCompra(new VentaTelefonica(boleteriaSistema.ClientePorRut(rut_Cliente), boleteriaSistema.ProyeccionPorId(id_Proyeccion), boleteriaSistema.compraAsientos(boleteriaSistema.ProyeccionPorId(id_Proyeccion).getSala(), cantidad_Asientos), monto_Venta));
                                JOptionPane.showMessageDialog(null, "Compra Telefonica realizada con exito");
                            }
                            }
                    }
                }

            }
        });
    }

    public static void main() {
        JFrame frame=new JFrame("App");
        frame.setContentPane(new Venta().rootPanel);

        frame.pack();
        frame.setExtendedState(6);
        frame.setVisible(true);
    }

}
