package org.dsa.stack;

public interface BasicStack<X> {
    public void push(X newItem);

    public X pop();

    public boolean contains(X item);

    public X access(X item);

    public int size();
}