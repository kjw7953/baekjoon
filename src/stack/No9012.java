package stack;

import java.util.Scanner;
import java.util.Stack;

public class No9012 {
    public static void main(String[] args) {
        Scanner stdIn = new Scanner(System.in);
        Stack stk = new Stack();
        int cnt = stdIn.nextInt();
        stdIn.nextLine();
        String[] ps = new String[cnt];

        for (int i = 0; i < cnt; i++) {
            ps[i] = stdIn.nextLine();
            int flag = 1;
            for (char c : ps[i].toCharArray()) {
                if (c == '(') {
                    stk.push(c);
                } else if (c == ')') {
                    if (stk.isEmpty()) {
                        System.out.println("NO");
                        flag = 0;
                        break;
                    }
                    stk.pop();
                }
            }
            if (!stk.empty()) {
                System.out.println("NO");
                flag = 0;
            }
            if (flag == 1) System.out.println("YES");
            stk.clear();
        }
    }
}
