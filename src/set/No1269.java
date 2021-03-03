package set;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class Set {
    int num;
    int[] set;

    Set(int n) {
        this.num = n;
        set = new int[n];
    }

    int numOfSet() {
        return this.num;
    }

    boolean isContain(int n) {
        for (int i = 0; i < this.num; i++)
            if (this.set[i] == n) return true;
        return false;
    }

    static int complement(Set s1, Set s2) {
        int result = s1.numOfSet();

        for (int i = 0; i < s2.numOfSet(); i++)
            if (s1.isContain(s2.set[i])) result--;

        return result;
    }

    static int numOfUnion(Set s1, Set s2) {
        return complement(s1, s2) + complement(s2, s1);
    }
}

public class No1269 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String line = br.readLine();
        String[] lines = line.split(" ");
        Set s1 = new Set(Integer.parseInt(lines[0]));
        Set s2 = new Set(Integer.parseInt(lines[1]));

        for (int i = 0; i < 2; i++) {
            String sequence = br.readLine();
            String[] elems = sequence.split(" ");

            for (int j = 0; j < elems.length; j++)
                if (i == 0) s1.set[j] = Integer.parseInt(elems[j]);
                else s2.set[j] = Integer.parseInt(elems[j]);
        }

        System.out.println(Set.numOfUnion(s1, s2));
    }
}
