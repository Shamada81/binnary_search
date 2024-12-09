import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        // Демонстрация методов класса Arrays
        System.out.println("Демонстрация методов класса Arrays:");

        int[] intArray = {1, 3, 5, 7, 9};
        int intIndex = Arrays.binarySearch(intArray, 5);
        System.out.println("Индекс 5 в массиве int: " + intIndex);

        double[] doubleArray = {1.1, 2.2, 3.3, 4.4};
        int doubleIndex = Arrays.binarySearch(doubleArray, 3.3);
        System.out.println("Индекс 3.3 в массиве double: " + doubleIndex);

        String[] stringArray = {"Alice", "Bob", "Charlie"};
        int stringIndex = Arrays.binarySearch(stringArray, "Bob", String::compareTo);
        System.out.println("Индекс 'Bob' в массиве String: " + stringIndex);

        // Демонстрация методов класса Collections
        System.out.println("\nДемонстрация методов класса Collections:");

        List<Integer> intList = new ArrayList<>();
        intList.add(1);
        intList.add(3);
        intList.add(5);
        intList.add(7);
        intList.add(9);
        int indexInList = Collections.binarySearch(intList, 7);
        System.out.println("Индекс 7 в списке int: " + indexInList);

        List<String> stringList = new ArrayList<>();
        stringList.add("Alice");
        stringList.add("Bob");
        stringList.add("Charlie");
        int indexInStringList = Collections.binarySearch(stringList, "Charlie");
        System.out.println("Индекс 'Charlie' в списке String: " + indexInStringList);

        List<Person> people = new ArrayList<>();
        people.add(new Person("Alice", 30));
        people.add(new Person("Bob", 25));
        people.add(new Person("Charlie", 35));

        // Сортировка списка
        people.sort(new NameComparator());
        Person searchPerson = new Person("Bob", 0); // Возраст не имеет значения для сравнения по имени
        int personIndex = Collections.binarySearch(people, searchPerson, new NameComparator());
        System.out.println("Индекс 'Bob' в списке Person: " + personIndex);
    }
}

// Класс для демонстрации Comparator
class Person {
    private String name;
    private int age;

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return name + " (" + age + ")";
    }
}

// Comparator для класса Person
class NameComparator implements Comparator<Person> {
    @Override
    public int compare(Person p1, Person p2) {
        return p1.getName().compareTo(p2.getName());
    }
}
