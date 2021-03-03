package sorting;

public class dsafsdf {
    public static void main(String[] args) {
        int threeAndOne = 0;
        int threeAndTwo = 0;
        int threeAndThree = 0;
        int eightAndOne = 0;
        for (int i = 1; i <= 100; i++) {
            if (i % 3 == 1) {
                if (i % 11 == 0) {
                    threeAndOne++;
                    System.out.print(i + (" "));
                } else if (i % 11 == 1) {
                    threeAndOne++;
                    System.out.print(i + (" "));
                } else if (i % 11 == 2) {
                    threeAndOne++;
                    System.out.print(i + (" "));
                } else if (i % 11 == 9) {
                    threeAndOne++;
                    System.out.print(i + (" "));
                } else if (i % 11 == 10) {
                    threeAndOne++;
                    System.out.print(i + (" "));
                } else if (i % 11 == 7) {
                    eightAndOne++;
                }
            } else if (i % 3 == 2) {
                if (i % 11 == 0) {
                    threeAndTwo++;
                    System.out.print(i + (" "));
                } else if (i % 11 == 1) {
                    threeAndTwo++;
                    System.out.print(i + (" "));
                } else if (i % 11 == 2) {
                    threeAndTwo++;
                    System.out.print(i + (" "));
                } else if (i % 11 == 9) {
                    threeAndTwo++;
                    System.out.print(i + (" "));
                } else if (i % 11 == 10) {
                    threeAndTwo++;
                    System.out.print(i + (" "));
                }
            } else if (i % 3 == 0) {
                if (i % 11 == 0) {
                    threeAndThree++;
                    System.out.print(i + (" "));
                } else if (i % 11 == 1) {
                    threeAndThree++;
                    System.out.print(i + (" "));
                } else if (i % 11 == 2) {
                    threeAndThree++;
                    System.out.print(i + (" "));
                } else if (i % 11 == 9) {
                    threeAndThree++;
                    System.out.print(i + (" "));
                } else if (i % 11 == 10) {
                    threeAndThree++;
                    System.out.print(i + (" "));
                }
            }
        }
        System.out.print(threeAndOne + threeAndThree + threeAndTwo + eightAndOne);
    }
}
