package icc.proyecto01;


/**
 * La clase <code>Nodo</code> forma un elemento
 * que se guardara en nuestra lista ligada.
 *
 * @version 1.0
 */
public class Nodo {

    private Object elemento;
    private Nodo siguiente;


    /**
     * Construye un nuevo elemento tipo
     * <code>Nodo</code>.
     *
     * @param e an <code>Object</code> Recibe un
     * objeto de cualquier tipo para almacenarlo.
     */
    public Nodo(final Object e) {
        elemento = e;
        siguiente = null;
    }

    public Nodo(final Object e, final Nodo sig) {
        elemento = e;
        siguiente = sig;
    }

    public void cambiaElemento(final Object nvo) {
        elemento = nvo;
    }

    public Object daElemento() {
        return elemento;
    }

    public void cambiaSiguiente(final Nodo sig) {
        siguiente = sig;
    }

    public Nodo daSiguiente() {
        return siguiente;
    }

}
