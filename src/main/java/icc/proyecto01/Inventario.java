import java.io.*;

/**
 *Clase que simula el inventario que se tiene en la tienda
 *guardando cada pelicula en una lista.
 */

public class Inventario implements java.io.Serializable {

    ListaLigadaDoble inventario; //lista en donde vamos guardando las peliculas.
    int contador = 1; // nos sirve para ir agregando elementos al final de la lista.

    /**
     *Constructor de la clase que inicializa la lista ligada.
     */
    public Inventario() {
        inventario = new ListaLigadaDoble();
    }

    /**
     *Medodo que agrega peliculas a la lista e incrementa el contador en uno
     *para ir agregando al final de la lista y simular una cola.
     */
    public void agregaPelicula(Pelicula p){
        inventario.add(contador,p);
        contador ++;
    }

    /**
     *Metodo que devuelve la lista en donde estan las peliculas.
     *@return inventario la lista de peliculas.
     */
    public ListaLigadaDoble getLista() {
        return inventario;
    }

    /**
     *Metodo auxiliar que saca el primer elemento de la lista.
     *@return Pelicula la pelicual al inicio de la lista.
     */
    public Pelicula getFirstPelicula() {
        return  (Pelicula) inventario.get(1);
    }

    /**
     *Metod que nos muestra las peliculas que hay en la lista.
     */
    public void muestraInventario() {
        Pelicula tmp = new Pelicula();

        for (int i = 1; i <= inventario.size(); i++) {
            tmp = (Pelicula) inventario.get(i);
            System.out.println("titulo: " + tmp.getTitulo() );
            System.out.println("precio: " + tmp.getPrecio() );
        }
    }
}