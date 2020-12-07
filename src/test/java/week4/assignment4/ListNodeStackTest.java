package week4.assignment4;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import week4.assignment3.Stack;

class ListNodeStackTest {

  @Test
  void push() {

    //given
    ListNodeStack stack = new ListNodeStack(5);

    /*StringBuilder sb2 = stack.getStringBuilder();
    System.out.println(sb2.toString());
    assertThat(stack.size()).isEqualTo(3);*/

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
    ListNodeStack stack = new ListNodeStack(3);

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
    ListNodeStack stack = new ListNodeStack(3);

    //when
    stack.push(1);
    stack.push(2);
    stack.push(3);
    StringBuilder sb2 = stack.getStringBuilder();
    System.out.println(sb2.toString());
    int data = stack.pop();
    int data2 = stack.pop();
    int data4 = stack.pop();
    StringBuilder sb3 = stack.getStringBuilder();
    System.out.println(sb3.toString());

    //then
    //assertThat(data).isEqualTo(3);
    assertThat(stack.size()).isEqualTo(0);
  }

  @Test
  void 스택_공백_예외(){

    //given
    ListNodeStack stack = new ListNodeStack(3);

    //when
    IllegalStateException e = assertThrows(IllegalStateException.class, () -> {
      stack.pop();
    });

    //then
    assertThat(e.getMessage()).isEqualTo("스택이 빈 상태입니다.");
  }
}