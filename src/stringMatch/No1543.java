package stringMatch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class No1543 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String txt = br.readLine();
        String pattern = br.readLine();
        int patLen = pattern.length();
        int cnt = 0;

        while (txt.indexOf(pattern) != -1) {
            cnt++;
            txt = txt.substring(txt.indexOf(pattern) + patLen);
        }

        System.out.println(cnt);
    }
}
