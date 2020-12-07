package week4.assignment4;

public class ListNode {

  private ListNode next; //다음 요소의 주소를 저장
  private int data; //데이터를 저장

  ListNode() {

  }

  public ListNode getNext() {
    return next;
  }

  public void setNext(ListNode next) {
    this.next = next;
  }

  public int getData() {
    return data;
  }

  public void setData(int data) {
    this.data = data;
  }

}
