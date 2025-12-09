public class Main { // Deklaracja klasy Main
    public static void main(String[] args) { // Główna metoda programu
        int[][] array2D = { // Deklaracja i inicjalizacja tablicy 2D typu int
            {1, 2, 3},      // Pierwszy wiersz tablicy
            {4, 5},         // Drugi wiersz tablicy (krótszy)
            {6, 7, 8, 9}    // Trzeci wiersz tablicy (dłuższy)
        };

        int size = 0; // Zmienna do przechowywania całkowitej liczby elementów w tablicy 2D
        for (int[] row : array2D) { // Iteracja przez każdy wiersz tablicy 2D
            size += row.length; // Dodanie długości aktualnego wiersza do łącznego rozmiaru
        }

        int[] flat = flatten(array2D, size); // Wywołanie metody flatten — spłaszczenie tablicy 2D do 1D

        for (int num : flat) { // Iteracja po elementach spłaszczonej tablicy 1D
            System.out.print(num + " "); // Wypisanie elementu na ekran
        }
    }

    public static int[] flatten(int[][] array, int size) { // Metoda spłaszczająca tablicę 2D do 1D
        int[] result = new int[size]; // Utworzenie tablicy 1D o obliczonym rozmiarze
        int index = 0; // Zmienna wskazująca aktualny indeks w tablicy wynikowej
         
        for (int[] row : array) { // Iteracja przez każdy wiersz tablicy 2D
            for (int value : row) { // Iteracja przez każdy element w danym wierszu
                result[index++] = value; // Przypisanie elementu do tablicy 1D i inkrementacja indeksu
            }
        }
        return result; // Zwrócenie spłaszczonej tablicy 1D
    }
}
