package Cw_CMO_cz1.Magazyn;
import java.util.ArrayList;
public class Magazyn {
    private ArrayList<Produkt> produkty;
    
    public Magazyn() {
        produkty = new ArrayList<>();
    }
    
    public void dodajProdukt(Produkt p) {
        produkty.add(p);
    }
    
    public Produkt znajdzProdukt(String nazwa) {
        for (Produkt p : produkty) {
            if (p.getNazwa().equals(nazwa)) {
                return p;
            }
        }
        return null;
    }
    
    public double wartoscMagazynu() {
        double suma = 0;
        for (Produkt p : produkty) {
            suma += p.getCena() * p.getIlosc();
        }
        return suma;
    }
}
