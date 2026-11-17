package com.example.demo;

import org.springframework.data.jpa.repository.JpaRepository;
import java.math.BigDecimal;
import java.util.List;

/**
 * REPOZYTORIUM - warstwa dostepu do bazy danych.
 *
 * To jest tylko INTERFEJS - nie piszemy tu zadnej implementacji!
 * Spring Data JPA sam wygeneruje klase, ktora wykonuje zapytania SQL.
 *
 * JpaRepository<Produkt, Long> oznacza:
 *   Produkt - na jakiej encji (tabeli) pracujemy
 *   Long    - jakiego typu jest klucz glowny (pole id)
 *
 * Za darmo dostajemy gotowe metody, m.in.:
 *   findAll()      - SELECT * (wszystkie produkty)
 *   findById(id)   - szukanie po id (zwraca Optional)
 *   save(obiekt)   - INSERT (nowy) lub UPDATE (istniejacy)
 *   deleteById(id) - DELETE
 *   existsById(id) - czy istnieje rekord o takim id
 *   count()        - ile jest rekordow
 */
public interface ProduktRepository extends JpaRepository<Produkt, Long> {

    // WLASNE ZAPYTANIE tworzone z nazwy metody!
    // Spring czyta nazwe: findBy + Cena + LessThan
    // i sam buduje SQL: SELECT * FROM produkt WHERE cena < ?
    // Wazne: "Cena" musi byc nazwa pola z klasy Produkt.
    List<Produkt> findByCenaLessThan(BigDecimal cena);
}
