package icc.proyecto01;


/**
 * La clase <code>Cliente</code> describe a una
 * persona que va adquirir un video en la tienda.
 *
 * @version 1.0
 */
public class Cliente {

    private String nombre;
    private int telefono;
    private boolean esperando = false;

    public Cliente() {
    }

    public void setNombre(final String name) {
        nombre = name;
    }

    public String getNombre() {
        return nombre;
    }

    public void setTelefono(final int tel) {
        telefono = tel;
    }

    public int getTelefono() {
        return telefono;
    }

    public void setEstado(final boolean state) {
        esperando = state;
    }

    public boolean getEstado() {
        return esperando;
    }
}
