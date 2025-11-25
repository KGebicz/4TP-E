import java.util.*;

// Klasa, którą będziemy sortować za pomocą Comparatorów
class Person {
    String name;
    int age;

    Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    // Ułatwia wyświetlanie obiektu w konsoli
    @Override
    public String toString() {
        return name + " (" + age + ")";
    }
}

class Student {
            String name;
            Integer grade;

            Student(String name, Integer grade) {
                this.name = name;
                this.grade = grade;
            }
        }


public class bibliotekacz2 {
    public static void main(String[] args) {

        // Lista przykładowych osób
        List<Person> people = List.of(
                new Person("Anna", 30),
                new Person("Bartek", 20),
                new Person("Celina", 25)
        );

        // -----------------------------------------
        // 1. Comparator porównujący po wieku (rosnąco)
        // -----------------------------------------
        // Integer.compare zwraca:
        //  - liczbę ujemną, jeśli p1.age < p2.age
        //  - zero, jeśli są równe
        //  - liczbę dodatnią, jeśli p1.age > p2.age
        List<Person> poWieku = new ArrayList<>(people);
        poWieku.sort(Comparator.comparingInt(p -> p.age));
        for (Person p : poWieku) {
            System.out.println(" • " + p);
        }


        // -----------------------------------------
        // 2. Comparator porównujący po imieniu
        // -----------------------------------------
        // Comparator.comparing pobiera funkcję
        // zwracającą cechę, po której chcemy sortować
        System.out.println("\n=== Sortowanie po imieniu ===");
        List<Person> poImieniu = new ArrayList<>(people);
        poImieniu.sort(Comparator.comparing(p -> p.name));
        for (Person p : poImieniu) {
            System.out.println(" • " + p);
        }


        // -----------------------------------------
        // 3. Sortowanie po wieku malejąco (od największego wieku)
        // -----------------------------------------
        // Najpierw sortujemy po wieku rosnąco,
        // potem reversed() odwraca kolejność
        System.out.println("\n=== Sortowanie po wieku malejąco ===");
        List<Person> poWiekuDesc = new ArrayList<>(people);
        poWiekuDesc.sort(Comparator.comparingInt((Person p) -> p.age).reversed());
        for (Person p : poWiekuDesc) {
            System.out.println(" • " + p);
        }


        // -----------------------------------------
        // 4. Comparator z obsługą nulli
        // -----------------------------------------
        // Jeśli obiekt jest null, ma znaleźć się NA KOŃCU listy
        Comparator<Person> safeByName =
                Comparator.nullsLast(Comparator.comparing(p -> p.name));

                // =======================================================
                // 2. COLLECTIONS – sortowanie, odwracanie, tasowanie
                // =======================================================

        // Tworzymy listę liczb
        // Uwaga: ArrayList, bo będziemy ją modyfikować
        List<Integer> numbers = new ArrayList<>(List.of(5, 1, 3, 2, 4));

        // -----------------------------------------
        // 1. Sortowanie rosnąco (naturalny porządek)
        // Collections.sort używa Comparable lub Comparatora
        // jeśli obiekty go posiadają
        // -----------------------------------------
        Collections.sort(numbers);
        System.out.println("Sort: " + numbers);

        // -----------------------------------------
        // 2. Odwracanie kolejności
        // Najpierw lista musi mieć jakąś kolejność (np. po sortowaniu)
        // -----------------------------------------
        Collections.reverse(numbers);
        System.out.println("Reverse: " + numbers);

        // -----------------------------------------
        // 3. Losowe tasowanie elementów
        // Przydatne w grach, quizach, losowaniach
        // -----------------------------------------
        Collections.shuffle(numbers);
        System.out.println("Shuffle: " + numbers);

        // -----------------------------------------
        // 4. Znalezienie maksimum i minimum
        // Działa na typach, które implementują Comparable
        // -----------------------------------------
        System.out.println("Max: " + Collections.max(numbers));
        System.out.println("Min: " + Collections.min(numbers)+"\n\n\n");
    
                // =======================================================
                // 3. Objects – sortowanie, odwracanie, tasowanie
                // =======================================================

                // -----------------------------------------
                // 1. Bezpieczne porównanie dwóch obiektów
                // equals() radzi sobie z sytuacją:
                // Objects.equals(null, "tekst") -> false
                // "tekst".equals(null) wywołałoby wyjątek
                // -----------------------------------------
                boolean same = Objects.equals("Ala", "Ala");
                System.out.println("Objects.equals: " + same);

                // -----------------------------------------
                // 2. Porównywanie obiektów z użyciem Comparatora
                // Objects.compare(a, b, comparator)
                // metoda wywołuje comparator.compare(a, b)
                // ale dodatkowo zabezpiecza przed nullami
                // -----------------------------------------
                Student s1 = new Student("Ala", 5);
                Student s2 = new Student("Ola", 4);

                int result = Objects.compare(
                        s1,
                        s2,
                        Comparator.comparing(s -> s.grade)
                );
                System.out.println("Porównanie ocen: " + result);

                // -----------------------------------------
                // 3. requireNonNull – wyrzuca wyjątek, jeśli argument jest null
                // Używane do walidacji danych
                // -----------------------------------------
                try {
                    String x = null;
                    Objects.requireNonNull(x, "String nie może być null!");
                } catch (NullPointerException e) {
                    System.out.println("Złapano wyjątek: " + e.getMessage());
                }

                // -----------------------------------------
                // 4. Tworzenie hash na podstawie wielu wartości
                // Przydatne w hashCode()
                // -----------------------------------------
                int hash = Objects.hash("Ala", 123, true);
                System.out.println("Hash: " + hash);
            }
        }