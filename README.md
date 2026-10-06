# 4TP-E

from pathlib import Path

PLIK = Path("zakupy.txt")

# 1. Zapis - tworzymy listę od zera (tryb "w")=
with open(PLIK, "w", encoding="utf-8") as f:
    f.write("chleb\n")
    f.write("mleko\n")
    f.write("jajka\n")
print("Utworzono listę zakupów.")

# 2. Dopisywanie - dokładamy produkt na końcu (tryb "a")
with open(PLIK, "a", encoding="utf-8") as f:
    f.write("ser żółty\n")
print("Dopisano: ser żółty")

# 3. Odczyt linia po linii
print("\nTwoja lista zakupów:")
with open(PLIK, "r", encoding="utf-8") as f:
    for numer, produkt in enumerate(f, start=1):
        print(f"{numer}. {produkt.strip()}")
