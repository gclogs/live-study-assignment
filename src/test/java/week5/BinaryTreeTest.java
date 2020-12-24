package week5;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;
import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class BinaryTreeTest {

    @Test
    void insert() throws Exception {
        BinaryTree bTree = new BinaryTree();

        bTree.insertNode(10); //첫번째 넣는 값은 root노드의 value가 됨
        bTree.insertNode(5);
        bTree.insertNode(15);

        assertThat(bTree.getRoot().getLeft().getValue()).isEqualTo(5);
        assertThat(bTree.getRoot().getRight().getValue()).isEqualTo(15);

    }

    @Test
    @DisplayName("삭제할 노드가 자식이 없는경우")
    void delete_version1() throws Exception {
        BinaryTree bTree = new BinaryTree();

        bTree.insertNode(24); //첫번째 넣는 값은 root노드의 value가 됨
        bTree.insertNode(16);
        bTree.insertNode(32);
        bTree.insertNode(11);
        bTree.insertNode(21);
        bTree.insertNode(27);

        bTree.deleteNode(21);

        assertThat(bTree.getRoot().getLeft().getRight()).isNull();

    }

    @Test
    @DisplayName("삭제할 노드가 자식이 1개인 경우")
    void delete_version2() throws Exception {
        BinaryTree bTree = new BinaryTree();

        bTree.insertNode(24); //첫번째 넣는 값은 root노드의 value가 됨
        bTree.insertNode(16);
        bTree.insertNode(32);
        bTree.insertNode(11);
        bTree.insertNode(21);
        bTree.insertNode(27);

        bTree.deleteNode(32);

        assertThat(bTree.getRoot().getRight().getValue()).isEqualTo(32);

    }

    @Test
    @DisplayName("삭제할 노드가 자식이 2개인 경우")
    void delete_version3() throws Exception {
        BinaryTree bTree = new BinaryTree();

        bTree.insertNode(24); //첫번째 넣는 값은 root노드의 value가 됨
        bTree.insertNode(16);
        bTree.insertNode(32);
        bTree.insertNode(11);
        bTree.insertNode(21);
        bTree.insertNode(27);

        bTree.deleteNode(24);

        assertThat(bTree.getRoot().getValue()).isEqualTo(21);

    }

    @Test
    void 순회_검사() throws Exception {
        BinaryTree bTree = new BinaryTree();
        bTree.insertNode(10);
        bTree.insertNode(5);
        bTree.insertNode(3);
        bTree.insertNode(6);
        bTree.insertNode(15);
        bTree.insertNode(13);
        bTree.insertNode(11);
        bTree.insertNode(14);
        bTree.insertNode(16);

        assertThat(bTree.preOrderPrint()).hasToString("10 -> 5 -> 3 -> 6 -> 15 -> 13 -> 11 -> 14 -> 16 -> 종료");
        assertThat(bTree.inOrderPrint()).hasToString("3 -> 5 -> 6 -> 10 -> 11 -> 13 -> 14 -> 15 -> 16 -> 종료");
        assertThat(bTree.postOrderPrint()).hasToString("3 -> 6 -> 5 -> 11 -> 14 -> 13 -> 16 -> 15 -> 10 -> 종료");
    }


    @Test
    void bfs() throws Exception {
        BinaryTree bTree = new BinaryTree();

        Node node = new Node(6);

        bTree.insertNode(10);
        bTree.insertNode(5);
        bTree.insertNode(3);
        bTree.insertNode(6);
        bTree.insertNode(15);
        bTree.insertNode(13);
        bTree.insertNode(11);
        bTree.insertNode(14);
        bTree.insertNode(16);

        System.out.print("BFS탐색 = ");
        assertThat(bTree.bfs(node)).isEqualTo(6);
    }

    @Test
    void dfs() throws Exception {
        BinaryTree bTree = new BinaryTree();

        Node node = new Node(6);

        bTree.insertNode(10);
        bTree.insertNode(5);
        bTree.insertNode(3);
        bTree.insertNode(6);
        bTree.insertNode(15);
        bTree.insertNode(13);
        bTree.insertNode(11);
        bTree.insertNode(14);
        bTree.insertNode(16);

        System.out.print("DFS탐색 = ");
        assertThat(bTree.dfs(node)).isEqualTo(6);

    }

}