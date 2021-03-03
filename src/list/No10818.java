package list;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class No10818 {
    public static void main(String[] args) throws IOException {
        // 최솟값, 최댓값 구하기
        // 정답

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int numOfInt = Integer.parseInt(br.readLine());
        String[] line = br.readLine().split(" ");

        int max = -1000000;
        int min = 1000000;
        for (int i = 0; i < numOfInt; i++) {
            int currNum = Integer.parseInt(line[i]);
            if (currNum > max) max = currNum;
            if (currNum < min) min = currNum;
        }

        System.out.println(min + " " + max);
    }
}
