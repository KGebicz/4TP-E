class Pojazd {

    void jedz() {
        System.out.println("Pojazd porusza się");
    }
}

class Samochod extends Pojazd {

    @Override
    void jedz() {
        System.out.println("Samochód jedzie po drodze");
    }
}

class Rower extends Pojazd {

    @Override
    void jedz() {
        System.out.println("Rower jedzie ścieżką rowerową");
    }
}

class Motocykl extends Pojazd {

    @Override
    void jedz() {
        System.out.println("Motocykl jedzie szybko");
    }
}

public class Main {

    public static void main(String[] args) {

        Pojazd p1 = new Samochod();
        Pojazd p2 = new Rower();
        Pojazd p3 = new Motocykl();

        p1.jedz();
        p2.jedz();
        p3.jedz();

        System.out.println("-----");

        Pojazd[] pojazdy = {
            new Samochod(),
            new Rower(),
            new Motocykl()
        };

        for (Pojazd p : pojazdy) {
            p.jedz();
        }
    }
}
