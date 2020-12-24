package week4.assignment4.reference;

import java.util.EmptyStackException;
import week4.assignment2.reference.ListNode;

//과제2 - reference에서 만든 ListNode 사용
public class ListNodeStack {
    private int size = 0;
    private ListNode top = null;

    public ListNodeStack(){

    }


    public void push(int data){
        if(top == null){
            top = new ListNode(data);
        }else{
            // top 노드를 기준으로 position 1에 node를 add
            top = top.add(top, new ListNode(data), 1);
        }
        size++;
    }

    public int pop() {
        if(size == 0 || top == null){
            throw new EmptyStackException();
        }else{
            // top노드를 기준으로 position 0에 node를 remove
            ListNode prevTop = top.remove(top, 0);
            top = prevTop.getPrev();
            size--;
            return prevTop.getValue();
        }
    }

    public int getSize(){
        return size;
    }

}
