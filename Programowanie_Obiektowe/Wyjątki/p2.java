public class p2 {
    public static void main(String[] args) {
        int[] tablica = {1, 2, 3, 4, 5}; // tablica 5-elementowa

        try {
            // Próba odwołania do nieistniejącego indeksu
            System.out.println(tablica[10]);
        } catch (ArrayIndexOutOfBoundsException e) {
            // Złapanie błędu i wyświetlenie informacji
            System.out.println("Błąd: indeks poza zakresem tablicy!");
        }
    }
}
