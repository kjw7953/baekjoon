package stringMatch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class No1786 {
    static int[] skip;
    static List<Integer> li;

    static void skip(String pattern) {
        skip = new int[pattern.length() + 1];
        int pt = 1;
        int pp = 0;

        skip[pt] = 0;
        while (pt < pattern.length()) {
            if (pattern.charAt(pt) == pattern.charAt(pp))
                skip[++pt] = ++pp;
            else if (pp == 0)
                skip[++pt] = pp;
            else
                pp = skip[pp];
        }
    }

    static void kmp(String txt, String pattern) {
        int pt = 0;
        int pp = 0;
        int txtLen = txt.length();
        int patLen = pattern.length();

        while (pt < txtLen) {
            if (pp == patLen) {
                li.add(pt - patLen + 1);
                pp = skip[pp];
            }
            if (txt.charAt(pt) == pattern.charAt(pp)) {
                pt++;
                pp++;
            } else if (pp == 0)
                pt++;
            else
                pp = skip[pp];
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String txt = br.readLine();
        String pattern = br.readLine();

        li = new ArrayList<>();
        skip(pattern);
        kmp(txt, pattern);
        System.out.println(li.size());
        for(int i = 0; i < li.size(); i++)
            System.out.print(li.get(i) + " ");
    }
}
