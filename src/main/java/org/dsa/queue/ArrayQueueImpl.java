package org.dsa.queue;

public class ArrayQueueImpl<X> implements BasicQueue<X> {
    private X[] data;
    private int front;
    private int end;

    public ArrayQueueImpl() {
        this(1000);
    }

    public ArrayQueueImpl(int i) {
        data = (X[]) new Object[i];
        this.front = -1;
        this.end = -1;
    }

    public void enQueue(X newItem) {
        if ((end + 1) % data.length == front) {
            throw new IllegalStateException("The queue is full");
        } else if (size() == 0) {
            front++;
            end++;
            data[end] = newItem;
        } else {
            data[++end] = newItem;
        }
    }

    public X deQueue() {
        X item = null;
        if (size() == 0) {
            throw new IllegalStateException("The queue is empty, can't de-queue");
        } else if (front == end) {
            item = data[front];
            data[front] = null;
            front = -1;
            end = -1;
        } else {
            item = data[front];
            data[front] = null;
            front++;
        }
        return item;
    }

    public boolean contains(X item) {
        boolean found = false;

        if (size() == 0) {
            return found;
        }

        for (int i = 0; i < size(); i++) {
            if (data[i].equals(item)) {
                found = true;
                break;
            }
        }
        return found;
    }

    public X access(int position) {
        if (size() == 0 || position > size()) {
            throw new IllegalArgumentException("No item in the queue or position is greater than queue size");
        }
        for (int i = front; i < end; i++) {
            if (data[i] == data[position]){
                return data[position];
            }
        }
        throw new IllegalArgumentException("Could not find item in the queue at position: " + position);
    }

    public int size() {
        //return 0 if queue is empty
        if (front == -1 && end == -1) {
            return 0;
        } else {
            return end - front + 1; // else return difference between start and end. Add 1 to include boundary
        }
    }
}