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
      tmp.setNext(new ListNode()); //헤드노드부터 새로만든 노드의 주소 삽입
      tmp = tmp.getNext(); // 새로만든 노드로 이동
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
      if (tmp.getData() == 0) { //노드의 데이터가 0인경우
        tmp.setData(data); //해당노드에 데이터 삽입
        break;
      }
    }
  }

  int pop() {
    if (isEmpty()) { //스택이 완전 빈 상태인경우
      throw new IllegalStateException("스택이 빈 상태입니다.");
    }
    int temp = 0;
    ListNode tmp = head;
    ListNode prev;
    tmp = tmp.getNext(); //head노드 제외하고 첫번째 노드부터 시작
    for (int i = 0; i < size(); i++) {
      prev = tmp; //해당 노드의 이전노드 주소 보관
      tmp = tmp.getNext();
      if (tmp.getData() == 0) {  //마지막 노드의 이전노트부터 체크, 해당노드가 0일경우
        temp = prev.getData(); //데이터가 0인 해당 노드의 이전노드의 값을 반환
        prev.setData(0);  //0으로 초기화
        break;
      }

      if (tmp.getNext() == null) { //마지막 노드 체크
        temp = tmp.getData(); //마지막노드 데이터 반환
        tmp.setData(0); //마지막노드 데이터 0으로 초기화
        break;
      }
    }
    return temp;
  }

  boolean isEmpty() {
    if (head.getNext().getData() == 0) { //첫번째 노드가 0이면 빈상태
      return true;
    }
    return false;
  }

  boolean isFull() {
    boolean flag = false;
    ListNode tmp = head;
    while (true) {
      tmp = tmp.getNext();
      if (tmp.getNext() == null) { //마지막 노드가 0이 아니면 꽉찬 상태
        if (tmp.getData() != 0) {
          flag = true;
        }
        break;
      }

    }
    return flag;
  }

  int size() { //스택에 현재 push되어있는 데이터기준 사이즈 반환
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
