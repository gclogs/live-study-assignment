package week4.assignment2;

/**
 * 과제 2. LinkedList를 구현하세요. LinkedList에 대해 공부하세요. 정수를 저장하는 ListNode 클래스를 구현하세요. ListNode
 * add(ListNode head, ListNode nodeToAdd, int position)를 구현하세요. ListNode remove(ListNode head, int
 * positionToRemove)를 구현하세요. boolean contains(ListNode head, ListNode nodeTocheck)를 구현하세요.
 */
public class LinkedList {

  public LinkedList() {
  }

  public StringBuilder getStringBuilder(ListNode head) {
    StringBuilder sb = new StringBuilder();
    int count = 0;
    while (head.getNext() != null) {
      head = head.getNext();
      sb.append("자신 주소 : " + head.toString() + "count " + "번째 노드의 주소 : " + head.getNext() + " 데이터 : " + head.getData() + "\n");
      count++;
    }
    return sb;
  }

  //노드 총 사이즈(head 제외)
  int size(ListNode head) {
    int count = 0;
    while (head.getNext() != null) {
      count++;
      head = head.getNext();
    }
    return count;
  }

  //position 유효성 체크
  boolean validation(ListNode head, int position) {
    if (position < 0) { //노드에 추가할 position이 마이너스 일때
      return false;
    } else if (size(head) < position) {  //노드에 추가할 position이 사이즈보다 클때
      return false;
    }
    return true;
  }

  //noteToAdd : 추가된 노드를 받음 외부에서 받음(데이터 포함)
  //노드 추가
  ListNode add(ListNode head, ListNode nodeToAdd, int position) {
    if (!validation(head, position)) {
      return null;
    }

    if (head.getNext() == null) { //head가 가리키는 주소값이 null이면
      head.setNext(nodeToAdd); //head에 첫번째 노드의 주소값을 넣어준다.
    } else { //노드가 1개이상이라도 있으면
      while (--position >= 0) { //추가할 노드의 해당 포지션으로 이동
        head = head.getNext();
      }
      nodeToAdd.setNext(head.getNext()); //추가한 노드의 주소값에는 이전노드값 주소 삽입
      head.setNext(nodeToAdd); //추가한 노드의 주소 삽입

    }
    return nodeToAdd;
  }

  //노드 제거
  ListNode remove(ListNode head, int positionToRemove) {
    if (!validation(head, positionToRemove)) {
      return null;
    }

    ListNode prev = null;

    while (positionToRemove-- >= 0) {
      prev = head; //삭제할 노드의 이전 노드
      head = head.getNext(); //삭제할 노드가 가리켰던 다음 노드 주소값
    }

    prev.setNext(head.getNext()); //삭제할 노드의 이전노드에 삭제할 노드가 가리켰던 주소값 삽입

    return prev;
  }

  //position에 존재하는 해당 노드 반환
  ListNode get(ListNode head, int position) {
    if (!validation(head, position)) {
      return null;
    }

    ListNode prev = null;

    while (position-- >= 0) {
      head = head.getNext();
    }
    return head;
  }

  //노드가 존재하는지 확인
  boolean contains(ListNode head, ListNode nodeTocheck) {
    while (head.getNext() != null) {
      head = head.getNext();
      if (nodeTocheck == head) {
        return true;
      }
    }
    return false;
  }

}
