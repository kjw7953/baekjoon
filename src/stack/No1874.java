package stack;

import java.util.Scanner;
import java.util.Stack;

public class No1874 {
    public static void main(String[] args) {
        Stack s = new Stack();
        int[] arr;
        int cnt;
        Scanner stdIn = new Scanner(System.in);

        // 수열 입력
        cnt = stdIn.nextInt();
        arr = new int[cnt];
        for (int i = 0; i < cnt; i++) arr[i] = stdIn.nextInt();

        /*
        1. 수열의 다음 값이 현재 s.peek()보다 크다면 s.push(curVal++)을 해줘서 arr[i] == s.peek()를 맞춰주고 s.pop() 해서 그걸 꺼내줌.
           s.pop()으로 꺼내진 값들이 수열의 각 요소가 되도록 조절
        2. s.pop()으로 꺼낸 모든 값은 수열을 이루어야 한다.
           만약 수열의 다음 값이 현재 s.peek() 보다 작다면 s.pop()한 값이 수열에 등록되지 못하는 것이니까 No가 된다.
           문제의 예시처럼 3 다음에 4를 뽑으라는 것 또한 현재 peek 값이 4인데 3을 뽑으라고 하니까 No가 되는 것.
        3. No인 경우에는 처음부터 바로 No를 출력해줘야 하기 때문에 2번과 같은 경우가 나오는지 본격적인 출력 전에 확인해야 한다.
        */

        // 3번 구현
        int flag = 0;
        for (int i = 0; i < cnt - 1; i++) {
            if (flag == 1 && arr[i] < arr[i + 1]) {
                System.out.println("NO");
                return;
            }
            if (arr[i] > arr[i + 1])
                flag = 1;
        }

        // 1, 2번 구현
        // 수열의 최솟값이 1이므로 스택에 미리 1을 넣어두고 시작
        int curVal = 1;
        System.out.println("+");
        s.push(curVal++);

        for (int i = 0; i < cnt; i++) {
            if (arr[i] > (int)s.peek()) {
                while (true) {
                    System.out.println("+");
                    s.push(curVal++);
                    if ( (int)s.peek() == arr[i] ) {
                        System.out.println("-");
                        s.pop();
                        break;
                    }
                }
            } else if (arr[i] == (int)s.peek()) {
                System.out.println("-");
                s.pop();
            }
        }
    }
}

