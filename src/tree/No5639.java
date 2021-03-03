package tree;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class No5639 {
    static StringBuilder sb;
    static class Node {
        int data;
        Node left;
        Node right;

        Node(int data, Node left, Node right) {
            this.data = data;
            this.left = left;
            this.right = right;
        }

        Node setLeft(Node node) {
            return this.left = node;
        }

        Node setRight(Node node) {
            return this.right = node;
        }
    }

    static class bTree {
        Node root;
        int size;

        bTree() {
            this.root = null;
            size = 0;
        }

        void insert(int data) {
            root = insertHelp(root, data);
            size++;
        }

        Node insertHelp(Node root, int data) {
            if (root == null) return new Node(data, null, null);

            if (root.data > data) root.setLeft(insertHelp(root.left, data));
            else root.setRight(insertHelp(root.right, data));
            return root;
        }

        void postOrderTraversal(Node root) {
            if (root == null) return;
            postOrderTraversal(root.left);
            postOrderTraversal(root.right);
            sb.append(root.data + "\n");
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        sb = new StringBuilder();
        bTree binTree = new bTree();

        while (scanner.hasNextLine()) {
            int data = Integer.parseInt(scanner.nextLine());
            binTree.insert(data);
        }

        binTree.postOrderTraversal(binTree.root);
        System.out.println(sb);
    }
}
