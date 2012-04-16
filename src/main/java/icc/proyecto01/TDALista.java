package icc.proyecto01;

interface TDALista {

    void create();

    boolean isEmpty();

    int size();

    void add(int i, Object obj) throws IndexOutOfBoundsException;

    void remove(int i) throws IndexOutOfBoundsException;

    Object get(int i) throws IndexOutOfBoundsException;

    void removeAll();
}
