package BaekJoon;

import java.io.*;
import java.util.*;

public class BOJ_2751_Bi {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        Node root = new Node(Integer.parseInt(br.readLine()));
        for (int i = 1; i < n; i++) {
            setTree(root,new Node(Integer.parseInt(br.readLine())));
        }

        StringBuilder sb = new StringBuilder();

        inorder(root, sb);

        System.out.println(sb);
    }

    private static StringBuilder inorder(Node node, StringBuilder sb) {
        if (Objects.nonNull(node.left)) {
            inorder(node.left, sb);
        }

        sb.append(node.data + "\n");

        if (Objects.nonNull(node.right)) {
            inorder(node.right, sb);
        }
        return sb;
    }

    private static void setTree(Node now, Node newNode) {
        if (now.data > newNode.data) {
            if (Objects.isNull(now.left)) {
                now.left = newNode;
                return;
            }
            setTree(now.left, newNode);
            return;
        }
        if (Objects.isNull(now.right)) {
            now.right = newNode;
            return;
        }
        setTree(now.right, newNode);
    }

    private static class Node {
        private int data;
        private Node left;
        private Node right;

        public Node(int data) {
            this.data = data;
        }
    }
}
