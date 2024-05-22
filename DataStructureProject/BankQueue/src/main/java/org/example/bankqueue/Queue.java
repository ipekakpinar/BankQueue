package org.example.bankqueue;

public class Queue {
    // Queue CAPACITY
    static final Integer CAPACITY = 100;

    /***
     * Linked List kullanılarak
     * Circle Queue oluşturulur.
     */
    static class Node {
        Integer data;
        Node node;
    }

    Node front, rear;
    Integer size = 0, capacity;

    Queue() {
        this.capacity = CAPACITY;
    }

    // Queue sonundan ekleme yapan func.
    public void enqueue(Integer seq) {
        Node temp = new Node();
        temp.data = seq;

        if (this.front == null)
                this.front = temp;
        else
            this.rear.node = temp;

        this.rear = temp;
        this.rear.node = this.front;
    }

    // Queue başından çıkarma yapan func.
    public Integer dequeue() {
        if (isEmpty())
            return Integer.MIN_VALUE;

        if (this.front == this.rear) {
            this.front = null;
            this.rear = null;
        } else {
            this.front = this.front.node;
            this.rear.node = this.front;
        }

        assert this.front != null;
        return this.front.data;
    }

    // Queue'nin başındaki elemanı veren func.
    public Integer peek() {
        if (isEmpty())
            return Integer.MIN_VALUE;

        return this.front.data;
    }

    // Queue size veren func.
    public void size() {
        if (isEmpty())
            return;

        Node temp = this.front;

        size++;

        while (temp.node != this.front) {
            size++;
            temp = temp.node;
        }
    }

    // Queue boş mu kontrol eden func.
    public boolean isEmpty() {
        if (this.front == null)
                return true;
        return false;
    }
}
