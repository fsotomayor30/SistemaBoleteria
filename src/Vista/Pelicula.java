package Vista;

import Modelo.Director;
import Servicio.BoleteriaSistema;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class Pelicula {

    BoleteriaSistema boleteriaSistema = BoleteriaSistema.getInstance();
    private JTextField duracionHora;
    private JTextField idioma;
    private JTextField duracionMinutos;
    private JTextArea resumen;
    private JButton agregarPeliculaButton;
    private JTextArea listarPeliculas;
    private JButton listarPeliculasButton;
    private JComboBox directorCombobox;
    private JPanel rootPanel;
    private ArrayList<Director> listaDirectores=boleteriaSistema.getListaDirectores();

    public Pelicula() {

        for (int i = 0; i <listaDirectores.size(); i++) {
            directorCombobox.addItem(listaDirectores.get(i).getNombre());
        }
        directorCombobox.setSelectedIndex(0);
        agregarPeliculaButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                int duracion_hora=Integer.parseInt(duracionHora.getText());
                int duracion_minutos=Integer.parseInt(duracionMinutos.getText());
                String idioma_pelicula=idioma.getText();
                String resumen_pelicula=resumen.getText();
                String nombre_director=directorCombobox.getSelectedItem().toString();
                Director director=boleteriaSistema.buscarDirectorPorNombre(nombre_director);

                Modelo.Pelicula pelicula=new Modelo.Pelicula();
                pelicula.setDuracionHora(duracion_hora);
                pelicula.setDuracionMinutos(duracion_minutos);
                pelicula.setIdioma(idioma_pelicula);
                pelicula.setDirector(director);
                pelicula.setResumen(resumen_pelicula);


                boleteriaSistema.addPelicula(pelicula);
                JOptionPane.showMessageDialog(null, "Pelicula agregado con exito");
            }
        });
        listarPeliculasButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                ArrayList<Modelo.Pelicula> peliculas=boleteriaSistema.getListaPeliculas();
                String resultado="";
                for (int i = 0; i < peliculas.size(); i++) {
                    resultado=resultado+" Director: "+peliculas.get(i).getDirector()+" Idioma: "+peliculas.get(i).getIdioma()+" Resumen: "+peliculas.get(i).getResumen()+" Duración horas: "+peliculas.get(i).getDuracionHora()+" Duración minutos: " +peliculas.get(i).getDuracionMinutos()+"\n";
                }

                listarPeliculas.setText(resultado);
            }
        });

    }

    public static void main() {
        JFrame frame=new JFrame("App");
        frame.setContentPane(new Pelicula().rootPanel);

        frame.pack();
        frame.setExtendedState(6);
        frame.setVisible(true);
    }

}
