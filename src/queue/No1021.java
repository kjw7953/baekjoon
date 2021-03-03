package queue;

import java.util.Scanner;

public class No1021 {
    static class ArrQueue {
        int cnt = 0;
        int front;
        int rear;
        int max;
        int[] arrQ;

        ArrQueue(int size) {
            max = size;
            front = rear = 0;
            arrQ = new int[max];
        }

        void enque(int num) {
            arrQ[rear++ % max] = num;
            cnt++;
        }

        int getFront() {
            return arrQ[front];
        }

        // 1번 연산
        int deque() {
            int x = arrQ[front++ % max];
            cnt--;
            return x;
        }

        // 2번 연산
        void moveLeft() {
            front = (front + 1) % max;
            rear = (rear + 1) % max;
        }

        // 3번 연산
        void moveRight() {
            front = (max + front - 1) % max;
            rear = (max + rear - 1) % max;
        }

        int findIndex(int num) {
            for (int i = front; i <= rear; i++) {
                if (arrQ[i] == num) return i;
            }
            return -1;
        }

        void dump() {
            for (int i = 0; i < arrQ.length; i++) System.out.print(arrQ[i] + " ");
        }
    }

    public static void main(String[] args) {
        Scanner stdIn = new Scanner(System.in);
        int cnt = 0;                                   // 연산의 횟수

        int size = stdIn.nextInt();
        ArrQueue q = new ArrQueue(size);

        int cntNum = stdIn.nextInt();
        int[] nums = new int[cntNum];

        for (int i = 0; i < size; i++) {
            q.enque(i + 1);                       // 큐를 수의 위치로 초기
        }

        for (int i = 0; i < cntNum; i++) {
            nums[i] = stdIn.nextInt();
        }

        for (int i = 0; i < cntNum; i++) {
            while(true) {
                int mid;
                if (q.front < q.rear) {
                    mid = (q.front + q.rear + 1) / 2;
                } else {
                    mid = (q.front + q.rear + 1) / 2 + 1;
                }
                if (nums[i] == q.getFront()) {
                    q.deque();
                    break;
                } else if (q.findIndex(nums[i]) > mid) {
                    System.out.println(nums[i] + " moveRight");
                    q.moveRight();
                    cnt++;
                } else {{
                    System.out.println(nums[i] + " moveLeft");
                    q.moveLeft();
                    cnt++;
                }
                    System.out.println(nums[i] + " moveLeft");
                    q.moveLeft();
                    cnt++;
                }
            }
        }
        System.out.println("c" + cnt);
    }
}
