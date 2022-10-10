package org.dsa.linked_list;

import org.w3c.dom.Node;

import javax.naming.NoPermissionException;
import java.util.WeakHashMap;

public class LinkedListImpl<X> implements BasicList<X> {

    private Node head;
    private Node tail;
    private int nodeCounter;

    public LinkedListImpl() {
        head = null;
        tail = null;
        nodeCounter = 0;
    }

    @Override
    public int size() {
        return nodeCounter;
    }

    public void add(X item) {
        if (head == null) {
            head = new Node(item);
            tail = head;
        } else {
            Node newLastNode = new Node(item);
            tail.setNextNode(newLastNode);
            tail = newLastNode;
        }
        nodeCounter++;
    }

    public void addAt(X item, int position) {
        if (size() < position) {
            throw new IllegalStateException("List is smaller than position passed");
        }

        Node currentNode = head;
        for (int i = 1; i < position && currentNode != null; i++) {
            currentNode = currentNode.getNextNode();
        }

        Node newNode = new Node(item);
        Node nextNode = currentNode.getNextNode();
        currentNode.setNextNode(newNode);
        newNode.setNextNode(nextNode);
        nodeCounter++;
    }

    public X remove() {
        if (head == null) {
            throw new IllegalStateException("Linked List is empty");
        }
        X itemRemoved = head.getNodeItem();
        head = head.getNextNode();
        nodeCounter--;
        return itemRemoved;
    }

    public X removeAt(int position) {
        if (size() < position) {
            throw new IllegalStateException("List is smaller than position passed");
        } else if (head == null) {
            throw new IllegalStateException("List is empty");
        }

        Node previousNode = head;
        Node currentNode = head;
        for (int i = 1; i < position && currentNode != null; i++) {
            previousNode = currentNode;
            currentNode = currentNode.getNextNode();
        }

        X item = currentNode.getNodeItem();
        Node nextNode = currentNode.getNextNode();
        previousNode.setNextNode(nextNode);
        nodeCounter--;
        return item;
    }

    public X get(int position) {
        if (size() < position) {
            throw new IllegalStateException("List is smaller than position passed");
        } else if (head == null) {
            throw new IllegalStateException("List is empty");
        }

        Node currentNode = head;
        for (int i = 1; i <= position && currentNode != null; i++) {
            if (i == position) {
                return currentNode.getNodeItem();
            }
            currentNode = currentNode.getNextNode();
        }
        return null;
    }

    public int find(X item) {
        if (head == null) {
            throw new IllegalStateException("List is empty");
        }

        Node currentNode = head;
        for (int i = 1; i < size() && currentNode != null; i++) {
            if (currentNode.getNodeItem().equals(item)) {
                return i;
            }
            currentNode = currentNode.getNextNode();
        }
        //Return -1 if item not found
        return -1;
    }

    public String toString() {
        StringBuffer contents = new StringBuffer();
        Node currentNode = head;

        while (currentNode != null) {
            contents.append(currentNode.getNodeItem());
            currentNode = currentNode.getNextNode();
            if (currentNode != null) {
                contents.append(", ");
            }
        }
        return contents.toString();
    }

    private class Node {
        private Node nextNode;
        private X nodeItem;

        public Node(X nodeItem) {
            this.nextNode = null;
            this.nodeItem = nodeItem;
        }

        public void setNextNode(Node nextNode) {
            this.nextNode = nextNode;
        }

        public Node getNextNode() {
            return nextNode;
        }

        public X getNodeItem() {
            return nodeItem;
        }
    }
}