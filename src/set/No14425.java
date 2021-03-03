package set;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class No14425 {
    static int search(String[] set1, String[] set2) {
        int count = 0;

        for (int i = 0; i < set2.length; i++) {
            int first = 0;
            int end = set1.length - 1;
            do {
                int mid = (first + end) / 2;
                int comp = set2[i].compareTo(set1[mid]);
                if (comp == 0) {
                    count++;
                    break;
                } else if (comp > 0) first = mid + 1;
                else end = mid - 1;
            } while (first <= end);
        }
        return count;
    }

    static int search1(String[] set1, String[] set2) {
        int count = 0;

        for (int i = 0; i < set2.length; i++) {
            for (int j = 0; j < set1.length; j++) {
                if (set2[i].equals(set1[j])) {
                    count++;
                    break;
                }
            }
        }
        return count;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] set1, set2;
        String[] nums = br.readLine().split(" ");
        int n = Integer.parseInt(nums[0]);
        set1 = new String[n];
        int m = Integer.parseInt(nums[1]);
        set2 = new String[m];

        for (int i = 0; i < n; i++) set1[i] = br.readLine();
        Arrays.sort(set1);
        for (int i = 0; i < m; i++) set2[i] = br.readLine();

        System.out.println(search1(set1, set2));
    }
}
