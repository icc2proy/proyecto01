package icc.proyecto01;

/**
 * Clase que modela una pelicula, que contiene titulo,
 * precio y numero de ejemplares.
 */
public class Pelicula {

    private String titulo; //el titulo de la pelicula.
    private int precio; // el precio de la pelicula.
    private int num_ejemplares; // el numero de ejemplares que hay en un principio.
    private int num_restantes; //el numero de ejemplares que hay despues de algunas ventas.
    private int count = 0; // contador
    private int lista_counter = 1; //contador de la lista

    //Inventario inv = new Inventario();
    private ListaLigadaDoble lista_de_espera = new ListaLigadaDoble(); //lista de espera

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
        num_ejemplares = mejemplares;
    }

    /**
     * Constructor vacio de la clase.
     */
    public Pelicula() {
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
     * @param s el titulo de la pelicula.
     */
    public void setTitulo(final String s) {
        titulo = s;
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
     * @param p el precio de la pelicula.
     */
    public void setPrecio(final int p) {
        precio = p;
    }

    /**
     * Metodo que devuelve el numero de ejemplares totales.
     * @return num_ejemplares el numero de ejemplares.
     */
    public int getNumEjemplares() {
        return num_ejemplares;
    }

    /**
     * Metodo que ponen el numero de ejemplares totales.
     * @param num el numero de ejemplares.
     */
    public void setNumEjemplares(final int num) {
        num_ejemplares = num;
    }

    /**
     * Metodo que vende un ejemplar.
     */
    public void vendeEjemplar() {
        num_restantes--;
    }

    /**
     * Metodo que devuelve el numero de ejemplares restantes o en existencia.
     * @return num_restantes el numero de ejemplares restantes.
     */
    public int getNumRestantes() {
        return num_restantes;
    }

    /**
     * Metodo que guarda a los clientes en espera de la pelicula.
     */
    public void guardaEnLista(final Cliente c) {
        lista_de_espera.add(lista_counter, c);
        lista_counter++;
    }

    /**
     * Metodo que devuelve el cliente que esta al inicio de la lista.
     * @return tmp, el objecto Cliente de la lista.
     */
    public Object sacaElementoLista() {
        if (lista_de_espera.size() > 0) {
            Object tmp = lista_de_espera.get(1);
            return tmp;
        } else {
            return null;
        }
    }

}
