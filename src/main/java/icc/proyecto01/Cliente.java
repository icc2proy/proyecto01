package icc.proyecto01;

/**
 *Clase que modela un Cliente, que contien nombre y telefono.
 */
public class Cliente{

    String nombre; // el nombre del cliente
    int telefono; // el telefono del cliente
    boolean esperando = false; // variable para saber si esta en espera o no.

    /**
     *constructor de la clase .
     *@param name el nombre del cliente.
     *@param tel el telefono del cliente.
     */
    public Cliente(String name, int tel){
        nombre = name;
        telefono = tel;
    }

    /**
     *Metodo que pone el nombre del cliente.
     *@param name, el nombre del cliente.
     */
    public void setNombre(String name){
        nombre = name;
    }

    /**
     *Metodo que regresa el nombre del cliente.
     *@return nombre, el nombre del cliente.
     */
    public String getNombre(){
        return nombre;
    }

    /**
     *Metodo que pone el telefono del cliente.
     *@param tel, el telefono del cliente.
     */
    public void setTelefono(int tel){
        telefono = tel;
    }

    /**
     *Metodo que regresa el telefono del cliente.
     *@return telefono, el telefono del cliente.
     */
    public int getTelefono(){
        return telefono;
    }

    /**
     *Metodo que pone el estado del cliente, ya sea si esta en espera o no.
     *@param state, el estado del cliente del cliente.
     */
    public void setEstado(boolean state){
        esperando = state;
    }

    /**
     *Metodo que devuelve el estado de un cliente.
     *@return esperando, si esta en espera o no.
     */
    public boolean getEstado(){
        return esperando;
    }
}