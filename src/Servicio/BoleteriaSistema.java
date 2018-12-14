package Servicio;

import Modelo.*;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class BoleteriaSistema {


    private Persistencia.Cliente clientePersistencia;
    private Persistencia.Director directorPersistencia;
    private Persistencia.Asiento asientoPersistencia;
    private Persistencia.Pelicula peliculaPersistencia;
    private Persistencia.Proyeccion proyeccionPersistencia;
    private Persistencia.Venta ventaPersistencia;
    private Persistencia.Sala salaPersistencia;


    private static BoleteriaSistema instanciaUnica = new BoleteriaSistema();

    private BoleteriaSistema() {
        clientePersistencia=new Persistencia.Cliente();
        directorPersistencia=new Persistencia.Director();
        asientoPersistencia=new Persistencia.Asiento();
        peliculaPersistencia=new Persistencia.Pelicula();
        proyeccionPersistencia=new Persistencia.Proyeccion();
        ventaPersistencia=new Persistencia.Venta();
        salaPersistencia=new Persistencia.Sala();


    }



    public static BoleteriaSistema getInstance() {

        return instanciaUnica;
    }

    public void addCliente(Cliente cliente) {
        //listaClientes.add(cliente);
        clientePersistencia.addCliente(cliente);

    }

    public void addCompra(Venta venta) {
        //listaVentas.add(venta);

        ventaPersistencia.addVenta(venta);
    }

    public String clientesToString() {
        String Clientes = "";
        for (int i = 0; i < clientePersistencia.listarClientes().size(); i++) {
            Clientes = Clientes + " " + clientePersistencia.listarClientes().get(i).toString() + " ";
        }
        return Clientes;

    }



    public void addSala(Sala sala) {
        salaPersistencia.addSala(sala);
        //listaSalas.add(sala);
    }

    public void addDirector(Director director) {
        directorPersistencia.addDirector(director);
        //listaDirectores.add(director);
    }

    public ArrayList<Director> getListaDirectores() {

        return directorPersistencia.listarDirectores();

    }

    public ArrayList<Proyeccion> getListaProyecciones() {

        return proyeccionPersistencia.listarProyecciones();

    }

    public Director buscarDirectorPorNombre(String nombre) {
        return directorPersistencia.buscarDirectorPorNombre(nombre);
    }


    public Cliente ClientePorRut(String rut) {
        return clientePersistencia.buscarCliente(rut);
    }


    public Proyeccion ProyeccionPorId(int id) {
        return proyeccionPersistencia.buscarProyeccion(id);
    }

    public void addPelicula(Pelicula pelicula) {

        //listaPeliculas.add(pelicula);

        peliculaPersistencia.addPelicula(pelicula);
    }

    public void addProyeccion(Proyeccion proyeccion) {
        //listaProyecciones.add(proyeccion);
        proyeccionPersistencia.addProyeccion(proyeccion);
    }

    public ArrayList<Sala> getListaSalas() {
        return salaPersistencia.listarSalas();

    }
    public ArrayList<Pelicula> getListaPeliculas() {
        if (peliculaPersistencia.listarPeliculas().size()==0){
            return new ArrayList<Pelicula>();
        }else {
            return peliculaPersistencia.listarPeliculas();
        }
    }


    public Pelicula buscarPeliculaPorId(int id) {
        return peliculaPersistencia.buscarPelicula(id);
    }

    public Sala buscarSalaPorNumero(int nro) {
        return salaPersistencia.buscarSala(nro);

    }

    public ArrayList<Asiento> compraAsientos(Sala sala, int cantidad){
        ArrayList<Asiento> salidaAsiento=new ArrayList<Asiento>();
        int cantidadDisponibles=0;
        for (int i = 0; i <getListaSalas().size(); i++) {
            for (int j = 0; j < getListaSalas().get(i).getListaAsientos().size(); j++) {
                if (getListaSalas().get(i).getListaAsientos().get(j).isDisponibilidad()){
                    cantidadDisponibles++;
                }
            }
        }
        if (cantidad<=cantidadDisponibles){
            for (int i = 0; i <getListaSalas().size(); i++) {
                for (int j = 0; j < getListaSalas().get(i).getListaAsientos().size(); j++) {
                    if (getListaSalas().get(i).getListaAsientos().get(j).isDisponibilidad()){
                        getListaSalas().get(i).getListaAsientos().get(j).setDisponibilidad(false);
                        salidaAsiento.add( getListaSalas().get(i).getListaAsientos().get(j));
                    }
                }
            }


        }
        return salidaAsiento;
    }

    public ArrayList<Cliente> getListaClientes() {
        return clientePersistencia.listarClientes();
    }
}
