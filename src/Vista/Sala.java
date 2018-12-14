package Vista;

import Modelo.Asiento;
import Servicio.BoleteriaSistema;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class Sala {
    private JTextField numeroSala;
    private JComboBox comboBox1;
    private JTextField textField1;
    private JButton agregarSalaButton;
    private JPanel rootPanel;
    private ArrayList<Asiento> listadoAsientos=new ArrayList<Asiento>();


    BoleteriaSistema boleteriaSistema = BoleteriaSistema.getInstance();


    public Sala() {
        agregarSalaButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                int nro_sala=Integer.parseInt(numeroSala.getText());
                String tipo_sala=comboBox1.getSelectedItem().toString();
                int cantidad_asientos=Integer.parseInt(textField1.getText());

                for (int i = 0; i <cantidad_asientos; i++) {
                    listadoAsientos.add(new Asiento(i,i,true));
                }
                Modelo.Sala sala=new Modelo.Sala(nro_sala,tipo_sala,listadoAsientos);
                boleteriaSistema.addSala(sala);
                JOptionPane.showMessageDialog(null, "Sala agregado con exito");

            }
        });
    }
    public static void main() {
        JFrame frame=new JFrame("App");
        frame.setContentPane(new Sala().rootPanel);

        frame.pack();
        frame.setExtendedState(6);
        frame.setVisible(true);
    }
}
