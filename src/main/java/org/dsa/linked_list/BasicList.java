package org.dsa.linked_list;

public interface BasicList<X> {

    public int size();

    public void add(X item);

    public void addAt(X item, int position);

    public X remove();

    public X removeAt(int position);

    public X get(int position);

    public int find(X item);

}