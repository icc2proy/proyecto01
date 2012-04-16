package icc.proyecto01;

/**
 * Aplicacion para el manejo de la venta
 * e inventario de una tienda de peliculas.
 */
public class App {

    /**
     * El metodo <code>main</code> es el punto de
     * arranque del programa.
     *
     * @param args a <code>String</code> Valores que
     * recibe desde la linea de ejecucion
     */
    public static void main(final String[] args) {

        Pelicula peli = new Pelicula();
        Pelicula p = new Pelicula();

        peli.guardaInventario(p, "Armagedon", 300, 25);
        peli.muestraInventario(p);

        peli.guardaInventario(p, "Toy Story", 150, 18);
        peli.muestraInventario(p);

        System.out.println("Hello World!");
    }
}
