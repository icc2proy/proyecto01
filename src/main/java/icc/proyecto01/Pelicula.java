package icc.proyecto01;

import java.io.Serializable;

/**
 * Clase que modela una pelicula, que contiene titulo,
 * precio y numero de ejemplares.
 */
public class Pelicula implements Serializable {

    /**
     * El <code>titulo</code> de la pelicula.
     */
    private String titulo;

    /**
     * El <code>precio</code> de la pelicula.
     */
    private int precio;

    /**
     * El numero de <code>numejemplares</code>
     * que hay en un principio.
     */
    private int numejemplares;

    /**
     * El numero de <code>numrestantes</code>
     * ejemplares que quedan en stock.
     */
    private int numrestantes;

    /**
     * Contador de elementos <code>listacount</code>
     * en la lista.
     */
    private int listacount = 1;

    /**
     * Es una lista<code>listaEspera</code> con los
     * nombres de las personas que estan esperando una
     * pelicula. Funciona como una cola realmente.
     */
    private ListaLigadaDoble listaEspera = new ListaLigadaDoble();


    /**
     * Constructor de la clase.
     * @param mtitulo el titulo de la pelicula.
     * @param mprecio el precio de la pelicula.
     * @param mejemplares el numero de ejemplares inicial.
     */
    public Pelicula(final String mtitulo, final int mprecio,
                    final int mejemplares) {
        titulo = mtitulo;
        precio = mprecio;
        numejemplares = mejemplares;
        numrestantes = mejemplares;
    }

    /**
     * Constructor de la clase <code>Pelicula</code>
     * sin parametros.
     */
    public Pelicula() {
    }

    /**
     * El metodo <code>enEspera</code> devuelve el numero
     * de personas que se encuentran en la lista de espera.
     *
     * @return an <code>int</code> el numero de personas que
     * estan esperando una pelicula.
     */
    public int enEspera() {
        return listaEspera.size();
    }

    /**
     * Metodo que devuelve el titulo de la pelicula.
     * @return titulo el titulo  de la pelicula.
     */
    public String getTitulo() {
        return titulo;
    }

    /**
     * Metodo que ponen el titulo de la pelicula.
     * @param nombre el titulo de la pelicula.
     */
    public void setTitulo(final String nombre) {
        titulo = nombre;
    }

    /**
     * Metodo que devuelve el precio de la pelicula.
     * @return precio el preio de la pelicula.
     */
    public int getPrecio() {
        return precio;
    }

    /**
     * Metodo que ponen el precio de la pelicula.
     * @param prec el precio de la pelicula.
     */
    public void setPrecio(final int prec) {
        precio = prec;
    }

    /**
     * Metodo que devuelve el numero de ejemplares totales.
     * @return numejemplares el numero de ejemplares.
     */
    public int getNumEjemplares() {
        return numejemplares;
    }

    /**
     * Metodo que ponen el numero de ejemplares totales.
     * @param num el numero de ejemplares.
     */
    public void setNumEjemplares(final int num) {
        numejemplares = num;
    }

    /**
     * Metodo que vende un ejemplar.
     */
    public void vendeEjemplar() {
        numrestantes--;
    }

    /**
     * Metodo que devuelve el numero de ejemplares restantes o en existencia.
     * @return numrestantes el numero de ejemplares restantes.
     */
    public int getNumRestantes() {
        return numrestantes;
    }

    /**
     * Metodo que guarda a los clientes en espera de la pelicula.
     * @param cli un <code>Cliente</code> que va comprar una pelicula
     * es una persona con nombre y telefono.
     */
    public void guardaEnLista(final Cliente cli) {
        listaEspera.add(listacount, cli);
        listacount++;
    }

    /**
     * Metodo que devuelve el cliente que esta al inicio de la lista.
     * @return tmp, el objecto Cliente de la lista.
     */
    public Object sacaElementoLista() {

        if (listaEspera.size() > 0) {
            Object tmp = listaEspera.get(1);
            return tmp;
        } else {
            return null;
        }
    }

    /**
     * Metodo que elimina el primer elementon de la lista de espera.
     */
    public void eliminaCliente() {

        if (!listaEspera.isEmpty()) {
            listaEspera.remove(1);
            listacount--;
        }
    }

    /**
     * Metodo que saca un cliente en espera.
     */
    public void vaciaEspera() {

        while (!listaEspera.isEmpty() && numrestantes > 0) {
            eliminaCliente();
            vendeEjemplar();
        }
    }

    /**
     * Metodo que reestablece el numero de ejemplares.
     */
    public void resetEjemplares() {
        numrestantes = numejemplares;
    }

}
