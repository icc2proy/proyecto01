import java.io.*;

/**
 *Clase que modela una pelicula, que contiene titulo,
 *precio y numero de ejemplares.
 */
public class Pelicula implements java.io.Serializable{

    String titulo; //el titulo de la pelicula.
    int precio; // el precio de la pelicula.
    int num_ejemplares; // el numero de ejemplares que hay en un principio.
    int num_restantes; //el numero de ejemplares que hay despues de algunas ventas.
    int count = 0; // contador 
    int lista_counter = 1; //contador de la lista

    Inventario inv = new Inventario();
    ListaLigadaDoble lista_de_espera = new ListaLigadaDoble(); //lista de espera

    /**
     *Constructor de la clase
     *@param mtitulo el titulo de la pelicula.
     *@param mprecio el precio de la pelicula.
     *@param mejemplares el numero de ejemplares inicial.
     */
    public Pelicula(String mtitulo,int mprecio,int mejemplares) {
        titulo = mtitulo;
        precio = mprecio;
        num_ejemplares = mejemplares;
    }

    /**
     *Constructor vacio de la clase.
     */
    public Pelicula() {
    }

    /**
     *Metodo que devuelve el titulo de la pelicula.
     *@return titulo, el titulo  de la pelicula.
     */
    public String getTitulo() {
        return titulo;
    }

    /**
     *Metodo que ponen el titulo de la pelicula.
     *@param s, el titulo de la pelicula.
     */
    public void setTitulo(String s) {
        titulo = s;
    }

    /**
     *Metodo que devuelve el precio de la pelicula.
     *@return precio, el preio de la pelicula.
     */
    public int getPrecio() {
        return precio;
    }

    /**
     *Metodo que ponen el precio de la pelicula.
     *@param p , el precio de la pelicula.
     */
    public void setPrecio(int p) {
        precio = p;
    }

    /**
     *Metodo que devuelve el numero de ejemplares totales.
     *@return num_ejemplares, el numero de ejemplares.
     */
    public int getNumEjemplares() {
        return num_ejemplares;
    }

    /**
     *Metodo que ponen el numero de ejemplares totales.
     *@param num, el numero de ejemplares.
     */
    public void setNumEjemplares(int num) {
        num_ejemplares = num;
    }

    /**
     *Metodo que vende un ejemplar.
     */
    public void vendeEjemplar() {
        num_restantes --;
    }

    /**
     *Metodo que devuelve el numero de ejemplares restantes o en existencia.
     *@return num_restantes, el numero de ejemplares restantes.
     */
    public int getNumRestantes() {
        return num_restantes;
    }

    /**
     *Metodo que guarda a los clientes en espera de la pelicula.
     */
    public void guardaEnLista(Cliente c) {
        lista_de_espera.add(lista_counter,c);
        lista_counter ++;
    }

    /**
     *Metodo que devuelve el cliente que esta al inicio de la lista.
     *@return tmp, el objecto Cliente de la lista.
     */
    public Object sacaElementoLista() {
        if (lista_de_espera.size() > 0) {
        Object tmp = lista_de_espera.get(1);
        return tmp;
        } else {
            return null;
        }
    }

    /**
     *Metodo que guarda el inventario en el archivo inventario.ser
     *Esto se hace al cerrar la tienda.
     *@param obje, el inventario que queremos guardar.
     */
    public void guarda(Inventario obje){

        count ++;

        try{
            FileOutputStream fileOut = new FileOutputStream("inventario.ser");
            ObjectOutputStream out = new ObjectOutputStream(fileOut);
            out.writeObject(obje);
            out.close();
            fileOut.close();
        }catch(IOException i)
            {i.printStackTrace();}
    }

    /**
     *Metodo que devuelve el inventario guardado
     *@return inv, el inventario de la tienda.
     */
    public Inventario dameInventario() {

        try{
            FileInputStream fileIn = new FileInputStream("inventario.ser");
            ObjectInputStream in = new ObjectInputStream(fileIn);
            inv =(Inventario) in.readObject();

            in.close();
            fileIn.close();
        }catch(IOException i)
            {i.printStackTrace();
                return null;
            }catch(ClassNotFoundException c)
            {c.printStackTrace();
                return null;
            }
        return inv;
    }
    
}