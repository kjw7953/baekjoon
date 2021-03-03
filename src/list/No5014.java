package list;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

import static java.lang.Integer.parseInt;

public class No5014 {
    static int[] check;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] infos = br.readLine().split(" ");
        Queue<Integer> queue = new LinkedList<>();

        int f = parseInt(infos[0]);
        int s = parseInt(infos[1]);
        int g = parseInt(infos[2]);
        int u = parseInt(infos[3]);
        int d = parseInt(infos[4]);
        check = new int[f + 1];

        queue.add(s); check[s] = 1;
        while (!queue.isEmpty()) {
            int curr = queue.poll();
            if (curr == g) {
                System.out.println(check[curr] - 1);
                return;
            }

            if ( (curr + u <= f) && check[curr + u] == 0 ) {
                queue.add(curr + u);
                check[curr + u] = check[curr] + 1;
            }
            if ( (curr - d >= 1) && check[curr - d] == 0 ) {
                queue.add(curr - d);
                check[curr - d] = check[curr] + 1;
            }
        }
        System.out.println("use the stairs");
    }
}
