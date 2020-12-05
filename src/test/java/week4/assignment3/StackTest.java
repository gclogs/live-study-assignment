package week4.assignment3;

import static org.junit.jupiter.api.Assertions.*;
import static org.assertj.core.api.Assertions.*;

import java.util.EmptyStackException;
import org.junit.jupiter.api.Test;

class StackTest {

  @Test
  void push() {

    //given
    Stack stack = new Stack(5);

    //when
    stack.push(1);
    stack.push(2);
    stack.push(3);
    stack.push(4);

    //then
    assertThat(stack.size()).isEqualTo(4);
  }

  @Test
  void 스택_꽉참_예외(){

    //given
    Stack stack = new Stack(3);

    //when
    IllegalStateException e = assertThrows(IllegalStateException.class, () -> {
      for (int i = 0; i <= stack.size(); i++) {
        stack.push(i+1);
      }
    });

    //then
    assertThat(e.getMessage()).isEqualTo("스택이 꽉찬 상태입니다.");
  }


  @Test
  void pop() {
    //given
    Stack stack = new Stack(5);

    //when
    stack.push(1);
    stack.push(2);
    stack.push(3);
    int data = stack.pop();
    int data2 = stack.pop();
    int data4 = stack.pop();


    //then
    //assertThat(data).isEqualTo(3);
    assertThat(stack.size()).isEqualTo(0);
  }

  @Test
  void 스택_공백_예외(){

    //given
    Stack stack = new Stack(3);

    //when
    IllegalStateException e = assertThrows(IllegalStateException.class, () -> {
        stack.pop();
    });

    //then
    assertThat(e.getMessage()).isEqualTo("스택이 빈 상태입니다.");
  }
}