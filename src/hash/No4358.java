package hash;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;

public class No4358 {
    public static void main(String[] args) throws IOException {
        HashMap<String, Integer> hashMap = new HashMap(10000);
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        String input;
        int num = 0;
        while ((input = br.readLine()) != null && input.length() != 0) {
            if (hashMap.containsKey(input)) hashMap.put(input, hashMap.get(input) + 1);
            else hashMap.put(input, 1);
            num++;
        }

        Object[] mapKey = hashMap.keySet().toArray();
        Arrays.sort(mapKey);
        for (Object key : mapKey) {
            int value = hashMap.get(key);
            String portion = String.format("%.4f", (double) value * 100 / num);
            sb.append(key + " " + portion + "\n");
        }

        System.out.println(sb);
    }
}
