package icc.proyecto01;

interface TDALista {

    void create();

    boolean isEmpty();

    int size();

    void add(final int i, final Object obj) throws IndexOutOfBoundsException;

    void remove(final int i) throws IndexOutOfBoundsException;

    Object get(final int i) throws IndexOutOfBoundsException;

    void removeAll();
}
