package week4.assignment4;

import java.util.NoSuchElementException;

//링크드 리스트 기반 스택
//https://gmlwjd9405.github.io/2018/08/03/data-structure-stack.html
public class MyStack {
    private static class StackNode {
        private Integer data;
        private StackNode next;

        public StackNode(Integer data) {
            this.data = data;
        }
    }

    private StackNode top;

    public void push(Integer item) {
        StackNode t = new StackNode(item);
        t.next = top;
        top = t;
    }

    public Integer pop() {
        if (top == null) throw new NoSuchElementException();
        Integer item = top.data;
        top = top.next;

        return item;
    }

    public Integer peek() {
        if (top == null) throw new NoSuchElementException();
        return top.data;
    }

    public boolean isEmpty() {
        return top == null;
    }
}
