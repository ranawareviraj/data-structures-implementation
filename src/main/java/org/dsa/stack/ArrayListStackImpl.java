package org.dsa.stack;

import java.util.ArrayList;

public class ArrayListStackImpl<X> implements BasicStack<X> {
    private ArrayList<X> data;
    private int stackPointer;

    public ArrayListStackImpl() {
        data = new ArrayList<X>();
        stackPointer = 0;
    }

    public void push(X newItem) {
        data.add(newItem);
        stackPointer++;
    }

    public X pop() {
        if (stackPointer == 0) {
            throw new IllegalStateException("No more items on the stack");
        }
        return data.remove(--stackPointer);
    }

    public boolean contains(X item) {
        boolean found = false;
        for (int i = 0; i < size(); i++) {
            if (data.get(i).equals(item)) {
                found = true;
                break;
            }
        }
        return found;
    }

    public X access(X item) {
        while (stackPointer > 0) {
            X tempItem = pop();
            if (tempItem.equals(item)) {
                return tempItem;
            }
        }
        throw new IllegalArgumentException("Could not find item on the stack: " + item);
    }

    public int size() {
        return data.size();
    }
}