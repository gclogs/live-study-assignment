package week4.assignment5;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class QueueListNodeMainTest {

  @Test
  void offer() {
    //given
    QueueListNodeMain qlnm = new QueueListNodeMain(3);

    //when
    qlnm.offer(1);
    qlnm.offer(2);
    qlnm.offer(3);

    //then
    assertThat(qlnm.size()).isEqualTo(3);
  }

  @Test
  void 큐_꽉참_예외(){

    //given
    QueueListNodeMain qlnm = new QueueListNodeMain(3);

    //when
    IllegalStateException e = assertThrows(IllegalStateException.class, () -> {
      for (int i = 0; i <= qlnm.size(); i++) {
        qlnm.offer(i+1);
      }
    });

    //then
    assertThat(e.getMessage()).isEqualTo("큐가 꽉찬 상태입니다.");

  }

  @Test
  void poll() {
    //given
    QueueListNodeMain qlnm = new QueueListNodeMain(3);

    //when
    qlnm.offer(1);
    qlnm.offer(2);
    qlnm.offer(3);

    int data = qlnm.poll();
    int data2 = qlnm.poll();
    int data3 = qlnm.poll();

    //then
    assertThat(data).isEqualTo(1);
    assertThat(data2).isEqualTo(2);
    assertThat(data3).isEqualTo(3);
  }

  @Test
  void 큐_공백_예외(){

    //given
    QueueListNodeMain qlnm = new QueueListNodeMain(3);

    //when
    IllegalStateException e = assertThrows(IllegalStateException.class, () -> {
      qlnm.poll();
    });

    //then
    assertThat(e.getMessage()).isEqualTo("큐가 빈 상태입니다.");
  }
}