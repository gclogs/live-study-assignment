package week4.assignment3;

import java.util.EmptyStackException;

/**
 * 과제 3. Stack을 구현하세요.
 * int 배열을 사용해서 정수를 저장하는 Stack을 구현하세요.
 * void push(int data)를 구현하세요.
 * int pop()을 구현하세요.
 */
public class Stack {
  int[] arr = null;
  int top = -1;

  //Stack 객체 생성시 크기 선언
  public Stack(int size) {
    arr = new int[size];
  }

  //스택 삽입
  void push(int data) {
    if(isFull()){ //스택이 꽉찬 상태일 경우
      throw new IllegalStateException("스택이 꽉찬 상태입니다.");
    }
    arr[++top] = data;
  }

  int pop() {
    if(isEmpty()){ //스택이 완전 빈 상태인경우
      //throw new EmptyStackException();
      throw new IllegalStateException("스택이 빈 상태입니다.");
    }
    int temp = arr[top]; //제거할 정수 반환
    arr[top--] = 0; //0을 넣어주고 top -1 감소
    return temp;
  }

  boolean isEmpty() {
    if(top == -1){ //top이 -1이면 스택이 빈상태
      return true;
    }
    return false;
  }

  boolean isFull(){
    if(top >= arr.length-1){ //top이 스택크기의 -1값이면 스택이 꽉찬 상태(인덱스 0부터 시작)
      return true;
    }
    return false;
  }

  int size(){ //스택 사이즈 반환
    return top + 1;
  }

  public StringBuilder getStringBuilder() {
    StringBuilder sb = new StringBuilder();
    for(int i = arr.length-1; i >= 0; i--){
      sb.append("i번째 : " + arr[i] + "\n");
    }
    return sb;
  }


}
