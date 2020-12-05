package week4.assignment2;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.assertj.core.api.Assertions.*;

class LinkedListTest {

  private static LinkedList linkedList = new LinkedList();

  @Test
  void add() {

    //given
    ListNode head = new ListNode();

    //when
    linkedList.add(head, new ListNode(1), 0);
    linkedList.add(head, new ListNode(2), 1);
    linkedList.add(head, new ListNode(3), 2);

    //then( 추가한 노드의 총 사이즈가 맞는지)
    assertThat(linkedList.size(head)).isEqualTo(3);

    //when
    linkedList.add(head, new ListNode(4), 3);
    linkedList.add(head, new ListNode(5), 2); //★
    ListNode node = linkedList.get(head, 2);

    //then (★ : 추가한 노드의 데이터가 순서에 맞게 잘들어갔는지
    assertThat(node.getData()).isEqualTo(5);

    /*StringBuilder sb2 = linkedList.getStringBuilder(head);
    System.out.println(sb2.toString());
    assertThat(linkedList.size(head)).isEqualTo(3);*/

  }

  @Test
  void remove() {

    //given
    ListNode head = new ListNode();

    //when
    linkedList.add(head, new ListNode(1), 0);
    linkedList.add(head, new ListNode(2), 1);
    linkedList.add(head, new ListNode(3), 2);
    linkedList.add(head, new ListNode(4), 3);
    linkedList.add(head, new ListNode(5), 4);
    linkedList.remove(head, 2);

    //then(노드 제거후 노드의 총 개수가 맞는지)
    assertThat(linkedList.size(head)).isEqualTo(4);

/*    StringBuilder sb2 = linkedList.getStringBuilder(head);
    System.out.println(sb2.toString());
    assertThat(linkedList.size(head)).isEqualTo(3);*/

  }

  @Test
  void contains() {
    //given
    ListNode head = new ListNode();
    ListNode listNode = new ListNode(1);
    ListNode listNode2 = new ListNode(2);
    ListNode listNode3 = new ListNode(3);

    //when
    linkedList.add(head, listNode, 0);
    linkedList.add(head, listNode2, 1);
    linkedList.add(head, listNode3, 2);
    boolean flag = linkedList.contains(head, listNode2);

    //then
    assertThat(flag).isEqualTo(true);
  }

}