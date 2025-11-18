public class p6 {
    public static int podziel(int a, int b) {
        // Jeśli b == 0, ręcznie zgłaszamy wyjątek
        if (b == 0) {
            throw new ArithmeticException("Dzielenie przez zero!");
        }
        return a / b;
    }

    public static void main(String[] args) {
        try {
            System.out.println(podziel(10, 0)); // wywoła wyjątek
        } catch (ArithmeticException e) {
            System.out.println("Błąd: " + e.getMessage());
        }
    }
}
