package sorting;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;

public class No13415 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        Integer[] arr = new Integer[n];

        String[] lines = br.readLine().split(" ");
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(lines[i]);
        }

        int set = Integer.parseInt(br.readLine());
        for (int i = 0; i < set; i++) {
            String[] line = br.readLine().split(" ");
            Arrays.sort(arr, 0, Integer.parseInt(line[0]));
            Arrays.sort(arr, 0, Integer.parseInt(line[1]), Collections.reverseOrder());
        }
        br.close();

        for (int i = 0; i < n; i++) System.out.println(arr[i]);
    }
}
