import java.io.*;

public class NodoDoble implements java.io.Serializable{

    private Object elemento;

    private NodoDoble anterior, siguiente;

    public NodoDoble(Object obj){
        elemento=obj;
        anterior=siguiente=null;
    }

    public NodoDoble(NodoDoble ant, Object obj, NodoDoble sig){
        elemento=obj;
        anterior=ant;
        siguiente=sig;
    }

    public Object daElemento(){
        return elemento;
    }

    public NodoDoble daAnterior(){
        return anterior;
    }

    public NodoDoble daSiguiente(){
        return siguiente;
    }

    public void cambiaElemento(Object obj){
        elemento=obj;
    }

    public void cambiaAnterior(NodoDoble ant){
        anterior=ant;
    }

    public void cambiaSiguiente(NodoDoble sig){
        siguiente=sig;
    }


}
