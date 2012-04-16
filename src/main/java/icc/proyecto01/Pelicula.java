package icc.proyecto01;

import java.io.*;

/**
 * La clase <code>Pelicula</code> describe un objeto
 * pelicula con sus atributos.
 *
 * @version 1.0
 */
public class Pelicula implements java.io.Serializable {

    private String titulo;
    private int precio;
    private int num_ejemplares;
    private int num_restantes;
    private int count = 0;
    //    ListaLigada lista_de_espera = new ListaLigada();
    public Pelicula() {
    }

    public void setTitulo(final String ntitulo) {
        titulo = ntitulo;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setPrecio(final int nprecio) {
        precio = nprecio;
    }

    public int getPrecio() {
        return precio;
    }

    public void setNumEjemplares(final int nejemplares) {
        num_ejemplares = nejemplares;
    }

    public int getNumEjemplares() {
        return num_ejemplares;
    }

    public void vendeEjemplar() {
        num_restantes--;
    }

    public int getNumRestantes() {
        return num_restantes;
    }

    public void guardaInventario(final Pelicula obj, final String title,
                                 final int price, final int total) {

        obj.setTitulo(title);
        obj.setPrecio(price);
        obj.setNumEjemplares(total);
        count++;

        try {
            FileOutputStream fileOut = new FileOutputStream("inventario.ser");
            ObjectOutputStream out = new ObjectOutputStream(fileOut);
            out.writeObject(obj);
            out.close();
            fileOut.close();
        } catch (IOException i) {
                i.printStackTrace();
            }
    }

    public void muestraInventario(final Pelicula pe) {

        Pelicula p = null;

        try {
            FileInputStream fileIn = new FileInputStream("inventario.ser");
            ObjectInputStream in = new ObjectInputStream(fileIn);
            p = (Pelicula) in.readObject();

            in.close();
            fileIn.close();

        } catch (IOException i) {
            i.printStackTrace();
                return;
        } catch (ClassNotFoundException c) {
            c.printStackTrace();
                return;
        }

        System.out.println("Titulo: " + p.getTitulo());
        System.out.println("Precio: " + p.getPrecio());
        System.out.println("Ejemplares: " + p.getNumEjemplares());
        System.out.println();
    }
}
