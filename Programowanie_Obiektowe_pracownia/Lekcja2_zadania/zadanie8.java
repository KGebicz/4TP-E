package Lekcja2_zadania;
import java.util.Random;
import java.util.Scanner;

public class zadanie8 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random rand = new Random();

        System.out.print("Ile liczb wylosować? ");
        int n = scanner.nextInt();

        int[] liczby = new int[n];
        int suma = 0;

        System.out.print("Wylosowane liczby: ");
        for (int i = 0; i < n; i++) {
            liczby[i] = rand.nextInt(50) + 1;
            System.out.print(liczby[i] + " ");
            suma += liczby[i];
        }

        double srednia = (double) suma / n;
        System.out.printf("\nŚrednia = %.3f", srednia);

        System.out.print("\nLiczby większe od średniej: ");
        for (int liczba : liczby) { // Użycie pętli for-each, bierzec każdą liczbę z tablicy i porównuje ze średnią literuje jej elementy i sprawdza czy są większe od średniej
            if (liczba > srednia) {
                System.out.print(liczba + " ");
            }
        }
        scanner.close();
    }
}
