package org.dsa.queue;

import java.util.ArrayList;

public class ArrayListQueueImpl<X> implements BasicQueue<X> {
    private ArrayList<X> data;
    private int front;
    private int end;

    public ArrayListQueueImpl() {
        this(1000);
    }

    public ArrayListQueueImpl(int initialCapacity) {
        data = new ArrayList<>(initialCapacity);
        this.front = -1;
        this.end = -1;
    }

    public void enQueue(X newItem) {
        if (size() == 0) {
            front++;
            end++;
            data.add(newItem);
        } /*else if ((end + 1) % data.size() == front) {
            throw new IllegalStateException("The queue is full");
        }*/ else {
            data.add(newItem);
            end++;
        }
    }

    public X deQueue() {
        X item = null;
        if (size() == 0) {
            throw new IllegalStateException("The queue is empty, can't de-queue");
        } else if (front == end) {
            item = data.get(front);
            data.set(front, null);
            front = -1;
            end = -1;
        } else {
            item = data.get(front);
            data.set(front, null);
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
            if (data.get(i).equals(item)) {
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

        int trueIndex = 0;
        for (int i = front; i < end; i++) {
            if (trueIndex == position) {
                return data.get(i);
            }
            trueIndex++;
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