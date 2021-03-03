package search;

public class Program {
    public static void main(String[] args) {
        AList<Integer> list = new AList<Integer>(10);
        for (int i = 0; i < 5; i++) {
            list.append(i);
        }
        list.moveToStart();
        for (int i = 0; i < 5; i++) {
            int removed = list.remove();
            System.out.print(removed + " ");
        }
    }
}
