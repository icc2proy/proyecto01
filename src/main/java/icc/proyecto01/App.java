package icc.proyecto01;

import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.io.IOException;

/**
 * Aplicacion para el manejo de la venta
 * e inventario de una tienda de peliculas.
 */
public class App {

    /**
     * El metodo <code>main</code> es el punto de
     * arranque del programa. Manda llamar al menu
     * del programa y lo despliega hasta el termino
     * de la ejecucion del programa.
     *
     * @param args a <code>String</code> Valores que
     * recibe desde la linea de ejecucion
     */
    public static void main(final String[] args) {

        int opcion = 0;
        BufferedReader entrada = new BufferedReader(new InputStreamReader(System.in));

        //        Catalogo elCatalogo = new Catalogo();
        MenuProg elMenu = new MenuProg();

        // Elementos de prueba.
        Pelicula peli = new Pelicula();
        Pelicula p = new Pelicula();

        peli.guardaInventario(p, "Armagedon", 300, 25);
        peli.muestraInventario(p);

        peli.guardaInventario(p, "Toy Story", 150, 18);
        peli.muestraInventario(p);
        // Terminan elementos de prueba.

        // Comentar esto para bloquear el menu.
        while (opcion != -1) {
            try {
                opcion = elMenu.muestraMenu(entrada, elCatalogo);
            } catch (IOException e) {
                System.out.println("Opción mal elegida, volver a intentarlo");
                opcion = 0;
            }
        }
        // Termina muestreo del menu

    }
}
