package mergeSort;

import java.util.Comparator;

public class student {
    public static final Comparator<student> BY_NAME = new ByName();
    public static final Comparator<student> BY_AGE = new ByAge();
    private int age;
    private String name;

    public student(String n, int a) {
        name = n;
        age = a;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    private static class ByName implements Comparator<student> {
        @Override
        public int compare(student o1, student o2) {
            return o1.age - o2.age;
        }
    }

    private static class ByAge implements Comparator<student> {
        @Override
        public int compare(student o1, student o2) {
            return o1.name.compareTo(o2.name);
        }
    }

}
