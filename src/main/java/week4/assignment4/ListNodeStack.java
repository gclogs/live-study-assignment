package week4.assignment4;


/**
 * 과제 4. 앞서 만든 ListNode를 사용해서 Stack을 구현하세요. ListNode head를 가지고 있는 ListNodeStack 클래스를 구현하세요. void
 * push(int data)를 구현하세요. int pop()을 구현하세요.
 */
public class ListNodeStack {

  ListNode head;

  public ListNodeStack() {

  }

  //Stack 객체 생성시 크기 선언
  public ListNodeStack(int size) {
    head = new ListNode();
    ListNode tmp = head;
    for (int i = 0; i < size; i++) {
      tmp.setNext(new ListNode());
      tmp = tmp.getNext();
    }
  }

  //스택 삽입
  void push(int data) {
    if (isFull()) { //스택이 꽉찬 상태일 경우
      throw new IllegalStateException("스택이 꽉찬 상태입니다.");
    }
    ListNode tmp = head;
    while (tmp.getNext() != null) {
      tmp = tmp.getNext();
      if (tmp.getData() == 0) {
        tmp.setData(data);
        break;
      }
    }
  }

  int pop() {
    if (isEmpty()) { //스택이 완전 빈 상태인경우
      throw new IllegalStateException("스택이 빈 상태입니다.");
    }
    ListNode tmp = head;
    int temp = 0;
    while (tmp.getNext() != null) {
      tmp = tmp.getNext();
      if (tmp.getData() == 0) {
        break;
      }
    }
    /*int temp = 0;
    ListNode tmp = head;
    ListNode prev;
    while (true) {
      prev = tmp;
      tmp = tmp.getNext();
      System.out.println(prev);
      System.out.println(tmp);
      if (prev.getData() == 0) {
        temp = prev.getData();
        prev.setData(0);
        break;
      }
    } */
    return temp;
  }

  boolean isEmpty() {
    if (head.getNext().getData() == 0) {
      return true;
    }
    return false;
  }

  boolean isFull() {
    boolean flag = false;
    ListNode tmp = head;
    while (true) {
      tmp = tmp.getNext();
      if (tmp.getNext() == null) {
        if (tmp.getData() != 0) {
          flag = true;
        }
        break;
      }

    }
    return flag;
  }

  int size() { //스택 사이즈 반환
    int count = 0;
    ListNode tmp = head;
    while (tmp.getNext() != null) {
      tmp = tmp.getNext();
      if (tmp.getData() == 0) {
        break;
      }
      count++;
    }
    return count;
  }

  public StringBuilder getStringBuilder() {
    StringBuilder sb = new StringBuilder();
    int count = 0;
    ListNode tmp = head;
    while (tmp.getNext() != null) {
      tmp = tmp.getNext();
      sb.append(
          "자신 주소 : " + tmp.toString() + " / count " + "번째 노드의 주소 : " + tmp.getNext() + " / 데이터 : "
              + tmp.getData() + "\n");
      count++;
    }
    return sb;
  }
}
