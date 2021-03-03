package stack;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

import static java.lang.Integer.parseInt;

public class No10773 {
    public static void main(String[] args) throws IOException {
        Stack<Integer> stk = new Stack();

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int caseNum = parseInt(br.readLine());

        for (int i = 0; i < caseNum; i++) {
            int nextValue = parseInt(br.readLine());
            if (nextValue == 0 && !stk.isEmpty()) stk.pop();
            else stk.push(nextValue);
        }
        int sum = 0;
        while (!stk.isEmpty()) sum += stk.pop();
        System.out.println(sum);
    }
}
