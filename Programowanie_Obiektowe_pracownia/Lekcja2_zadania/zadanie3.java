package Lekcja2_zadania;
import java.util.Random;
import java.util.Scanner;

public class zadanie3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Random rand = new Random();

        System.out.print("Ile liczb wylosować? ");
        int n = sc.nextInt();

        int sumEven = 0;
        int sumOdd = 0;

        System.out.print("Wylosowane liczby: ");
        for (int i = 0; i < n; i++) {
            int number = rand.nextInt(10) + 1; System.out.print(number + " ");

            if (number % 2 == 0) {
                sumEven += number;
            } else {
                sumOdd += number;
            }
        }

        System.out.println();
        System.out.println("Suma parzystych = " + sumEven);
        System.out.println("Suma nieparzystych = " + sumOdd);

        sc.close();
    }
}