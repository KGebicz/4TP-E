import java.io.*;

// Definicja własnego wyjątku
class NiepoprawneHasloException extends Exception {
    public NiepoprawneHasloException(String haslo) {
        super("Niepoprawne hasło: " + haslo);
    }
}

public class p10 {

    // Metoda, która sprawdza poprawność hasła i może rzucać wyjątek
    public static void sprawdzHaslo(String haslo) throws NiepoprawneHasloException {
        if (haslo.length() < 8) {
            // Jeśli hasło zbyt krótkie — rzucamy własny wyjątek
            throw new NiepoprawneHasloException(haslo);
        }
    }

    public static void main(String[] args) {
        // Konstrukcja try-with-resources automatycznie zamyka plik po użyciu
        try (BufferedReader br = new BufferedReader(new FileReader("hasla.txt"))) {
            String linia;
            // Czytamy każdą linię z pliku
            while ((linia = br.readLine()) != null) {
                try {
                    // Sprawdzamy długość hasła
                    sprawdzHaslo(linia);
                    System.out.println("Hasło poprawne: " + linia);
                } catch (NiepoprawneHasloException e) {
                    // Obsługa wyjątku własnego typu
                    System.out.println(e.getMessage());
                }
            }
        } catch (IOException e) {
            // Obsługa błędów odczytu pliku
            System.out.println("Błąd odczytu pliku!");
        }
    }
}
