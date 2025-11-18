import java.io.*;
import java.util.Scanner;

public class p5 {

    // Metoda, która może zgłosić wyjątek wejścia/wyjścia
    public static int odczytajLiczbęZPliku(String nazwaPliku) throws IOException {
        // throws oznacza, że metoda może wyrzucić wyjątek i nie obsługuje go sama
        Scanner sc = new Scanner(new File(nazwaPliku)); // próba otwarcia pliku
        int liczba = sc.nextInt(); // odczyt liczby
        sc.close();
        return liczba;
    }

    public static void main(String[] args) {
        try {
            // Próba odczytania liczby z pliku
            int x = odczytajLiczbęZPliku("liczba.txt");
            System.out.println("Odczytano: " + x);
        } catch (IOException e) {
            // Obsługa błędu otwarcia/odczytu pliku
            System.out.println("Błąd odczytu pliku: " + e.getMessage());
        }
    }
}
