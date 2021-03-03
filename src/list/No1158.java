package list;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class No1158 {
    public static class LinkedList<E> {
        public class Node<E> {
            Node<E> next;
            int data;

            Node() {
                this.next = null;
            }

            Node(int data, Node<E> next) {
                this.data = data;
                this.next = next;
            }

            Node setNext(Node<E> node) {
                this.next = node;
                return node;
            }

            Node next() {
                return this.next;
            }
        }

        Node<E> head;
        Node<E> tail;
        Node<E> curr;
        int size;

        LinkedList() {
            head = new Node();
            tail = curr = head;
            size = 0;
        }

        void append(int data) {
            tail = tail.setNext(new Node<E>(data, null));
            if (size == 0) head.setNext(tail);
            tail.setNext(head.next());
            size++;
        }

        void move(int order) {
            for (int i = 0; i < order - 1; i++) {
                curr = curr.next();
            }
        }

        int remove(int order) {
            move(order);
            int data = curr.next().data;
            curr.setNext(curr.next().next());
            size--;
            return data;
        }
    }

    public static void main(String[] args) throws IOException {
        LinkedList list = new LinkedList();
        StringBuilder sb = new StringBuilder();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] line = br.readLine().split(" ");
        int size = Integer.parseInt(line[0]);
        int order = Integer.parseInt(line[1]);

        for (int i = 0; i < size; i++) {
            list.append(i + 1);
        }

        for (int i = 0; i < size; i++) {
            if (i == 0) sb.append("<" + list.remove(order));
            else sb.append(", " + list.remove(order));
        }
        sb.append(">");

        System.out.println(sb);
    }
}
