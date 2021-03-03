package hash;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;

public class No2002 {
    public static void main(String[] args) throws IOException {
        HashMap<String, Integer> hashMap = new HashMap(1001);
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int numCar = Integer.parseInt(br.readLine());
        Integer[] output = new Integer[numCar];

        for (int i = 0; i < numCar; i++) hashMap.put(br.readLine(), i);

        for (int i = 0; i < numCar; i++) {
            String input = br.readLine();
            output[i] = hashMap.get(input);
        }

        int passCnt = 0;
        for (int i = 0; i < numCar - 1; i++) {
            for (int j = i+1; j < numCar; j++) {
                if (output[i] > output[j]) {
                    passCnt++;
                    break;
                }
            }
        }

        System.out.println(passCnt);
    }
}
