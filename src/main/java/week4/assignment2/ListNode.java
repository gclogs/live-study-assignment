package week4.assignment2;

public class ListNode {

  private ListNode next; //다음 요소의 주소를 저장
  private int data; //데이터를 저장

  ListNode() {

  }

  public ListNode(int data) {
    this.data = data;
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
