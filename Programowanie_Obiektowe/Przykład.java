// Plik: Osoba.java
class Osoba {
    // Enkapsulacja: prywatne pola
    private String imie;
    private int wiek;

    // Konstruktor z użyciem this
    public Osoba(String imie, int wiek) {
        this.imie = imie; // this rozróżnia pole od parametru
        this.wiek = wiek;
    }

    // Getter i Setter (enkapsulacja)
    public String getImie() {
        return imie;
    }

    public void setImie(String imie) {
        this.imie = imie; // Można dodać logikę walidacji
    }

    public int getWiek() {
        return wiek;
    }

    public void setWiek(int wiek) {
        if(wiek > 0) this.wiek = wiek; // logika walidacji
    }

    // Metoda do pokazania danych
    public void przedstawSie() {
        System.out.println("Cześć, mam na imię " + imie + " i mam " + wiek + " lat.");
    }
}

// Plik: Student.java
class Student extends Osoba {
    private String kierunek;

    public Student(String imie, int wiek, String kierunek) {
        super(imie, wiek); // odwołanie do konstruktora klasy bazowej
        this.kierunek = kierunek;
    }

    public String getKierunek() {
        return kierunek;
    }

    public void setKierunek(String kierunek) {
        this.kierunek = kierunek;
    }

    // Polimorfizm: nadpisujemy metodę klasy bazowej
    @Override
    public void przedstawSie() {
        System.out.println("Cześć, jestem studentem kierunku " + kierunek + 
                           " i mam na imię " + getImie());
    }
}

// Plik: Figura.java
abstract class Figura {
    // Abstrakcja: metoda bez implementacji
    public abstract double obliczPole();

    // Metoda z implementacją
    public void pokazPole() {
        System.out.println("Pole figury wynosi: " + obliczPole());
    }
}

// Plik: Kolo.java
class Kolo extends Figura {
    private double promien;

    public Kolo(double promien) {
        this.promien = promien;
    }

    @Override
    public double obliczPole() {
        return Math.PI * promien * promien;
    }
}

// Plik: Prostokat.java
class Prostokat extends Figura {
    private double szerokosc;
    private double wysokosc;

    public Prostokat(double szerokosc, double wysokosc) {
        this.szerokosc = szerokosc;
        this.wysokosc = wysokosc;
    }

    @Override
    public double obliczPole() {
        return szerokosc * wysokosc;
    }
}

// Plik: Porownywalny.java
interface Porownywalny {
    // INTERFEJS: wymusza implementację metody porownaj
    boolean porownaj(Object o);
}

// Plik: Punkt.java
class Punkt implements Porownywalny {
    private int x, y;

    public Punkt() {
        this(0, 0); // Wywołanie innego konstruktora
    }

    public Punkt(int x, int y) {
        this.x = x;
        this.y = y;
    }

    // Implementacja interfejsu
    @Override
    public boolean porownaj(Object o) {
        if(o instanceof Punkt) {
            Punkt inny = (Punkt) o;
            return this.x == inny.x && this.y == inny.y;
        }
        return false;
    }
}

// Plik: Zwierze.java
class Zwierze {
    // final w metodzie: nie można nadpisać w klasach dziedziczących
    public final void oddychaj() {
        System.out.println("Oddycham tlenem");
    }
}

// Plik: Matematyka.java
final class Matematyka {
    // final w klasie: klasa nie może być rozszerzana
    public static int dodaj(int a, int b) {
        return a + b;
    }
}

// Plik: Main.java
public class Main {
    public static void main(String[] args) {

        // Enkapsulacja i dziedziczenie
        Osoba osoba = new Osoba("Krzysztof", 25);
        osoba.przedstawSie();

        Student student = new Student("Anna", 22, "Informatyka");
        student.przedstawSie();

        // Polimorfizm
        Figura[] figury = { new Prostokat(3, 4), new Kolo(5) };
        for(Figura f : figury) {
            f.pokazPole(); // wywołuje odpowiednią metodę obliczPole()
        }

        // Interfejs i this
        Punkt p1 = new Punkt(2, 3);
        Punkt p2 = new Punkt(2, 3);
        System.out.println("Punkty są równe? " + p1.porownaj(p2));

        // final w metodzie
        Zwierze zw = new Zwierze();
        zw.oddychaj();

        // final w klasie i metodzie statycznej
        int wynik = Matematyka.dodaj(5, 7);
        System.out.println("Wynik dodawania: " + wynik);
    }
}
