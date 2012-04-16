package icc.proyecto01;

import java.io.BufferedReader;
import java.io.IOException;

//import goldman.collection.positional.DoublyLinkedList;

/**
 * Clase <code>MenuProg</code> nos muestra un menu
 * para operar en el programa.
 *
 * @version 1.0
 */
public class MenuProg {

    /**
     * Enteros usados para la seleccion de menu.
     */
    private static final int SALIR = 0,
        AGREGPELICULA = 1,
        INFORMACION = 2,
        VENTA = 3,
        PRECIO = 4,
        MENU = 6;

    /**
     * Declaracion de las listas que usaremos.
     * listaclientes contendra a todos los clientes.
     * listapeliculas contendra a todas las peliculas.
     */
    //    private DoublyLinkedList<Usuario> listaclientes = new DoublyLinkedList<Usuario>();
    //private DoublyLinkedList<Autor> listapeliculas = new DoublyLinkedList<Autor>();

     /**
     * El metodo <code>muestraMenu</code> nos despliega un menú de opciones
     * que podemos usar en el programa.
     *
     * @param entrada a <code>BufferedReader</code> Recibe la entrada de caracteres
     * @return an <code>int</code> Mantiene la ejecucion del menu siempre que sea diferente de -1.
     * @exception IOException if an error occurs
     */
    public final int muestraMenu(final BufferedReader entrada, final Catalogo elCatalogo)
        throws IOException {

        String nombreautor = "";  // Variable de uso general para recibir el nombre de autor.
        String titulolibro = "";  // Variable de uso general para recibir el titulo del libro.
        String nombrepelicula = "";  // Variable de uso general para recibir el nombre del usuario.
        String menú = "------Bienvenido------\n"
            + "S)\tFinalizar\n"
            + "A)\tAgregar una nuevo pelicula\n"
            + "C)\tDespliega informacion sobre una pelicula\n"
            + "V)\tVender una pelicula\n"
            + "P)\tModificar el precio de una pelicula\n"
            + "----------------------";
        System.out.println(menú);
        String sopción = "";
        System.out.print("Elige un numero para realizar "
                           + "la operación -> ");
        try {
            sopción = entrada.readLine();  // Se recibe la entrada del teclado y se almacena en sopción.
        } catch (IOException e) {
            System.err.println("Opción incorrecta, vuelve a intentar.");
        }
        int opción = "SACVP".indexOf(sopción);  // Se procesa sopción y se obtiene la opción elegida.
        switch (opción) {
        case SALIR:  // Salida del programa.
            System.out.println("Gracias por usar el sistema.\n"
                               + "Vuelva pronto.\n");
            return -1;
        case AGREGPELICULA:  // Introduce una nueva pelicula al sistema.
            System.out.println("Para dar de alta una nueva pelicula "
                               + "favor de ingresar nombre: \n");
            nombrepelicula = entrada.readLine();  // Se declaro al principio para uso general.
            Pelicula nuevapelicula = new Pelicula(nombrepelicula);
            int elTituloExiste = elCatalogo.busquedaUsuarios(nombreusuario, listausuarios);
            if (elUsuarioEsta > -1) {  // El -1 solo se recibe si no se encuentra en las listas.
                System.out.println("El titulo ya existe. \n");
            } else {
                listausuarios.add(nuevousuario);
                System.out.println("Usuario dado de alta exitosamente. \n");
            }
            return AGREGAPELICULA;
        case INFORMACION:  //Introduce un nuevo libro y autor al sistema.
            System.out.println("Para dar de alta un nuevo Libro "
                               + "favor de ingresar los siguientes datos: \n");
            System.out.print("Nombre del autor: ");
            nombreautor = entrada.readLine();  // Se declaro al principio para uso general.
            System.out.print("Titulo del libro: ");
            titulolibro = entrada.readLine();  // Se declaro al principio para uso general.
            Autor nuevoautor = new Autor(nombreautor);
            int elAutorEsta = elCatalogo.busquedaAutor(nombreautor, listaautor);
            if (elAutorEsta > -1) {  // Es -1 solo se recibe si  no se encuentra en las listas.
                System.out.println("El autor ya existe.");
                Autor autorexist = listaautor.get(elAutorEsta); // Se obtiene un Autor.
                int elLibroEsta = elCatalogo.busquedaLibro(titulolibro, autorexist);  // Se realiza la busqueda entre los titulos del autor.
                if (elLibroEsta > -1) {
                    System.out.println("El libro ya existe. \n");
                } else {  // Si no existe el libro se agrega a la lista de libros del autor.
                autorexist.agregaLibro(titulolibro);
                System.out.println("El libro fue agregado. \n");
                }
            } else {
                nuevoautor.agregaLibro(titulolibro); // Se agrega el libro a la lista del nuevo autor.
                listaautor.add(nuevoautor);  // Se agrega el nuevo autor a la lista. Ya incluye nombre de autor y libro.
                System.out.println("El autor y libro fueron dados de alta exitosamente. \n");
            }
            return INFORMACION;
        case VENTA:  //Presta un libro a un usuario.
            System.out.println("Para sacar un libro dame "
                               + "los siguientes datos: \n");
            System.out.print("Nombre del usuario que sacara el libro: ");
            nombreusuario = entrada.readLine();
            System.out.print("Nombre del autor: ");
            nombreautor = entrada.readLine();
            System.out.print("Titulo del libro: ");
            titulolibro = entrada.readLine();
            elCatalogo.realizaPrestamo(nombreusuario, listausuarios,           // Llamada al metodo auxiliar
                                       nombreautor, listaautor, titulolibro);  // para prestamos.
            return VENTA;
        case PRECIO:  //Un usuario regresa algun libro que tiene prestado.
            System.out.println("Para regresar el libro, "
                               + "proporcione los siguientes datos: \n");
            System.out.print("Nombre del usuario que regresa el libro: ");
            nombreusuario = entrada.readLine();
            System.out.print("Titulo del libro: ");
            titulolibro = entrada.readLine();

            int unusuario = elCatalogo.busquedaUsuarios(nombreusuario, listausuarios);
            if (unusuario > -1) {
                Usuario persona = listausuarios.get(unusuario);
                int regresa = elCatalogo.busquedaRegreso(titulolibro, persona);
                if (regresa > -1) {
                    Libro librosolicitado = persona.muestraLibro(regresa);
                    librosolicitado.cambiaEstado(); // Se actualiza el estado del libro.
                    persona.regresaLibro(regresa);  // Se elimina la referencia al libro de la lista de libros prestados del usuario.
                    System.out.println("El libro se ha devuelto y esta disponible de nuevo. Gracias =) \n");
                } else {
                    System.out.println("El libro no lo tiene este usuario. =( \n");
                }
            } else {
                System.out.println("El usuario no existe. =( \n");
            }
            return PRECIO;
        default:  //Opción no valida.
            System.out.println("Opción no valida, vuelve a elegir.");
            return MENU;
        }
    }
}
