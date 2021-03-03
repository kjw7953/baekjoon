package stack;

import java.util.Scanner;
import java.util.Stack;

public class No1918v2 {
    public static void main(String[] args) {
        Stack stk = new Stack();
        Scanner stdIn = new Scanner(System.in);

        char[] infixArr = stdIn.nextLine().toCharArray();

        for (int i = 0; i < infixArr.length; i++) {
            char c = infixArr[i];
            if ('A' <= c && c <= 'Z') {
                System.out.print(c);
                continue;
            } else if (stk.empty()) {
                stk.push(c);
                continue;
            }
            switch (c) {
                case ')':
                    while ((char)stk.peek() != '(') System.out.print(stk.pop());
                    stk.pop();
                    break;
                case '*':
                case '/':
                    while (!stk.empty() && ((char)stk.peek() == '*' || (char)stk.peek() == '/')) System.out.print(stk.pop());
                    stk.push(c);
                    break;
                case '+':
                case '-':
                    while (!stk.empty() && ((char)stk.peek() != '(')) System.out.print(stk.pop());
                    stk.push(c);
                    break;
                case '(':
                    stk.push(c);
            }
        }
        while (!stk.empty()) System.out.print(stk.pop());
    }
}
