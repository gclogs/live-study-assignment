package week4.assignment2.reference;

import static org.junit.jupiter.api.Assertions.*;
import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.Test;

class ListNodeTest {

    @Test
    void add_functional_test() {
        ListNode head = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode returned = head.add(head, node2, 0);
        assertThat(2).isEqualTo(returned.getValue());
        assertThat(1).isEqualTo(returned.getNext().getValue());
    }

    @Test
    void add_outof_index_error_throw_test() {
        ListNode head = new ListNode(1);
        ListNode node2 = new ListNode(2);
        assertNull(head.add(head, node2, 2));
    }

    @Test
    void add_negative_value_error_throw_test() {
        ListNode head = new ListNode(1);
        ListNode node2 = new ListNode(2);
        node2 = head.add(head, node2, -1);
        assertNull(node2);
    }

    @Test
    void add_multiple_nodes_test() {
        ListNode head = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4);
        ListNode node5 = new ListNode(5);

        head = head.add(head, node2, 0);
        head = head.add(head, node3, 0);
        head = head.add(head, node4, 0);
        head = head.add(head, node5, 0);

        assertEquals(5, head.getValue());
        assertEquals(4, head.getNext().getValue());
        assertEquals(3, head.getNext().getNext().getValue());
        assertEquals(2, head.getNext().getNext().getNext().getValue());
        assertEquals(1, head.getNext().getNext().getNext().getNext().getValue());
        assertNull(head.getNext().getNext().getNext().getNext().getNext());
    }

    @Test
    void add_multiple_nodes_with_different_position_test() {
        ListNode head = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4);
        ListNode node5 = new ListNode(5);

        head.add(head, node2, 1);
        head.add(head, node3, 2);
        head.add(head, node4, 3);
        head.add(head, node5, 4);

        assertEquals(1, head.getValue());
        assertEquals(2, head.getNext().getValue());
        assertEquals(3, head.getNext().getNext().getValue());
        assertEquals(4, head.getNext().getNext().getNext().getValue());
        assertEquals(5, head.getNext().getNext().getNext().getNext().getValue());
    }

    @Test
    void remove_last_element_functional_test() {
        ListNode head = new ListNode(1);
        ListNode node2 = new ListNode(2);
        head.add(head, node2, 1);
        ListNode result = head.remove(head, 2);
        assertNull(result);
    }

    @Test
    void remove_multiple_element_functional_test() {
        ListNode head = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4);
        head.add(head, node2, 1);
        head.add(head, node3, 2);
        head.add(head, node4, 3);
        ListNode prevHead = head.remove(head, 0);
        assertThat(1).isEqualTo(prevHead.getValue());
    }

    @Test
    void remove_multiple_element_different_position_functional_test() {
        ListNode head = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4);
        head.add(head, node2, 1);
        head.add(head, node3, 2);
        head.add(head, node4, 3); // [1] -> [2] -> [3] -> [4]

        ListNode prevHead = head.remove(head, 0); // [2] -> [3] -> [4] //head update
        assertThat(1).isEqualTo(prevHead.getValue());
        ListNode newHead = prevHead.getNext();
        assertThat(2).isEqualTo(newHead.getValue());

        ListNode removedVal = newHead.remove(newHead, 1); //[2] -> [4]
        assertThat(3).isEqualTo(removedVal.getValue());

        removedVal = newHead.remove(newHead, 1);
        assertThat(4).isEqualTo(removedVal.getValue()); //[2] -> null
        assertThat(2).isEqualTo(newHead.getValue());
        assertNull(newHead.getNext());
    }

    @Test
    void remove_negative_index_test() {
        ListNode head = new ListNode(1);
        assertNull(head.remove(head, -1));
    }

    @Test
    void remove_out_of_bound_index_test() {
        ListNode head = new ListNode(1);
        assertNull(head.remove(head, 2));
    }

    @Test
    void contains_true_functional_test() {
        ListNode head = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(2);
        // [1] -> [2] -> [3];
        head.add(head, node2, 1);
        head.add(head, node3, 2);
        assertTrue(head.contains(head, node3));
        head.remove(head, 1);
        assertTrue(head.contains(head, node3));
        assertFalse(head.contains(head, node2));
    }

    @Test
    void contains_false_functional_test() {
        ListNode head = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        assertFalse(head.contains(head, node2));
        assertFalse(head.contains(head, node3));

        head.add(head, node2, 1);
        head.add(head, node3, 2);
        head.remove(head, 1);
        assertFalse(head.contains(head, node2));
    }

}