package icc.proyecto01;

import java.io.Serializable;

/**
 * Clase que simula el inventario que se tiene en la tienda
 * guardando cada pelicula en una lista.
 */
public class Inventario implements Serializable {

    /**
     * La lista <code>inventario</code> es donde vamos
     * guardando todas las peliculas que agregamos.
     */
    private ListaLigadaDoble inventario;

    /**
     * El <code>contador</code> lleva la cuenta de
     * cuantas peliculas hay en la lista y nos ayuda
     * a saber cual es la ultima posicion de la lista.
     */
    private int contador = 1;

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
     * @param peli objeto tipo pelicula que se agregara al
     * inventario.
     */
    protected final  void agregaPelicula(final Pelicula peli) {
        inventario.add(contador, peli);
        contador++;
    }

    /**
     * Metodo que devuelve la lista en donde estan las peliculas.
     * @return inventario una lista ligada doble con las peliculas.
     */
    public final ListaLigadaDoble getLista() {
        return inventario;
    }

    /**
     * Este metodo regresa la pelicula que se encuentra
     * en el indice que le recibe.
     *
     * @param indice int que es la posicion de la pelicula dentro
     * de la lista.
     */
    public final Pelicula getPelicula(final int indice) {
        return (Pelicula) inventario.get(indice);
    }

    /**
     * Metodo auxiliar que saca el primer elemento de la lista.
     * @return Pelicula la pelicual al inicio de la lista.
     */
    public final  Pelicula getFirstPelicula() {
        return  (Pelicula) inventario.get(1);
    }

    /**
     * Metodo que nos muestra las peliculas que hay en la lista.
     */
    protected final void muestraInventario() {
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
            for (int esta = 1; esta <= inventario.size(); esta++) {
                Pelicula unaPelicula = (Pelicula) inventario.get(esta);
                String nombre = unaPelicula.getTitulo();
                if (titulopelicula.equalsIgnoreCase(nombre)) {
                    pos = esta;
                }
            }
        }
        return pos;
    }

}
