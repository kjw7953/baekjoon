package sorting;

import java.util.Scanner;

public class No2108 {
    static int avr(int[] arr) {
        int sum = 0;
        for (int i = 0; i < arr.length; i++) {
            sum += arr[i];
        }
        return Math.round( (float) sum / arr.length);
    }

    static int med(int[] arr) {
        return arr[(arr.length - 1) / 2];
    }

    static int mode(int[] arr, int n) {
        boolean isNegative = false;
        int abs = 0;
        if (arr[0] < 0) {
            isNegative = true;
            abs = Math.abs(arr[0]);
        }

        int[] temp = new int[4001 + abs];

        if (isNegative == true)
            for (int i = 0; i < n; i++) arr[i] += abs;

        for (int i = 0; i < 4001 + abs; i++) temp[i] = 0;

        for (int i = 0; i < n; i++) temp[arr[i]]++;

        int max = 0;
        for (int i = 0; i < 4001 + abs; i++) {
            if (temp[i] > temp[max]) {
                max = i;
            }
        }

        int second = -9999;
        for (int i = max + 1; i < 4001 + abs; i++) {
            if (temp[i] == temp[max]) {
                second = i;
                break;
            }
        }

        if (isNegative == true) {
          max -= abs;
          second -= abs;
          for (int i = 0; i < n; i++) arr[i] -= abs;
        }

        return second > -9999 ? second : max;
    }

    static int range(int[] arr) {
        return arr[arr.length - 1] - arr[0];
    }

    static void swap(int[] arr, int id1, int id2) {
        int temp = arr[id1];
        arr[id1] = arr[id2];
        arr[id2] = temp;
    }

    static int median3(int a, int b, int c) {
        if (a >= b) {
            if (b >= c) return b;
            if (c >= a) return a;
            else return c;
        } else {
            if (c <= a) return a;
            if (b <= c) return b;
            else return c;
        }
    }

    static void quick(int[] arr, int left, int right) {
        int pl = left;
        int pr = right;
        int m = median3(arr[pl], arr[pr], arr[(pl+pr)/2]);
        do {
            while (arr[pl] < m) pl++;
            while (arr[pr] > m) pr--;
            if (pl <= pr) {
                swap(arr, pl++, pr--);
            }
        } while (pl <= pr);

        if (left < pr) quick(arr, left, pr);
        if (right > pl) quick(arr, pl, right);
    }

    public static void main(String[] args) {
        Scanner stdIn = new Scanner(System.in);
        int n = stdIn.nextInt();
        int[] arr = new int[n];

        for (int i = 0; i < n; i++) arr[i] = stdIn.nextInt();
        quick(arr, 0, n-1);

        System.out.println(avr(arr));
        System.out.println(med(arr));
        System.out.println(mode(arr, n));
        System.out.println(range(arr));
    }

}
