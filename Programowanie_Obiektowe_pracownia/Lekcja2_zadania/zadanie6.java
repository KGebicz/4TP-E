package Lekcja2_zadania;
import java.util.Scanner;

public class zadanie6 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Podaj liczbę: ");
        int n = sc.nextInt();

        System.out.print("Liczby pierwsze od 2 do " + n + ": ");

        for (int i = 2; i <= n; i++) {
            boolean pierwsza = true;
            for (int j = 2; j * j <= i; j++) {
                if (i % j == 0) {
                    pierwsza = false;
                    break;
                }
            }
            if (pierwsza) {
                System.out.print(i + " ");
            }
        }
        sc.close();
    }
}
