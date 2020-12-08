package week4.assignment5;

import java.util.Arrays;

/**
 * (optional) 과제 5. Queue를 구현하세요.
 * 배열을 사용해서 한번
 * ListNode를 사용해서 한번.
 */
public class QueueArrayMain {

  int index = -1;
  int[] arr;

  public QueueArrayMain(int size){
    arr = new int[size];
  }

  //Queue에 객체를 저장
  void offer(int o) {
    if(isFull()){
      throw new IllegalStateException("큐가 꽉찬 상태입니다.");
    }
    arr[++index] = o;
  }

  // Queue에서 객체를 꺼내서 반환. 비어있으면 null을 반환
  int poll(){
    if(isEmpty()){ //스택이 완전 빈 상태인경우
      //throw new EmptyStackException();
      throw new IllegalStateException("큐가 빈 상태입니다.");
    }else{
      int temp = arr[0]; //제거할 정수 반환
      System.arraycopy(arr, 1, arr, 0, index);
      index--;
      return temp;
    }
  }

  boolean isEmpty() {
    if(index == -1){ //첫번째 인덱스가 0(기본값)이면
      return true;
    }
    return false;
  }

  boolean isFull(){
    if(index >= arr.length-1){ //top이 스택크기의 -1값이면 스택이 꽉찬 상태(인덱스 0부터 시작)
      return true;
    }
    return false;
  }

  int size(){
    return index+1;
  }


}
