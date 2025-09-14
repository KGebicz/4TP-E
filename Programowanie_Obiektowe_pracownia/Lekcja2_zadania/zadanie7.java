package Lekcja2_zadania;
import java.util.Random;
import java.util.Scanner;

public class zadanie7 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Random rand = new Random();
        System.out.print("Ile liczb wylosować? ");
        int n = sc.nextInt();

        int[] liczby = new int[n];
        int suma = 0;

        System.out.print("Wylosowane liczby: ");
        for (int i = 0; i < n; i++) {
            liczby[i] = rand.nextInt(100) + 1;
            System.out.print(liczby[i] + " ");
            suma += liczby[i];
        }
        System.out.println();

        int min = liczby[0];
        int max = liczby[0];

        for (int i = 1; i < n; i++) {
            if (liczby[i] < min) {
                min = liczby[i];
            }
            if (liczby[i] > max) {
                max = liczby[i];
            }
        }

        System.out.println("Najmniejsza liczba = " + min);
        System.out.println("Największa liczba = " + max);
        System.out.println("Suma liczb = " + suma);

        sc.close();
    }
}