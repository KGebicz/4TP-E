import java.io.*;

public class p8 {
    public static void main(String[] args) {
        BufferedReader br = null; // obiekt do odczytu
        BufferedWriter bw = null; // obiekt do zapisu

        try {
            // Otwarcie pliku źródłowego i docelowego
            br = new BufferedReader(new FileReader("tekst.txt"));
            bw = new BufferedWriter(new FileWriter("kopia.txt"));

            String linia;
            // Odczyt każdej linii i zapis do drugiego pliku
            while ((linia = br.readLine()) != null) {
                bw.write(linia);
                bw.newLine(); // dodanie znaku końca linii
            }
            System.out.println("Kopiowanie zakończone sukcesem.");
        } catch (IOException e) {
            // Obsługa błędów plikowych
            System.out.println("Błąd podczas operacji na plikach!");
        } finally {
            // Zamknięcie plików niezależnie od błędów
            try {
                if (br != null) br.close();
                if (bw != null) bw.close();
            } catch (IOException e) {
                System.out.println("Błąd przy zamykaniu plików!");
            }
        }
    }
}
