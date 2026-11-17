package com.example.demo;

import jakarta.persistence.*;
import java.math.BigDecimal;

/**
 * Klasa ENCJI (Entity) - opisuje jeden produkt.
 *
 * @Entity mowi Hibernate: "ta klasa odpowiada tabeli w bazie danych".
 * Hibernate sam utworzy tabele "produkt" (dzieki ddl-auto=update),
 * a kazdy obiekt tej klasy to jeden wiersz w tabeli.
 */
@Entity
public class Produkt {

    // @Id - to pole jest kluczem glownym (unikalny identyfikator wiersza)
    @Id
    // @GeneratedValue - id nadaje baza automatycznie (AUTO_INCREMENT w MySQL),
    // wiec przy dodawaniu produktu nie podajemy id sami
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // Kazde z ponizszych pol staje sie kolumna w tabeli
    // (nazwa pola = nazwa kolumny)
    private String nazwa;

    // BigDecimal - dokladny typ do pieniedzy (double daje bledy zaokraglen)
    private BigDecimal cena;

    // int - liczba sztuk na stanie
    private int ilosc;

    // --- Gettery i settery ---
    // Hibernate i Spring (zamiana obiektu na JSON) uzywaja ich do
    // odczytu i zapisu pol, bo pola sa private.

    // Id ma tylko getter - nie ustawiamy go recznie, robi to baza
    public Long getId() { return id; }

    public String getNazwa() { return nazwa; }
    public void setNazwa(String nazwa) { this.nazwa = nazwa; }

    public BigDecimal getCena() { return cena; }
    public void setCena(BigDecimal cena) { this.cena = cena; }

    public int getIlosc() { return ilosc; }
    public void setIlosc(int ilosc) { this.ilosc = ilosc; }
}
