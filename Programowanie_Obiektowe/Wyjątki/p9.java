class BankAccount {
    private double saldo; // stan konta

    public BankAccount(double saldo) {
        this.saldo = saldo;
    }

    // Metoda wypłacająca pieniądze
    public void withdraw(double amount) {
        // Jeśli na koncie za mało pieniędzy, rzuć wyjątek
        if (amount > saldo) {
            throw new IllegalArgumentException("Za mało środków!");
        }
        saldo -= amount;
        System.out.println("Wypłacono: " + amount);
    }
}

public class p9 {
    public static void main(String[] args) {
        BankAccount konto = new BankAccount(100);

        try {
            // Próba wypłaty większej kwoty niż dostępna
            konto.withdraw(200);
        } catch (IllegalArgumentException e) {
            // Obsługa wyjątku — komunikat dla użytkownika
            System.out.println("Operacja nieudana: " + e.getMessage());
        }
    }
}
