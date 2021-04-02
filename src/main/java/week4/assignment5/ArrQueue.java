package week4.assignment5;

public class ArrQueue {

    private int front;
    private int rear;
    private int size;
    private Object[] arrQueue;


    public ArrQueue(int size){
        this.front = 0;
        this.rear = -1;
        this.size = size;
        this.arrQueue = new Object[this.size];
    }

    //원하는 데이터를 추가하는 메쏘드
    public void enQueue(Object item){
        if(isFull()) throw new ArrayIndexOutOfBoundsException();
        this.rear++;
        arrQueue[rear] = item;
    }

    //Queue의 front에 위치한 데이터 삭제
    public Object deQueue(){
        if(isEmpty()) throw new ArrayIndexOutOfBoundsException();
        Object backUpItem = peek();
        this.front++;
        return backUpItem;
    }

    //front에 위치한 데이터가 무엇인지 확인하는 메쏘드
    public Object peek(){
        return arrQueue[front];
    }

    //Queue 배열이 꽉 차있는지 확인
    public boolean isFull(){
        if(rear >= size-1) return true;
        else return false;
    }

    //Queue 배열이 비어있는지 확인
    public boolean isEmpty(){
        if(rear < front) return true;
        else return false;
    }

}
