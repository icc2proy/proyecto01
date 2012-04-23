package icc.proyecto01;

import java.io.Serializable;

public class NodoDoble implements Serializable {

    private Object elemento;

    private NodoDoble anterior, siguiente;

    public NodoDoble(final Object obj) {
        elemento = obj;
        anterior = null;
        siguiente = null;
    }

    public NodoDoble(final NodoDoble ant, final Object obj,
                     final NodoDoble sig) {
        elemento = obj;
        anterior = ant;
        siguiente = sig;
    }

    public final Object daElemento() {
        return elemento;
    }

    public final NodoDoble daAnterior() {
        return anterior;
    }

    public final NodoDoble daSiguiente() {
        return siguiente;
    }

    public final void cambiaElemento(final Object obj) {
        elemento = obj;
    }

    public final void cambiaAnterior(final NodoDoble ant) {
        anterior = ant;
    }

    public final  void cambiaSiguiente(final NodoDoble sig) {
        siguiente = sig;
    }
}
