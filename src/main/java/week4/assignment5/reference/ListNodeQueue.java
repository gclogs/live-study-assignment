package week4.assignment5.reference;


import week4.assignment2.reference.ListNode;

public class ListNodeQueue {

    private int size = 0;
    private ListNode head = null; //삭제될 위치
    private ListNode tail = null; //삽입될 위치

    public ListNodeQueue(){

    }

    public void add(int data){
        if(head == null){
            head = new ListNode(data);
            tail = head;
        }else{
            tail = tail.add(tail, new ListNode(data), 1);
        }
        size++;
    }

    public Integer peek(){
        if(head == null) return null;
        return head.getValue();
    }

    public Integer poll(){
        if(head == null) return null;
        ListNode prevHead = head.remove(head, 0);
        head = prevHead.getNext();
        size--;
        return prevHead.getValue();
    }

    public boolean empty(){
        return this.size == 0;
    }

    public int getSize(){
        return size;
    }



}
