import java.io.*;

public class p7 {
    public static void main(String[] args) {
        try {
            // Próba otwarcia pliku, który może nie istnieć
            BufferedReader br = new BufferedReader(new FileReader("dane.txt"));
            System.out.println(br.readLine()); // odczyt pierwszej linii
            br.close();
        } catch (FileNotFoundException e) {
            // Jeśli plik nie istnieje
            System.out.println("Plik nie został znaleziony!");
        } catch (IOException e) {
            // Inne błędy wejścia/wyjścia
            System.out.println("Błąd odczytu pliku!");
        }
    }
}
