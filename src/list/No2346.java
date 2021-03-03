package list;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;

import static java.lang.Integer.parseInt;

public class No2346 {
    static class Balloon {
        int value;
        int order;
        Balloon(int value, int order) {
            this.value = value;
            this.order = order;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        ArrayDeque<Balloon> balloons = new ArrayDeque<>();
        StringBuilder sb = new StringBuilder();

        br.readLine();
        String[] values = br.readLine().split(" ");
        for (int i = 0; i < values.length; i++) {
            Balloon temp = new Balloon(parseInt(values[i]), i + 1);
            balloons.add(temp);
        }

        while (!balloons.isEmpty()) {
            Balloon ballon = balloons.getFirst();
            int next = ballon.value;
            sb.append(ballon.order + " ");
            balloons.removeFirst();
            if (balloons.size() == 0) break;

            if (next > 0) {
                for (int i = 0; i < next - 1; i++) balloons.addLast(balloons.removeFirst());
            } else {
                for (int i = 0; i < Math.abs(next); i++) balloons.addFirst(balloons.removeLast());
            }
        }
        System.out.println(sb);
    }
}