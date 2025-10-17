// Importujemy potrzebne klasy z pakietów Javy
import java.io.*;
import java.util.*;

public class wyjatki {

    public static void main(String[] args) {

        /*
         ====================================================
         1️⃣ OBSŁUGA WYJĄTKÓW – try, catch, finally
         ====================================================
         Blok try – miejsce, w którym może wystąpić błąd.
         Blok catch – przechwytuje wyjątek i obsługuje go.
         Blok finally – wykona się zawsze, niezależnie od błędu.
        */

        try {
            int wynik = podziel(10, 0); // tu wystąpi błąd (dzielenie przez 0)
            System.out.println("Wynik: " + wynik);
        }
        catch (ArithmeticException e) {
            System.out.println("Błąd: nie można dzielić przez zero!");
            System.out.println("Opis błędu: " + e.getMessage());
        }
        finally {
            System.out.println("Blok finally: wykonuje się zawsze ✅");
        }


        /*
         ====================================================
         2️⃣ TABLICE
         ====================================================
         Tablica przechowuje elementy tego samego typu.
         Ma stały rozmiar i dostęp przez indeks (zaczynający się od 0).
        */
        int[] liczby = {1, 2, 3, 4, 5};

        System.out.println("\nTablica liczb:");
        for (int i = 0; i < liczby.length; i++) {
            System.out.println("Element " + i + ": " + liczby[i]);
        }

        liczby[2] = 99;
        System.out.println("Po zmianie: " + Arrays.toString(liczby));


        /*
         ====================================================
         3️⃣ ARRAYLIST – dynamiczna tablica
         ====================================================
         ArrayList to elastyczna kolekcja danych, której rozmiar może się zmieniać.
         Ma gotowe metody do dodawania i usuwania elementów.
        */
        ArrayList<String> imiona = new ArrayList<>();
        imiona.add("Kasia");
        imiona.add("Ola");
        imiona.add("Jan");
        imiona.remove("Ola"); // usunięcie elementu

        System.out.println("\nLista imion:");
        for (String imie : imiona) {
            System.out.println(imie);
        }

        System.out.println("Pierwsze imię: " + imiona.get(0));
        System.out.println("Liczba elementów: " + imiona.size());


        /*
         ====================================================
         4️⃣ THROW – samodzielne rzucenie wyjątku
         ====================================================
         'throw' używamy, gdy chcemy SAMI zgłosić błąd (np. niepoprawne dane).
        */
        try {
            ustawWiek(-5);  // próba ustawienia niepoprawnego wieku
        }
        catch (IllegalArgumentException e) {
            System.out.println("\nBłąd: " + e.getMessage());
        }


        /*
         ====================================================
         5️⃣ THROWS – deklaracja wyjątku w metodzie
         ====================================================
         'throws' informuje, że dana metoda MOŻE rzucić wyjątek.
         Dzięki temu osoba wywołująca metodę wie, że trzeba go obsłużyć.
        */
        try {
            odczytajPlik("nieistnieje.txt"); // pliku nie ma -> wyjątek
        }
        catch (IOException e) {
            System.out.println("\nBłąd pliku: " + e.getMessage());
        }

        System.out.println("\nKoniec programu ✅");
    }

    /*
     ====================================================
     METODA: podziel
     ====================================================
     Deklaracja "throws ArithmeticException" oznacza,
     że metoda MOŻE rzucić wyjątek tego typu.
     Osoba wywołująca musi go przechwycić (try/catch)
     lub dalej przekazać (throws w swojej metodzie).
    */
    static int podziel(int a, int b) throws ArithmeticException {
        return a / b;
    }

    /*
     ====================================================
     METODA: ustawWiek
     ====================================================
     Przykład użycia 'throw' – sami zgłaszamy wyjątek.
    */
    static void ustawWiek(int wiek) {
        if (wiek < 0) {
            // Rzucamy nowy wyjątek (obiekt IllegalArgumentException)
            throw new IllegalArgumentException("Wiek nie może być ujemny!");
        }
        System.out.println("Wiek ustawiony na: " + wiek);
    }

    /*
     ====================================================
     METODA: odczytajPlik
     ====================================================
     Przykład użycia 'throws' z wyjątkiem typu checked (IOException).
     Jeśli pliku nie ma – metoda "rzuca" wyjątek, który musi być obsłużony
     przez try/catch w metodzie main.
    */
    static void odczytajPlik(String nazwaPliku) throws IOException {
        FileReader fr = new FileReader(nazwaPliku); // może rzucić FileNotFoundException
        System.out.println("Plik został znaleziony!");
        fr.close();
    }
}
