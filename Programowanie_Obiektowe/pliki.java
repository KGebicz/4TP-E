// 🔹 Importujemy wszystkie niezbędne klasy z biblioteki Gson
// Gson - główna klasa do konwersji JSON ↔ obiekt Java
// FileReader, FileWriter - do obsługi plików tekstowych
import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

// 🔹 Tworzymy klasę odpowiadającą strukturze danych w pliku JSON
// Pola muszą mieć takie same nazwy jak klucze w JSON
class Uczen {
    String imie;
    int wiek;
    String[] przedmioty;
}

public class pliki {
    public static void main(String[] args) {

        // 🔹 Tworzymy obiekt Gson – główne narzędzie do pracy z JSON
        Gson gson = new Gson();

        try {
            // =======================
            // 1️⃣ ODCZYT Z PLIKU JSON
            // =======================

            // Otwieramy plik JSON zawierający dane ucznia
            FileReader reader = new FileReader("uczen.json");

            // Zamieniamy zawartość pliku JSON na obiekt klasy Uczen
            // gson.fromJson() analizuje plik i automatycznie przypisuje wartości do pól
            Uczen uczen = gson.fromJson(reader, Uczen.class);

            // Zamykamy plik po odczycie (to bardzo ważne)
            reader.close();

            // Wyświetlamy dane odczytane z pliku
            System.out.println("=== DANE UCZNIA Z PLIKU ===");
            System.out.println("Imię: " + uczen.imie);
            System.out.println("Wiek: " + uczen.wiek);
            System.out.print("Przedmioty: ");
            for (String p : uczen.przedmioty) {
                System.out.print(p + " ");
            }
            System.out.println("\n");

            // =======================
            // 2️⃣ ZAPIS DO NOWEGO PLIKU JSON
            // =======================

            // Tworzymy nowy obiekt ucznia z innymi danymi
            Uczen nowy = new Uczen();
            nowy.imie = "Tomek";
            nowy.wiek = 17;
            nowy.przedmioty = new String[]{"Fizyka", "Java", "Angielski"};

            // Otwieramy nowy plik, do którego zapiszemy dane
            FileWriter writer = new FileWriter("nowy_uczen.json");

            // gson.toJson() przekształca obiekt Java w tekst JSON i zapisuje do pliku
            gson.toJson(nowy, writer);

            // Zamykamy plik po zapisie
            writer.close();

            System.out.println("Nowy plik JSON został zapisany jako nowy_uczen.json");

        } catch (IOException e) {
            // Obsługa błędu, gdy plik nie istnieje lub nie można go otworzyć
            System.out.println("Błąd: problem z odczytem lub zapisem pliku!");
            e.printStackTrace();
        } catch (JsonSyntaxException e) {
            // Obsługa błędu, jeśli JSON ma złą składnię
            System.out.println("Błąd składni JSON!");
            e.printStackTrace();
        }
    }
}
