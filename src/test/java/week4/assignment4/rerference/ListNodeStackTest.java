package week4.assignment4.rerference;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestTemplate;
import week4.assignment4.reference.ListNodeStack;

public class ListNodeStackTest {

    @Test
    void stack_init_test() {
        ListNodeStack st = new ListNodeStack();
        assertThat(st.getSize()).isEqualTo(0);
    }

    @Test
    void stack_push_test() {
        ListNodeStack st = new ListNodeStack();
        st.push(1);
        st.push(2);
        assertThat(st.getSize()).isEqualTo(2);
    }

    @Test
    void stack_pop_test() {
        ListNodeStack st = new ListNodeStack();
        st.push(1);
        st.push(2);
        int val = st.pop();
        assertThat(val).isEqualTo(2);
        assertThat(st.getSize()).isEqualTo(1);
    }

    @Test
    void stack_pop_all_test() {
        ListNodeStack st = new ListNodeStack();
        st.push(1);
        st.push(2);
        st.push(3);
        st.push(4);
        st.push(5);

        assertThat(st.getSize()).isEqualTo(5);

        ArrayList<Integer> temp = new ArrayList<>();

        while (st.getSize() != 0) {
            temp.add(st.pop());
        }

        assertThat(temp.get(0)).isEqualTo(5);
        assertThat(temp.get(1)).isEqualTo(4);
        assertThat(temp.get(2)).isEqualTo(3);
        assertThat(temp.get(3)).isEqualTo(2);
        assertThat(temp.get(4)).isEqualTo(1);

        assertThat(st.getSize()).isEqualTo(0);

    }

}
