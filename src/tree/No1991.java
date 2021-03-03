package tree;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class No1991 {
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
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        sb = new StringBuilder();

        int numOfNode = Integer.parseInt(br.readLine());
        Node[] nodes = new Node[numOfNode];

        for (int i = 0; i < numOfNode; i++)
            nodes[i] = new Node((char) 'A'+i, null, null);

        for (int i = 0; i < numOfNode; i++) {
            char[] lines = br.readLine().replaceAll(" ", "").toCharArray();
            int curr = lines[0] - 'A';

            if (lines[1] != '.') {
                int next = lines[1] - 'A';
                nodes[curr].left = nodes[next];
            }
            if (lines[2] != '.') {
                int next = lines[2] - 'A';
                nodes[curr].right = nodes[next];
            }
        }

        traversal(nodes[0], "preOrder");
        sb.append("\n");
        traversal(nodes[0], "inOrder");
        sb.append("\n");
        traversal(nodes[0], "postOrder");

        System.out.println(sb);
    }

    static void traversal(Node root, String type) {
        if (root == null) return;
        switch(type) {
            case "preOrder":
                sb.append((char) root.data);
                traversal(root.left, "preOrder");
                traversal(root.right, "preOrder");
                break;
            case "inOrder":
                traversal(root.left, "inOrder");
                sb.append((char)root.data);
                traversal(root.right, "inOrder");
                break;
            case "postOrder":
                traversal(root.left, "postOrder");
                traversal(root.right, "postOrder");
                sb.append((char) root.data);
                break;
            default:
                break;
        }
    }
}
