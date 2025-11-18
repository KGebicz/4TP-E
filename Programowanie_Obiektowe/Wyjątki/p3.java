public class p3 {
    public static void main(String[] args) {
        String tekst = "abc"; // tekst, którego nie da się zamienić na liczbę

        try {
            // Próba konwersji tekstu na liczbę całkowitą
            int liczba = Integer.parseInt(tekst);
            System.out.println("Liczba: " + liczba);
        } catch (NumberFormatException e) {
            // Wyjątek, gdy tekst nie jest poprawną liczbą
            System.out.println("Błąd: nie można zamienić tekstu na liczbę!");
        } finally {
            // Zawsze się wykona
            System.out.println("Operacja zakończona.");
        }
    }
}
