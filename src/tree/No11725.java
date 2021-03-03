package tree;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class No11725 {
    static Node[] nodes;
    static class Node {
        int value;
        boolean isChecked;
        int parent;

        Node(int value) {
            this.value = value;
            this.isChecked = false;
            this.parent = 0;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        Queue<Node> queue = new LinkedList<>();

        int n = Integer.parseInt(br.readLine());
        nodes = new Node[n];
        for (int i = 0 ; i < n; i++) nodes[i] = new Node(i + 1);

        List<Node>[] nodeList = new LinkedList[n];
        for (int i = 0; i < n; i++) {
            nodeList[i] = new LinkedList();
            nodeList[i].add(nodes[i]);
        }

        for (int i = 0; i < n - 1; i++) {
            String[] lines = br.readLine().split(" ");
            int node1 = Integer.parseInt(lines[0]) - 1;
            int node2 = Integer.parseInt(lines[1]) - 1;

            nodeList[node1].add(nodes[node2]);
            nodeList[node2].add(nodes[node1]);
        }

        queue.add(nodes[0]); nodes[0].isChecked = true;
        while (!queue.isEmpty()) {
            int curr = queue.poll().value;
            for (int i = 1; i < nodeList[curr - 1].size(); i++) {
                Node currNode = nodeList[curr - 1].get(i);
                if (!currNode.isChecked) {
                    currNode.isChecked = true;
                    currNode.parent = curr;
                    queue.add(currNode);
                }
            }
        }

        for (int i = 1; i < nodes.length; i++) {
            sb.append(nodes[i].parent + "\n");
        }
        System.out.println(sb);
    }
}
