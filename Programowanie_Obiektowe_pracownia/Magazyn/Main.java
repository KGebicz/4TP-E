package Cw_CMO_cz1.Magazyn;

public class Main {
    public static void main(String[] args) {
        try {
            Produkt p1 = new Produkt("Laptop", 3000, 10);
            Produkt p2 = new Produkt("Mysz", 50, 20);
            
            Magazyn m = new Magazyn();
            
            m.dodajProdukt(p1);
            m.dodajProdukt(p2);
            
            System.out.println("Wartość magazynu: " + m.wartoscMagazynu() + " zł");
            
            p1.sprzedaj(2);
            System.out.println("Po sprzedaży 2 laptopów: " + p1.getIlosc() + " sztuk");
            
            try {
                p1.sprzedaj(20);
            } catch (IllegalArgumentException e) {
                System.out.println("Błąd sprzedaży: " + e.getMessage());
            }
            
            Produkt znaleziony = m.znajdzProdukt("Mysz");
            if (znaleziony != null) {
                System.out.println("Znaleziono: " + znaleziony.getNazwa() + ", cena: " + znaleziony.getCena());
            }
            
        } catch (IllegalArgumentException e) {
            System.out.println("Błąd: " + e.getMessage());
        }
    }
}