import java.io.*;

/**
 * Nodos Auxiliares
 * Para simplificar la programación mantendremos dos nodos
 * auxiliares en ambos extremos de la lista, la cabeza y la cola,
 * los cuales no van a almacenar nada. La cabeza cuenta con
 * referencia nula al nodo anterior mientras que lo mismo sucede
 * para la cola con respecto al nodo siguiente. El tamaño o longitud
 * no contemplará a estos dos nodos auxiliares.
 * Una lista vacia tendría a estos dos nodos apuntándose mutuamente,
 * por supuesto la cabeza tendría como siguiente nodo a la cola y la
 * cola tendría como nodo anterior a la cabeza.
 */

public class ListaLigadaDoble implements java.io.Serializable, TDALista{

    private int numElems;

    private NodoDoble head, tail;

    public ListaLigadaDoble(){
        create();
    }
    
    public void create(){
        numElems = 0;
        head = new NodoDoble(null);	// creamos la cabeza
        tail = new NodoDoble(null);	// creamos la cola
        tail.cambiaAnterior(head); // ponemos head <- tail
        head.cambiaSiguiente(tail); // ponemos head -> tail
    }
    
    public boolean isEmpty(){
        return (numElems==0);
    }

    public int size(){
        return numElems;
    }
    
     public void removeAll(){
        numElems = 0;
        tail.cambiaAnterior(head); // ponemos head <- tail
        head.cambiaSiguiente(tail); // ponemos head -> tail
    }
     
     // Devuelve el primer nodo de esta lista     
     private NodoDoble getFirst(){
         return head.daSiguiente();
     }

     // Devuelve el ultimo nodo de la lista     
     private NodoDoble getLast(){
         return tail.daAnterior();
     }

     // devuelve el nodo en la posicion i
     // 1 <= i <= size() y la lista no es vacia
     private NodoDoble find(int i){
         NodoDoble actual;
         int n=size();
         int limite;
         if(n%2==0)
             limite=n/2;
         else
             limite=(n-1)/2;
         if(i<=limite){ // i es de la primera mitad
             actual=getFirst();
             int skip=1;
             while(skip<i){
                 actual=actual.daSiguiente();
                 skip++;
             }
         }
         else{ // i es de la segunda mitad
             actual=getLast();
             int skip=n;
             while(skip>i){
                 actual=actual.daAnterior();
                 skip--;
             }
         }
         return actual;
     }

     public Object get(int i) throws IndexOutOfBoundsException{
         if(numElems==0)
             throw new IndexOutOfBoundsException("Indice invalido. Lista vacia");
         if(i>=1 && i<=numElems){
             NodoDoble actual=find(i);
             return actual.daElemento();
         }
         else{
             throw new IndexOutOfBoundsException("Indice invalido");
         }
     }
     
     public void add(int i,Object obj) throws IndexOutOfBoundsException{
         if(i>=1 && i<=numElems+1){
             NodoDoble nuevo=new NodoDoble(obj);
             if(i==1){
                NodoDoble primero = getFirst(); // podria ser la cola
                nuevo.cambiaAnterior(head); 
                nuevo.cambiaSiguiente(primero); // ya tenemos las referencias del nuevo
                primero.cambiaAnterior(nuevo); // actualizamos la referencia anterior del primer nodo real
                head.cambiaSiguiente(nuevo); // actualizamos la referencia siguiente
            }
            else if(i==numElems+1){
                NodoDoble ultimo = tail.daAnterior(); // podria ser la cabeza
                nuevo.cambiaAnterior(ultimo);
                nuevo.cambiaSiguiente(tail); // ya tenemos las referencias del nuevo
                tail.cambiaAnterior(nuevo); // actualizamos la referencia anterior de tail
                ultimo.cambiaSiguiente(nuevo); // actualizamos la referencia siguiente de u
            }
            else{ // 1 < i < numElems + 1
		NodoDoble previo=find(i-1);
                NodoDoble actual = previo.daSiguiente(); // ya tenemos el nodo de la posicion i
                nuevo.cambiaAnterior(previo);
                nuevo.cambiaSiguiente(actual); // ya tenemos las referencias del nuevo
                actual.cambiaAnterior(nuevo); // actualizamos la referencia anterior del i-esimo
                previo.cambiaSiguiente(nuevo); // actualizamos la referencia siguiente del (i-1)-esimo
            }
            numElems++;
        }
        else
            throw new IndexOutOfBoundsException("Indice invalido");        
  }

  public void remove(int i) throws IndexOutOfBoundsException{
      if(numElems==0)
          throw new IndexOutOfBoundsException("Indice invalido. Lista vacia");
      if(i>=1 && i<=numElems){
          NodoDoble actual;
          if(i==1)
              actual=getFirst();
          else if(i==numElems)
              actual=getLast();
          else // 1 < i < numElems
              actual=find(i);
          // independientemente de quien es actual, hacemos lo siguiente
          NodoDoble previo = actual.daAnterior();
          NodoDoble posterior = actual.daSiguiente();
          // desligar
          posterior.cambiaAnterior(previo);
          previo.cambiaSiguiente(posterior);
          actual.cambiaAnterior(null); // borramos las referencias internas de actual
          actual.cambiaSiguiente(null);
          numElems--;
      }
      else
          throw new IndexOutOfBoundsException("Indice invalido");
  }
   
}
