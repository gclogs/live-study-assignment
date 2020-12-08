package week4.assignment5;

/**
 * (optional) 과제 5. Queue를 구현하세요. 배열을 사용해서 한번 ListNode를 사용해서 한번.
 */
public class QueueListNodeMain {

  ListNode head;

  public QueueListNodeMain() {

  }

  //Queue 생성시 크기 선언
  public QueueListNodeMain(int size) {
    head = new ListNode();
    ListNode tmp = head;
    for (int i = 0; i < size; i++) {
      tmp.setNext(new ListNode()); //헤드노드부터 새로만든 노드의 주소 삽입
      tmp = tmp.getNext(); // 새로만든 노드로 이동
    }
  }

  //큐 삽입
  void offer(int data) {
    if (isFull()) { //큐가 꽉찬 상태일 경우
      throw new IllegalStateException("큐가 꽉찬 상태입니다.");
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

  int poll() {
    if (isEmpty()) { //큐기 완전 빈 상태인경우
      throw new IllegalStateException("큐가 빈 상태입니다.");
    }
    int temp = 0;
    head = head.getNext();
    temp = head.getData();
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

  int size() { //큐에 현재 push 되어있는 데이터기준 사이즈 반환
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
