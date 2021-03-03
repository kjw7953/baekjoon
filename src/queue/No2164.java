package queue;

import java.util.LinkedList;
import java.util.Scanner;

public class No2164 {
    static class LinkedQueue {
        LinkedList list = new LinkedList();
        int cnt = 0;

        public void enqueue(int num) {
            list.addLast((int) num);
            cnt++;
        }

        public int dequeue() {
            cnt--;
            return (int) list.removeFirst();
        }

        public int getValue() {
            return (int) list.getFirst();
        }
    }
    public static void main(String[] args) {
        LinkedQueue queue = new LinkedQueue();

        Scanner stdIn = new Scanner(System.in);
        int numCard = stdIn.nextInt();

        for (int i = 1; i <= numCard; i++) {
            queue.enqueue(i);
        }

        while (queue.cnt != 1) {
            queue.dequeue();
            queue.enqueue(queue.dequeue());
        }
        System.out.println(queue.getValue());
    }
}
