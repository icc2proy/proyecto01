package icc.proyecto01;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.FileOutputStream;
import java.io.Serializable;

/**
 * Clase <code>MenuProg</code> nos muestra un menu
 * para operar en el programa.
 *
 * @version 1.0
 */
public class MenuProg implements Serializable {

    /**
     * Enteros usados para la seleccion de menu.
     */
    private static final int SALIR = 0,
        AGREGAPELICULA = 1,
        INFORMACION = 2,
        VENTA = 3,
        PRECIO = 4,
        MENU = 6;

    /**
     * Declaracion de las listas que usaremos.
     * listaclientes contendra a todos los clientes.
     * listapeliculas contendra a todas las peliculas.
     */
    private ListaLigadaDoble listaclientes = new ListaLigadaDoble();

    private Inventario elInventario = new Inventario();

     /**
     * El metodo <code>muestraMenu</code> nos despliega un menú de opciones
     * que podemos usar en el programa.
     *
     * @param entrada a <code>BufferedReader</code> Recibe la entrada de caracteres
     * @return an <code>int</code> Mantiene la ejecucion del menu siempre que sea
     * diferente de -1.
     * @exception IOException if an error occurs
     */
    public final int muestraMenu(final BufferedReader entrada)
        throws IOException {

        String nombrecliente = "";  // Variable general para el nombre de un cliente.
        String nombrepelicula = "";  // Variable general para el nombre de una pelicula.
        String menu = "------Bienvenido------\n"
            + "S)\tFinalizar\n"
            + "A)\tAgregar una nuevo pelicula\n"
            + "C)\tDespliega informacion sobre una pelicula\n"
            + "V)\tVender una pelicula\n"
            + "P)\tModificar el precio de una pelicula\n"
            + "----------------------";
        System.out.println(menu);
        String sopcion = "";
        System.out.print("Elige una letra para realizar "
                           + "la operación -> ");
        try {
            sopcion = entrada.readLine();  // Se recibe la entrada del teclado y se almacena en sopción.
        } catch (IOException e) {
            System.err.println("Opción incorrecta, vuelve a intentar.");
        }
        int opcion = "SACVP".indexOf(sopcion);  // Se procesa sopción y se obtiene la opción elegida.
        switch (opcion) {
        case SALIR:  // Salida del programa.
            guarda(elInventario);
            System.out.println("Gracias por usar el sistema.\n"
                               + "Vuelva pronto.\n");
            return -1;
        case AGREGAPELICULA:  // Introduce una nueva pelicula al sistema.
            System.out.println("Para dar de alta una nueva pelicula "
                               + "favor de ingresar nombre: ");
            nombrepelicula = entrada.readLine();  // Se declaro al principio para uso general.

            int elTituloExiste = elInventario.busquedaTitulo(nombrepelicula);
            if (elTituloExiste > -1) {  // El -1 solo se recibe si no se encuentra en las listas.
                System.out.println("El titulo ya existe. \n");
            } else {
                // Solicitamos el precio de la pelicula.
                System.out.println("Favor de agregar el precio por ejemplar: ");
                int precio = Integer.parseInt(entrada.readLine());

                // Solicitamos el numero de ejemplares.
                System.out.println("Favor de agregar el numero de ejemplares en existencia: ");
                int ejemplares = Integer.parseInt(entrada.readLine());

                // Creamos la pelicula y la agregamos al inventario.
                Pelicula nuevapelicula = new Pelicula(nombrepelicula.toUpperCase(), precio, ejemplares);
                elInventario.agregaPelicula(nuevapelicula);
                System.out.println("el inventario: "); // BORRAME
                elInventario.muestraInventario(); //BORRAME
                System.out.println("Pelicula dada de alta exitosamente. \n");
            }
            return AGREGAPELICULA;
        case INFORMACION:  // Muestra informacion sobre alguna pelicula.
            System.out.println("Para ver la informacion de una pelicula "
                               + "favor de ingresar el titulo desado: ");
            nombrepelicula = entrada.readLine();  // Se declaro al principio para uso general.
            int laPeliculaExiste = elInventario.busquedaTitulo(nombrepelicula);
            if (laPeliculaExiste > -1) {  // Es -1 solo se recibe si no se encuentra en las listas.
                Pelicula consulta = elInventario.getPelicula(laPeliculaExiste);
                System.out.println("Titulo: " + consulta.getTitulo());
                System.out.println("Precio: " + consulta.getPrecio());
                System.out.println("Existencia: " + consulta.getNumRestantes());
            } else {
                System.out.println("No hay informacion disponible actualmente. "
                                   + "El titulo no se encuentra en el sistema. \n");
            }
            return INFORMACION;
        case VENTA:  // Se vende una pelicula.
            System.out.println("Para realizar la venta se requieren "
                               + "los siguientes datos: ");
            System.out.print("Nombre del cliente: ");
            nombrecliente = entrada.readLine();
            System.out.print("Nombre de la pelicula: ");
            nombrepelicula = entrada.readLine();

            int peliculaVenta = elInventario.busquedaTitulo(nombrepelicula);
            if (peliculaVenta > -1) {
                Pelicula lapelicula = elInventario.getPelicula(peliculaVenta);
                if (lapelicula.getNumRestantes() > 0) {
                    System.out.println("El ejemplar cuesta: " + lapelicula.getPrecio());
                    lapelicula.vendeEjemplar();
                } else {
                    System.out.println("Lo sentimos ya no hay ejemplares disponibles"
                                       + "lo agregaremos a una lista de espera."
                                       + "Favor de proporcionar un telefono para"
                                       + " avisarle que ya tenemos la pelicula.");
                    int telefono = Integer.parseInt(entrada.readLine());
                    Cliente unCliente = new Cliente(nombrecliente, telefono);
                    lapelicula.guardaEnLista(unCliente);
                    System.out.println("En cuanto resurtan nos comunicaremos con usted.");
                }
            } else {
                System.out.println("El titulo no se encuentra en el sistema. \n");
            }

            return VENTA;
        case PRECIO:  // Se actualiza el precio de una pelicula.
            System.out.println("Para cambiar el precio de una pelicula "
                               + "proporcione los siguientes datos: ");
            System.out.print("Nombre de la pelicula: ");
            nombrepelicula = entrada.readLine();
            System.out.print("Nuevo precio: ");
            int nuevoprecio = Integer.parseInt(entrada.readLine());

            int unapelicula = elInventario.busquedaTitulo(nombrepelicula);
            if (unapelicula > -1) {
                Pelicula lapelicula = elInventario.getPelicula(unapelicula);
                System.out.println("El precio actual es: " + lapelicula.getPrecio());
                System.out.println("Esta seguro que desea cambiar el precio de la pelicula: Y/N ");
                String resp = entrada.readLine();
                if (resp.contains("Y") || resp.contains("y")) {
                    lapelicula.setPrecio(nuevoprecio);
                    System.out.println("El precio ha sido actualizado con exito.");
                } else {
                    System.out.println("La operacion se ha cancelado.");
                }
            } else {
                System.out.println("La pelicula no existe. =( \n");
            }
            return PRECIO;
        default:  // Opción no valida.
            System.out.println("Opción no valida, vuelve a elegir.");
            return MENU;
        }
    }

    /**
     * Metodo que guarda el inventario en el archivo inventario.ser
     * Esto se hace al cerrar la tienda.
     * @param obje el inventario que queremos guardar.
     */
    protected final void guarda(final Inventario obje) {

        try {
            FileOutputStream fileOut = new FileOutputStream("inventario.ser");
            ObjectOutputStream out = new ObjectOutputStream(fileOut);
            out.writeObject(obje);
            out.close();
            fileOut.close();
        } catch (IOException i) {
            i.printStackTrace();
        }
    }

}
