package week4.assignment5;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import week4.assignment3.Stack;


class QueueArrayMainTest {

  @Test
  void offer() {
    //given
    QueueArrayMain qam = new QueueArrayMain(3);

    //when
    qam.offer(1);
    qam.offer(2);
    qam.offer(3);

    //then
    assertThat(qam.size()).isEqualTo(3);

  }

  @Test
  void 큐_꽉참_예외(){

    //given
    QueueArrayMain qam = new QueueArrayMain(3);

    //when
    IllegalStateException e = assertThrows(IllegalStateException.class, () -> {
      for (int i = 0; i <= qam.size(); i++) {
        qam.offer(i+1);
      }
    });

    //then
    assertThat(e.getMessage()).isEqualTo("큐가 꽉찬 상태입니다.");

  }

  @Test
  void poll() {
    //given
    QueueArrayMain qam = new QueueArrayMain(3);

    //when
    qam.offer(1);
    qam.offer(2);
    qam.offer(3);
    int data = qam.poll();
    int data2 = qam.poll();
    int data3 = qam.poll();

    //then
    assertThat(data).isEqualTo(1);
    assertThat(data2).isEqualTo(2);
    assertThat(data3).isEqualTo(3);
  }

  @Test
  void 큐_공백_예외(){

    //given
    QueueArrayMain qam = new QueueArrayMain(3);

    //when
    IllegalStateException e = assertThrows(IllegalStateException.class, () -> {
      qam.poll();
    });

    //then
    assertThat(e.getMessage()).isEqualTo("큐가 빈 상태입니다.");
  }

}