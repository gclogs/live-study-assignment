package week4.assignment5.reference;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestTemplate;
import week4.assignment4.reference.ListNodeStack;


public class ListNodeQueueTest {

    @Test
    void queue_init_test(){
        ListNodeQueue q = new ListNodeQueue();
        assertThat(q.getSize()).isEqualTo(0);
    }

    @Test
    void queue_add_test() {
        ListNodeQueue q = new ListNodeQueue();
        q.add(1);
        q.add(2);
        assertThat(q.getSize()).isEqualTo(2);
    }

    @Test
    void queue_poll_test() {
        ListNodeQueue q = new ListNodeQueue();
        q.add(1);
        q.add(2);
        int val = q.poll();
        assertThat(val).isEqualTo(1);
        assertThat(q.getSize()).isEqualTo(1);
    }

    @Test
    void queue_peek_test() {
        ListNodeQueue q = new ListNodeQueue();
        q.add(1);
        q.add(2);
        int val = q.peek();
        assertThat(val).isEqualTo(1);
        assertThat(q.getSize()).isEqualTo(2);
    }


    @Test
    void queue_pop_all_test() {
        ListNodeQueue q = new ListNodeQueue();
        q.add(1);
        q.add(2);
        q.add(3);
        q.add(4);
        q.add(5);

        assertThat(q.getSize()).isEqualTo(5);
        ArrayList<Integer> temp = new ArrayList<>();

        while(!q.empty()){
            temp.add(q.poll());
        }

        assertThat(temp.get(0)).isEqualTo(1);
        assertThat(temp.get(1)).isEqualTo(2);
        assertThat(temp.get(2)).isEqualTo(3);
        assertThat(temp.get(3)).isEqualTo(4);
        assertThat(temp.get(4)).isEqualTo(5);
        assertThat(q.getSize()).isEqualTo(0);
    }

    @Test
    void queue_pop_error() {
        ListNodeQueue q = new ListNodeQueue();
        assertNull(q.poll());
    }

}
