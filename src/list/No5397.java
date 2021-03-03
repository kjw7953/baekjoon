package list;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

import static java.lang.Integer.parseInt;

public class No5397 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int caseNum = parseInt(br.readLine());

        for (int i = 0; i < caseNum; i++) {
            Stack left = new Stack();
            Stack right = new Stack();
            String keyLog = br.readLine();
            for (int j = 0; j < keyLog.length(); j++) {
                char key = keyLog.charAt(j);
                switch (key) {
                    case '<' :
                        if (!left.isEmpty()) right.push(left.pop());
                        break;
                    case '>':
                        if (!right.isEmpty()) left.push(right.pop());
                        break;
                    case '-':
                        if (!left.isEmpty()) left.pop();
                        break;
                    default:
                        left.push(key);
                }
            }

            for (int j = 0; j < left.size(); j++) sb.append(left.elementAt(j));
            for (int j = right.size()-1; j >= 0; j--) sb.append(right.elementAt(j));
            sb.append("\n");
        }

        System.out.println(sb);
    }
}