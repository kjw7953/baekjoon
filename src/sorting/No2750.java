package sorting;

import java.util.Scanner;

public class No2750 {
    static void no2750(int[] arr, int n) {
        for (int i = 0; i < n-1; i++) {
            for (int j = 0; j < n - 1 - i; j++) {
                if (arr[j] > arr[j+1]) {
                    int temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                }
            }
        }
    }

    public static void main(String[] args) {
        Scanner stdIn = new Scanner(System.in);

        int n = stdIn.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) arr[i] = stdIn.nextInt();
        no2750(arr, n);
        for (int i = 0; i < n; i++) System.out.println(arr[i]);
    }
}
