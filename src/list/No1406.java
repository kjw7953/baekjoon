package list;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.List;

public class No1406 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String str = br.readLine();

        int n = Integer.parseInt(br.readLine());
        List<Character> list = new LinkedList<>();

        for (int i = 0; i < str.length(); i++) {
            list.add(str.charAt(i));
        }

        int size = list.size();
        int index = list.size();

        for (int i = 0; i < n; i++) {
            String[] line = br.readLine().split(" ");
            String option = line[0];

            switch (option) {
                case "L":
                    if (index != 0) index -= 1;
                    break;
                case "D":
                    if (index != size) index += 1;
                    break;
                case "B":
                    if (index != 0) list.remove(index);
                    break;
                case "P":
                    if (index >= size) list.add(index, line[1].charAt(0));
                    else list.add(index + 1, line[1].charAt(0));
                    break;
            }
        }
        System.out.println(list.toString());
    }
}