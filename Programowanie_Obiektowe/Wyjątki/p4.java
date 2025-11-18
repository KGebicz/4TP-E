public class p4 {

    // Metoda sprawdzająca wiek użytkownika
    public static void sprawdzWiek(int wiek) {
        // Jeśli wiek mniejszy niż 18, ręcznie wyrzucamy wyjątek
        if (wiek < 18) {
            throw new IllegalArgumentException("Wiek musi być >= 18!");
        }
        System.out.println("Dostęp przyznany.");
    }

    public static void main(String[] args) {
        try {
            // Wywołanie metody z niepoprawną wartością
            sprawdzWiek(15);
        } catch (IllegalArgumentException e) {
            // Obsługa wyjątku rzuconego przez metodę
            System.out.println("Błąd: " + e.getMessage());
        }
    }
}
