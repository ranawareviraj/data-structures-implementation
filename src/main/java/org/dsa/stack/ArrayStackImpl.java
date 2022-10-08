package org.dsa.stack;

public class ArrayStackImpl<X> implements BasicStack<X> {
    private X[] data;
    private int stackPointer;

    public ArrayStackImpl() {
        data = (X[]) new Object[1000];
        stackPointer = 0;
    }

    public void push(X newItem) {
        data[stackPointer++] = newItem;
    }

    public X pop() {
        if (stackPointer == 0) {
            throw new IllegalStateException("No more items on the stack");
        }
        return data[--stackPointer];
    }

    public boolean contains(X item) {
        boolean found = false;
        for (int i = 0; i < stackPointer; i++) {
            if (data[i].equals(item)) {
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
        return stackPointer;
    }
}