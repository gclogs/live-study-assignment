package week4.assignment5;

import java.util.NoSuchElementException;

public class ListQueue {
    private static class QueueNode {
        private Integer data;
        private QueueNode next;

        public QueueNode(Integer data) {
            this.data = data;
        }
    }

    private QueueNode front;
    private QueueNode rear;

    public void add(Integer item) {
        QueueNode t = new QueueNode(item);

        if (rear != null) rear.next = t;
        rear = t;
        if (front == null) front = rear;
    }

    public Integer remove() {
        if (front == null) throw new NoSuchElementException();
        Integer data = front.data;
        front = front.next;

        if (front == null) rear = null;
        return data;
    }

    public Integer peek() {
        if (front == null) throw new NoSuchElementException();
        return front.data;
    }

    public boolean isEmpty() {
        return front == null;
    }
}
