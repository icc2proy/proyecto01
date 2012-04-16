package icc.proyecto01;


/**
 * La clase <code>ListaLigada</code> forma una estructura
 * de datos en donde almacenaremos informacion de una
 * manera ordenada.
 *
 * @version 1.0
 */
public class ListaLigada implements java.io.Serializable, TDALista {

    private Nodo head; //cabeza de la lista

    private int numElems;


    /**
     * Llama al constructor de una instancia de
     * la clase <code>ListaLigada</code>.
     */
    public ListaLigada() {
        create();
    }

    /**
     * Construye la lista ligada <code>create</code>.
     *
     */
    public void create() {
        numElems = 0;
        head = null;
    }

    /**
     * El metodo <code>isEmpty</code> nos dice si la
     * lista esta vacia o no.
     *
     * @return a <code>boolean</code> True esta vacia,
     * false tiene al menos un elemento.
     */
    public boolean isEmpty() {
        return (numElems == 0);
    }

    /**
     * El metodo <code>size</code> devuelve el tamaño
     * de la lista.
     *
     * @return an <code>int</code> El numero de elementos
     * en la lista.
     */
    public int size() {
        return numElems;
    }

    /**
     * El metodo <code>removeAll</code> elimina todos los
     * elementos de la lista.
     */
    public void removeAll() {
        numElems = 0;
        head = null;
    }


    /**
     * El metodo <code>find</code> entrega el nodo en la
     * i-esima posicion.
     *
     * @param i an <code>int</code> Indice de la posicion.
     * @return a <code>Nodo</code> Un objeto tipo nodo.
     */
    private Nodo find(final int i) {
        Nodo actual = head;
        int skip = 1;
        while (skip < i) {
            actual = actual.daSiguiente();
            skip++;
        }
        return actual;
    }

    public Object get(final int i) throws IndexOutOfBoundsException {
        if (numElems == 0) {
            throw new IndexOutOfBoundsException("Indice invalido. Lista vacia");
        }
        if (i >= 1 && i <= numElems) {
            Nodo actual = find(i);
            return actual.daElemento();
        } else {
            throw new IndexOutOfBoundsException("Indice invalido");
        }
    }

    /**
     * El metodo <code>add</code> agrega un elemento a la
     * lista en la i-esima posicion.
     *
     * @param i an <code>int</code> Indice de la posicion.
     * @param obj an <code>Object</code>  El objeto que vamos agregar.
     * @exception IndexOutOfBoundsException Se intenta agregar un elemento
     * en una posicion no valida.
     */
    public void add(final int i, final Object obj) throws IndexOutOfBoundsException {
        if (i >= 1 && i <= numElems + 1) {
            if (i == 1) {
                Nodo nuevo = new Nodo(obj, head);
                head = nuevo;
            } else {
                Nodo previo = find(i - 1);
                Nodo nuevo = new Nodo(obj, previo.daSiguiente());
                previo.cambiaSiguiente(nuevo);
            }
            numElems++;
        } else {
            throw new IndexOutOfBoundsException("Indice invalido");
        }
    }

    /**
     * El metodo <code>remove</code> elimina el elemento
     * en la i-esima posicion.
     *
     * @param i an <code>int</code> Indice de la posicion.
     * @exception IndexOutOfBoundsException Se intenta eliminar
     * un objeto en una posicion no valida.
     */
    public void remove(final int i) throws IndexOutOfBoundsException {
        if (numElems == 0) {
            throw new IndexOutOfBoundsException("Indice invalido. Lista vacia");
        }
        if (i >= 1 && i <= numElems + 1) {
            if (i == 1) {
                head = head.daSiguiente();
            } else {
                Nodo previo = find(i - 1);
                Nodo actual = previo.daSiguiente();
                previo.cambiaSiguiente(actual.daSiguiente());
            }
            numElems--;
        } else {
            throw new IndexOutOfBoundsException("Indice invalido");
        }
    }
}
