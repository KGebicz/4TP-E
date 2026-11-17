package com.example.demo;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import java.math.BigDecimal;
import java.util.List;

/**
 * KONTROLER REST - obsluguje zapytania HTTP z przegladarki lub Postmana.
 *
 * @RestController - klasa odbiera zapytania HTTP, a zwracane obiekty
 *                   Spring automatycznie zamienia na JSON.
 * @RequestMapping("/produkty") - wszystkie adresy w tej klasie
 *                   zaczynaja sie od /produkty
 *                   (np. http://localhost:8080/produkty).
 */
@RestController
@RequestMapping("/produkty")
public class ProduktController {

    // Kontroler nie rozmawia z baza sam - robi to repozytorium
    private final ProduktRepository repository;

    // WSTRZYKIWANIE ZALEZNOSCI (dependency injection):
    // Spring sam tworzy repozytorium i przekazuje je do konstruktora.
    // My nigdy nie piszemy "new ProduktRepository()".
    public ProduktController(ProduktRepository repository) {
        this.repository = repository;
    }

    // GET /produkty  ->  lista wszystkich produktow (JSON)
    @GetMapping
    public List<Produkt> wszystkie() {
        return repository.findAll();
    }

    // GET /produkty/5  ->  produkt o id = 5
    // @PathVariable - bierze wartosc {id} z adresu URL.
    // findById zwraca Optional (produkt moze nie istniec),
    // wiec gdy go nie ma, zwracamy blad HTTP 404 (Not Found).
    @GetMapping("/{id}")
    public Produkt jeden(@PathVariable Long id) {
        return repository.findById(id).orElseThrow(
                () -> new ResponseStatusException(HttpStatus.NOT_FOUND));
    }

    // POST /produkty  ->  dodaje nowy produkt
    // @RequestBody - Spring zamienia JSON wyslany w zapytaniu na obiekt
    // Produkt, np.: {"nazwa":"Chleb","cena":4.50,"ilosc":10}
    // save() zapisuje w bazie i zwraca zapisany produkt (juz z id).
    @PostMapping
    public Produkt dodaj(@RequestBody Produkt produkt) {
        return repository.save(produkt);
    }

    // DELETE /produkty/5  ->  usuwa produkt o id = 5
    @DeleteMapping("/{id}")
    public void usun(@PathVariable Long id) {
        repository.deleteById(id);
    }

    // GET /produkty/tansze?cena=10  ->  produkty tansze niz 10 zl
    // @RequestParam - bierze wartosc z parametru w adresie (?cena=...).
    // Uzywa naszej wlasnej metody z repozytorium.
    // (Sciezka to "tansze" - bez polskich znakow, bo w adresach URL
    // lepiej ich unikac.)
    @GetMapping("/tansze")
    public List<Produkt> tansze(@RequestParam BigDecimal cena) {
        return repository.findByCenaLessThan(cena);
    }

    // GET /produkty/liczba  ->  ile produktow jest w bazie
    @GetMapping("/liczba")
    public long liczba() {
        return repository.count();
    }
}
