package set;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;

public class No7785 {
    static Person[] people = new Person[1000001];
    static int numOfPeople = 0;

    static class Person implements Comparable<Person> {
        final String name;
        private String status;

        Person(String name, String status) {
            this.name = name;
            this.status = status;
        }

        @Override
        public int compareTo(Person o) {
            return this.name.compareTo(o.name);
        }

        void setStatus(String status) {
            this.status = status;
        }

        static Person getPerson(String name) {
            for (int i = 0; i < numOfPeople; i++) {
                if (people[i].name.equals(name)) return people[i];
            }
            return null;
        }

        static int getIndex(String name) {
            for (int i = 0; i < numOfPeople; i++) {
                if (people[i].name.equals(name)) return i;
            }
            return -1;
        }
    }

    static void manageLog(String[] logs) {
        for (int i = 0; i < logs.length; i++) {
            String[] log = logs[i].split(" ");
            if (log[1].equals("enter")) {
                people[numOfPeople] = new Person(log[0], "enter");
                numOfPeople++;
            } else {
                Person person = Person.getPerson(log[0]);
                if (person != null) {
                    person.setStatus("leave");
                    Person temp = people[numOfPeople - 1];
                    people[numOfPeople - 1] = people[Person.getIndex(log[0])];
                    people[Person.getIndex(log[0])] = temp;
                    numOfPeople--;
                }
            }
        }
        sort();
    }

    static void sort() {
        if (numOfPeople <= 0) return;
        Arrays.sort(people, 0, numOfPeople, Collections.reverseOrder());
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] logs;

        int num = Integer.parseInt(br.readLine());
        logs = new String[num];

        for (int i = 0; i < num; i++)
            logs[i] = br.readLine();

        manageLog(logs);

        for (int i = 0; i < numOfPeople; i++)
            System.out.println(people[i].name);
    }
}
