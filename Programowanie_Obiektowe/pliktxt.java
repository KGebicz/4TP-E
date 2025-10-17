// 🔹 Importujemy wszystkie niezbędne klasy
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.util.Scanner;

public class pliktxt {
    public static void main(String[] args) {
        // Ścieżka do pliku wejściowego
        String nazwaPliku = "dane.txt";

        // ============================
        // 1️⃣ ODCZYT PLIKU TEKSTOWEGO
        // ============================
        try {
            // Użyjemy BufferedReader do wydajnego odczytu linia po linii
            BufferedReader reader = new BufferedReader(new FileReader(nazwaPliku));
            String linia;
            int licznik = 0;

            System.out.println("=== ZAWARTOŚĆ PLIKU dane.txt ===");
            while ((linia = reader.readLine()) != null) {
                licznik++;
                System.out.println("Linia " + licznik + ": " + linia);
            }

            reader.close(); // Zawsze zamykamy plik po odczycie
            System.out.println("Liczba linii w pliku: " + licznik);
            System.out.println();

        } catch (IOException e) {
            System.out.println("Błąd: nie można odczytać pliku " + nazwaPliku);
            e.printStackTrace();
        }

        // ============================
        // 2️⃣ ZAPIS DANYCH DO NOWEGO PLIKU
        // ============================
        try {
            // Tworzymy nowy plik wynikowy
            BufferedWriter writer = new BufferedWriter(new FileWriter("wynik.txt"));

            // Zapisujemy kilka linijek tekstu
            writer.write("To jest plik wynikowy wygenerowany przez program Java.");
            writer.newLine(); // przejście do nowej linii
            writer.write("Druga linia tekstu w pliku.");
            writer.newLine();
            writer.write("Zapis zakończony pomyślnie!");

            writer.close(); // Zamykamy plik po zapisie

            System.out.println("Dane zostały zapisane w pliku wynik.txt");
            System.out.println();

        } catch (IOException e) {
            System.out.println("Błąd: nie można zapisać danych do pliku wynik.txt");
            e.printStackTrace();
        }

        // ============================
        // 3️⃣ ODCZYT PRZY POMOCY SCANNERA
        // ============================
        try {
            File plik = new File("wynik.txt");
            Scanner scanner = new Scanner(plik);

            System.out.println("=== ZAWARTOŚĆ PLIKU wynik.txt ===");
            while (scanner.hasNextLine()) {
                System.out.println(scanner.nextLine());
            }

            scanner.close();

        } catch (IOException e) {
            System.out.println("Błąd: problem z plikiem wynik.txt");
            e.printStackTrace();
        }
    }
}
