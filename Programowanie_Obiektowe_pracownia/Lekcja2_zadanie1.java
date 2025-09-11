import java.util.Scanner;

public class Lekcja2_zadanie1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Pobieranie danych od użytkownika
        System.out.print("Podaj pierwszą liczbę: ");
        int a = sc.nextInt();

        System.out.print("Podaj drugą liczbę: ");
        int b = sc.nextInt();

        System.out.print("Wybierz działanie (+, -, *, /): ");
        String op = sc.next();  // wczytanie znaku działania

        // Instrukcje warunkowe
        if (op.equals("+")) {
            System.out.println("Wynik: " + (a + b));
        } else if (op.equals("-")) {
            System.out.println("Wynik: " + (a - b));
        } else if (op.equals("*")) {
            System.out.println("Wynik: " + (a * b));
        } else if (op.equals("/")) {
            if (b != 0) {
                System.out.println("Wynik: " + (a / b));
            } else {
                System.out.println("Błąd: nie można dzielić przez 0!");
            }
        } else {
            System.out.println("Nieznane działanie: " + op);
        }

        sc.close(); // zamknięcie skanera
    }
}
