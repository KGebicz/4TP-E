package Lekcja2_zadania;
import java.util.Scanner;

public class zadanie5 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        System.out.print("Podaj liczbę: ");
        int n = sc.nextInt();
        
        int suma = n * (n + 1) / 2;
        
        System.out.println("Suma liczb od 1 do " + n + " = " + suma);
        
        sc.close();
    }
}