package sorting;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class No11651 {
    static class Cordinates implements Comparable<Cordinates> {
        int x, y;

        Cordinates(int x, int y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public int compareTo(Cordinates c) {
            if (this.y >= c.y) {
                if (this.y > c.y) return 1;
                else return this.compX(c);
            } else return -1;
        }

        int compX(Cordinates c) {
            if (this.x >= c.x) {
                if (this.x > c.x) return 1;
                else return 0;
            } else return -1;
        }
    }


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        Cordinates[] cors = new Cordinates[n + 1];

        for (int i = 0; i < n; i++) {
            String[] line = br.readLine().split(" ");
            cors[i] = new Cordinates(Integer.parseInt(line[0]), Integer.parseInt(line[1]));
        }
        br.close();

        StringBuilder sb = new StringBuilder();

        Arrays.sort(cors);
        for(int i = 0; i < n; i++){
            sb.append(cors[i].x).append(' ').append(cors[i].y).append('\n');
        }
        System.out.println(sb);
    }
}
