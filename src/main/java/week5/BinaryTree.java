package week5;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class BinaryTree {

    private Node root;

    public Node getRoot() {
        return root;
    }

    public void setRoot(Node root) {
        this.root = root;
    }

    //Node를 삽입하는 함수
    public void insertNode(int value) {
        //root가 없을 경우 root 지정
        if (root == null) {
            setRoot(new Node(value));
        } else {
            Node tempNode = root;

            //노드 순회 시작
            while (true) {
                //2) 노드 내 중복된 값은 존재할 수 없다.
                if (tempNode.getValue() == value) {
                    System.out.println("노드 내 중복된 값이 존재하여 삽입할 수 없습니다.");
                    break;
                } else if (tempNode.getValue() > value) {
                    //값이 작아 좌측으로 빠지는 경우
                    if (tempNode.getLeft() == null) {
                        tempNode.setLeft(new Node(value));
                        break;
                    } else {
                        tempNode = tempNode.getLeft();
                    }
                } else {
                    //값이 커 우측으로 빠지는 경우
                    if (tempNode.getRight() == null) {
                        tempNode.setRight(new Node(value));
                        break;
                    } else {
                        tempNode = tempNode.getRight();
                    }
                }

            }
        }
    }

    //Node를 삭제하는 함수
    public void deleteNode(int value) {
        if (root == null) {
            System.out.println("이진 트리가 존재하지 않습니다.");
        } else {
            Node tempNode = root;
            Node preNode = null;

            //노드 순회 시작
            while (true) {
                //2) 노드 내 중복된 값은 존재할 수 없다.
                if (tempNode.getValue() == value) {
                    break;
                } else if (tempNode.getValue() > value) {
                    //값이 작아 좌측으로 빠지는 경우
                    if (tempNode.getLeft() == null) {
                        System.out.println("삭제할 값이 존재하지 않습니다.");
                        break;
                    } else {
                        preNode = tempNode;
                        tempNode = tempNode.getLeft();
                    }
                } else {
                    //값이 커 우측으로 빠지는 경우
                    if (tempNode.getRight() == null) {
                        System.out.println("삭제할 값이 존재하지 않습니다.");
                        break;
                    } else {
                        preNode = tempNode;
                        tempNode = tempNode.getRight();
                    }
                }
            } //while문

            //삭제할 노드 = tempNode, 삭제할 노드의 부모 = preNode
            if (tempNode.getLeft() == null && tempNode.getRight() == null) {
                //1)삭제할 노드의 자식이 없는 경우
                if (preNode.getValue() > tempNode.getValue()) {
                    preNode.setLeft(null);
                } else {
                    preNode.setRight(null);
                }
            } else if (tempNode.getLeft() != null && tempNode.getRight() != null) {
                //3)삭제할 노드의 자식이 2개인 경우
                //좌측노드의 최댓값을 해당 값으로 올리는 것으로 한다.
                Node rightNode = tempNode.getLeft();
                preNode = tempNode;
                while (true) {
                    if (rightNode.getRight() == null) {
                        break;
                    }
                    preNode = rightNode;
                    rightNode = rightNode.getRight();
                }
                tempNode.setValue(rightNode.getValue());
                preNode.setRight(null);
            } else {
                //2)삭제할 노드의 자식이 1개인 경우 해당 노드에 값을 넣어주고 하단 삭제
                if (tempNode.getLeft() != null) {
                    tempNode = tempNode.getLeft();
                } else {
                    tempNode = tempNode.getRight();
                }
            }
        }
    }

    /**
     * 전위 순회
     */
    public StringBuilder preOrderSearch(Node node, int depth) {
        StringBuilder sb  = new StringBuilder();
        if (node != null) {
            sb.append(node.getValue() + " -> ");
            sb.append(preOrderSearch(node.getLeft(), depth + 1));
            sb.append(preOrderSearch(node.getRight(), depth + 1));
        }
        return sb;
    }

    /**
     * 중위 순회
     */
    public StringBuilder inOrderSearch(Node node, int depth) {
        StringBuilder sb  = new StringBuilder();
        if (node != null) {
            sb.append(inOrderSearch(node.getLeft(), depth + 1));
            sb.append(node.getValue() + " -> ");
            sb.append(inOrderSearch(node.getRight(), depth + 1));
        }
        return sb;
    }

    /**
     * 후위 순회
     */
    public StringBuilder postOrderSearch(Node node, int depth) {
        StringBuilder sb  = new StringBuilder();
        if (node != null) {
            sb.append(postOrderSearch(node.getLeft(), depth + 1));
            sb.append(postOrderSearch(node.getRight(), depth + 1));
            sb.append(node.getValue() + " -> ");
        }
        return sb;
    }

    //BFS 구현(node.getValue() = 찾으려는 값)
    public int bfs(Node node) {

        //찾으려는 값
        Integer answer = null;

        //LEFT, RIGHT를 체크할 배열
        int [] check_bfs = {0,0};

        //BFS는 Queue를 이용한다.
        Queue<Node> queue =  new LinkedList<Node>();

        Node searchNode = root;

        //root를 Queue에 넣고 시작
        queue.add(searchNode);
        Node tempNode = searchNode;

        while(true) {

            if(check_bfs[0] == 0) {
                /**좌측을 조사하지 않았다면 좌측 조사**/

                tempNode = queue.poll();

                if(tempNode == null ) {
                    System.out.println("찾으려는 데이터가 없습니다.");
                    break;
                }else if(tempNode.getValue() == node.getValue()){
                    System.out.print(tempNode.getValue());
                    answer = tempNode.getValue();
                    break;
                }else{
                    System.out.print(tempNode.getValue() +"  →  ");
                }

                searchNode = tempNode.getLeft();
                check_bfs[0] = 1; //LEFT 체크

                //노드가 null이면 queue에 넣지 않는다.
                if(searchNode !=null) {
                    queue.add(searchNode);
                }
            }else if(check_bfs[0] == 1 && check_bfs[1] == 0) {
                /**우측을 조사하지 않았다면 우측 조사**/

                tempNode = queue.poll();

                if(tempNode == null ) {
                    System.out.println("찾으려는 데이터가 없습니다.");
                    break;
                }else if(tempNode.getValue() == node.getValue()){
                    System.out.print(tempNode.getValue());
                    answer = tempNode.getValue();
                    break;
                }else{
                    System.out.print(tempNode.getValue() +"  →  ");
                }

                searchNode = tempNode.getRight();
                check_bfs[1] = 1; //RIGHT 체크

                //노드가 null이면 queue에 넣지 않는다.
                if(searchNode !=null) {
                    queue.add(searchNode);
                }
            }else {
                //LEFT, RIGHT 체크값 초기화
                check_bfs[0] = 0;
                check_bfs[1] = 0;
            }
        }
        return answer;
    }

    //DFS 구현(node.getValue() = 찾으려는 값)
    /**
     * DFS(깊이탐색) 구현
     * */
    public int dfs(Node node) {

        //찾으려는 값
        Integer answer = null;

        //DFS 스택구현
        Stack<Node> stack = new Stack<Node>();

        //Root로 부터 시작
        stack.push(root);
        System.out.print(root.getValue() + "  →   ");

        //해당노드를 방문했는지 여부(왼쪽, 오른쪽 모두 체크했을때 해당 맵에 데이터 PUT)
        HashMap<Node, Integer> checkMap = new HashMap<Node,Integer>();

        //탐색시작
        while (true) {
            //스택이 비었을 경우 모든 데이터 탐색 완료.
            if(stack.isEmpty()) {
                System.out.print(" 찾으려는 데이터가 없습니다.");
                break;
            }

            Node curr = stack.peek();

            //LEFT 값이 결과 값이면 break;
            if((curr.getLeft() != null && curr.getLeft().getValue() == node.getValue())) {
                System.out.print(curr.getLeft().getValue());
                answer = curr.getLeft().getValue();
                break;
            }

            //LEFT가 존재하면서 LEFT에 방문한적이 없으면 PUSH
            if (curr.getLeft() != null && !checkMap.containsKey(curr.getLeft())) {
                System.out.print(curr.getLeft().getValue() + "  →   ");
                stack.push(curr.getLeft());
                continue;
            }

            //RIGHT 값이 결과 값이면 break;
            if((curr.getRight() != null && curr.getRight().getValue() == node.getValue())) {
                System.out.print(curr.getRight().getValue());
                answer = curr.getRight().getValue();
                break;
            }

            //RIGHT가 존재하면서 RIGHT에 방문한적이 없으면 PUSH
            if (curr.getRight() != null && !checkMap.containsKey(curr.getRight())) {
                System.out.print(curr.getRight().getValue() + "  →   ");
                stack.push(curr.getRight());
                continue;
            }

            //양쪽에 모두 존재하지 않을 경우 스택에서 POP
            checkMap.put(curr, 1);
            stack.pop();
        }
        return answer;
    }

    /**
     * 전위순회 출력
     */
    public String preOrderPrint() {
        System.out.println("전위순회 시작 : ");
        StringBuilder sb = preOrderSearch(root, 0);
        sb.append("종료");
        return sb.toString();
    }

    /**
     * 중위순회 출력
     */
    public String inOrderPrint() {
        System.out.print("중위순회 시작 : ");
        StringBuilder sb = inOrderSearch(root, 0);
        sb.append("종료");
        return sb.toString();
    }

    /**
     * 후위순회출력
     */
    public String postOrderPrint() {
        System.out.print("후위순회 시작 : ");
        StringBuilder sb = postOrderSearch(root, 0);
        sb.append("종료");
        return sb.toString();
    }

}
