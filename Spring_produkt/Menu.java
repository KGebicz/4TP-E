//package com.example.demo;
//import org.springframework.boot.CommandLineRunner;
//import org.springframework.core.annotation.Order;
//import org.springframework.stereotype.Component;
//
//import java.math.BigDecimal;
//import java.util.List;
//import java.util.Scanner;
//
///**
// * MENU W KONSOLI - prosta aplikacja tekstowa dzialajaca obok serwera WWW.
// * (Caly plik jest zakomentowany, wiec obecnie sie nie uruchamia.
// * Aby go wlaczyc, usun znaki // z poczatku kazdej linii.)
// *
// * @Component - Spring sam tworzy obiekt tej klasy przy starcie.
// * CommandLineRunner - interfejs: Spring po uruchomieniu aplikacji
// *                     automatycznie wywola metode run().
// * @Order(2) - kolejnosc, gdy jest kilka takich klas (mniejsza liczba
// *             = uruchamia sie wczesniej).
// */
//@Component
//@Order(2)
//public class Menu implements CommandLineRunner {
//
//    // Repozytorium - nasz dostep do bazy danych
//    private final ProduktRepository repository;
//
//    // Spring sam wstrzykuje repozytorium (dependency injection)
//    public Menu(ProduktRepository repository) {
//        this.repository = repository;
//    }
//
//    // Ta metoda wykonuje sie automatycznie po starcie aplikacji
//    @Override
//    public void run(String... args) {
//        // Scanner - odczyt tekstu wpisywanego przez uzytkownika w konsoli
//        Scanner scanner = new Scanner(System.in);
//        boolean dziala = true;
//
//        // Petla wyswietla menu, dopoki uzytkownik nie wybierze 0
//        while (dziala) {
//            System.out.println();
//            System.out.println("===== MENU =====");
//            System.out.println("1 - dopisz produkt");
//            System.out.println("2 - wyswietl produkty");
//            System.out.println("3 - usun produkt");
//            System.out.println("0 - zakoncz menu");
//            System.out.print("Wybierz opcje: ");
//
//            // trim() usuwa zbedne spacje z poczatku i konca
//            String wybor = scanner.nextLine().trim();
//
//            // Nowoczesny switch ze strzalkami: kazda opcja wywoluje swoja metode
//            switch (wybor) {
//                case "1" -> dopiszProdukt(scanner);
//                case "2" -> wyswietlProdukty();
//                case "3" -> usunProdukt(scanner);
//                case "0" -> dziala = false; // konczy petle
//                default -> System.out.println("Nieznana opcja, sprobuj ponownie.");
//            }
//        }
//        System.out.println("Menu zakonczone. Serwer WWW nadal dziala (Ctrl+C aby wylaczyc).");
//    }
//
//    // Opcja 1: pobiera dane od uzytkownika i zapisuje nowy produkt w bazie
//    private void dopiszProdukt(Scanner scanner) {
//        System.out.print("Podaj nazwe: ");
//        String nazwa = scanner.nextLine().trim();
//        System.out.print("Podaj cene: ");
//        // replace zamienia przecinek na kropke, bo BigDecimal rozumie tylko "4.50"
//        String cenaTekst = scanner.nextLine().trim().replace(',', '.');
//        System.out.print("Podaj ilosc: ");
//        String iloscTekst = scanner.nextLine().trim();
//
//        // Walidacja 1: nazwa nie moze byc pusta
//        if (nazwa.isEmpty()) {
//            System.out.println("Nazwa nie moze byc pusta.");
//            return; // wychodzimy z metody bez zapisu
//        }
//
//        // Walidacja 2: zamiana tekstu na liczby.
//        // Jesli uzytkownik wpisze litery, poleci NumberFormatException -
//        // lapiemy ja w try/catch, zeby program sie nie wywrocil.
//        BigDecimal cena;
//        int ilosc;
//        try {
//            cena = new BigDecimal(cenaTekst);
//            ilosc = Integer.parseInt(iloscTekst);
//        } catch (NumberFormatException e) {
//            System.out.println("Cena i ilosc musza byc liczbami.");
//            return;
//        }
//
//        // Walidacja 3: signum() zwraca -1 dla liczby ujemnej
//        if (cena.signum() < 0 || ilosc < 0) {
//            System.out.println("Cena i ilosc nie moga byc ujemne.");
//            return;
//        }
//
//        // Tworzymy obiekt, ustawiamy pola i zapisujemy w bazie (INSERT).
//        // Id nadaje baza sama.
//        Produkt produkt = new Produkt();
//        produkt.setNazwa(nazwa);
//        produkt.setCena(cena);
//        produkt.setIlosc(ilosc);
//        repository.save(produkt);
//
//        System.out.println("Zapisano: " + nazwa + ", " + cena + " zl, " + ilosc + " szt.");
//    }
//
//    // Opcja 2: pobiera wszystkie produkty z bazy i wypisuje je jako tabelke
//    private void wyswietlProdukty() {
//        List<Produkt> produkty = repository.findAll(); // SELECT z bazy
//
//        if (produkty.isEmpty()) {
//            System.out.println("Tabela jest pusta.");
//            return;
//        }
//
//        System.out.println("--- Produkty w bazie ---");
//        // printf formatuje kolumny: %-20s = tekst do lewej (20 znakow),
//        // %10s = tekst do prawej, %-4d = liczba calkowita, %n = nowa linia
//        System.out.printf("%-4s %-20s %10s %6s%n", "id", "nazwa", "cena", "ilosc");
//        for (Produkt p : produkty) {
//            System.out.printf("%-4d %-20s %10s %6d%n",
//                    p.getId(), p.getNazwa(), p.getCena(), p.getIlosc());
//        }
//    }
//
//    // Opcja 3: usuwa produkt o podanym id
//    private void usunProdukt(Scanner scanner) {
//        System.out.print("Podaj id produktu do usuniecia: ");
//        String idTekst = scanner.nextLine().trim();
//
//        long id;
//        try {
//            id = Long.parseLong(idTekst);
//        } catch (NumberFormatException e) {
//            System.out.println("Id musi byc liczba.");
//            return;
//        }
//
//        // Najpierw sprawdzamy, czy taki produkt w ogole istnieje
//        if (!repository.existsById(id)) {
//            System.out.println("Nie ma produktu o id " + id + ".");
//            return;
//        }
//
//        repository.deleteById(id); // DELETE z bazy
//        System.out.println("Usunieto produkt o id " + id + ".");
//    }
//}
