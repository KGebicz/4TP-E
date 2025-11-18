import java.util.Scanner;

public class p1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in); // obiekt do wczytywania danych z klawiatury
        System.out.print("Podaj liczbę: ");
        int liczba = sc.nextInt(); // wczytanie liczby całkowitej od użytkownika

        try {
            // Kod, który może spowodować wyjątek
            int wynik = 100 / liczba; // jeśli liczba = 0, powstanie wyjątek ArithmeticException
            System.out.println("Wynik: " + wynik);
        } catch (ArithmeticException e) {
            // Blok wykonany, jeśli w try wystąpi błąd dzielenia przez zero
            System.out.println("Błąd: nie można dzielić przez zero!");
        } finally {
            // Blok wykonywany zawsze – nawet jeśli wystąpił wyjątek
            System.out.println("Operacja zakończona.");
        }
        sc.close();
    }
}
