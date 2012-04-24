package icc.proyecto01;

import java.io.Serializable;
/**
 * Clase que modela un Cliente, que contien nombre y telefono.
 */
public class Cliente implements Serializable {
    private String nombre; // Nombre del cliente
    private int telefono; // Telefono del cliente
    private boolean esperando = false; // variable para saber si esta en espera o no.

    /**
     * Constructor de la clase.
     * @param name el nombre del cliente.
     * @param tel el telefono del cliente.
     */
    public Cliente(final String name, final int tel) {
        nombre = name;
        telefono = tel;
    }

    /**
     * Metodo que pone el nombre del cliente.
     * @param name el nombre del cliente.
     */
    public final void setNombre(final String name) {
        nombre = name;
    }

    /**
     * Metodo que regresa el nombre del cliente.
     * @return nombre el nombre del cliente.
     */
    public final String getNombre() {
        return nombre;
    }

    /**
     * Metodo que pone el telefono del cliente.
     * @param tel el telefono del cliente.
     */
    public final void setTelefono(final int tel) {
        telefono = tel;
    }

    /**
     * Metodo que regresa el telefono del cliente.
     * @return telefono, el telefono del cliente.
     */
    public final int getTelefono() {
        return telefono;
    }

    /**
     * Metodo que pone el estado del cliente, ya sea si esta en espera o no.
     * @param state el estado del cliente del cliente.
     */
    public final void setEstado(final boolean state) {
        esperando = state;
    }

    /**
     * Metodo que devuelve el estado de un cliente.
     * @return esperando, si esta en espera o no.
     */
    public final boolean getEstado() {
        return esperando;
    }
}
