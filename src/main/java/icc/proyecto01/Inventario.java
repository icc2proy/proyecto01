package icc.proyecto01;

import java.io.Serializable;
import java.io.*;

/**
 * Clase que simula el inventario que se tiene en la tienda
 * guardando cada pelicula en una lista.
 */
public class Inventario implements Serializable {

    private ListaLigadaDoble inventario; // Lista en donde vamos guardando las peliculas.
    private int contador = 1; // Nos sirve para ir agregando elementos al final de la lista.

    /**
     * Constructor de la clase que inicializa la lista ligada.
     */
    public Inventario() {
        inventario = new ListaLigadaDoble();
    }

    /**
     * Medodo que agrega peliculas a la lista e incrementa
     * el contador en uno para ir agregando al final de la
     * lista y simular una cola.
     */
    public void agregaPelicula(final Pelicula p) {
        inventario.add(contador, p);
        contador++;
    }

    /**
     * Metodo que devuelve la lista en donde estan las peliculas.
     * @return inventario la lista de peliculas.
     */
    public ListaLigadaDoble getLista() {
        return inventario;
    }

    /**
     * Este metodo regresa la pelicula que se encuentra
     * en el indice que le recibe.
     *
     * @param indice int que es la posicion de la pelicula dentro
     * de la lista.
     */
    protected final Pelicula getPelicula(final int indice) {
        return (Pelicula) inventario.get(indice);
    }

    /**
     * Metodo auxiliar que saca el primer elemento de la lista.
     * @return Pelicula la pelicual al inicio de la lista.
     */
    public Pelicula getFirstPelicula() {
        return  (Pelicula) inventario.get(1);
    }

    /**
     * Metod que nos muestra las peliculas que hay en la lista.
     */
    public void muestraInventario() {
        Pelicula tmp = new Pelicula();

        for (int i = 1; i <= inventario.size(); i++) {
            tmp = (Pelicula) inventario.get(i);
            System.out.println("titulo: " + tmp.getTitulo());
            System.out.println("precio: " + tmp.getPrecio());
        }
    }

    /**
     * Este metodo realiza la busqueda de una pelicula
     * por el titulo de esta.
     *
     * @param titulopelicula String con el nombre de la pelicula
     * a buscar.
     * @return int con la posicion en la que se encuentra la
     * pelicula.
     */
    protected final int busquedaTitulo(final String titulopelicula) {

        int pos = -1;
        if (!inventario.isEmpty()) {
            for (int esta = 1; esta < inventario.size(); esta++) {
                Pelicula unaPelicula = (Pelicula) inventario.get(esta);
                String nombre = unaPelicula.getTitulo();
                if (titulopelicula.equalsIgnoreCase(nombre)) {
                    pos = esta;
                }
            }
        }
        return pos;
    }

    /**
     * Metodo que devuelve el inventario guardado.
     * @return inv, el inventario de la tienda.
     */
    public Inventario dameInventario() {

        Inventario inv = null;

        try {
            FileInputStream fileIn = new FileInputStream("inventario.ser");
            ObjectInputStream in = new ObjectInputStream(fileIn);
            inv = (Inventario) in.readObject();

            in.close();
            fileIn.close();
        } catch (IOException i) {
            i.printStackTrace();
            return null;
        } catch (ClassNotFoundException c) {
            c.printStackTrace();
            return null;
        }
        return inv;
    }

}
