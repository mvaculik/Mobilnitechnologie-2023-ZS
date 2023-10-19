# Mobilnitechnologie-2023-ZS

1. Layout.xml:
Vytváří základní rozložení obrazovky s výše uvedenými prvky:
- Dva EditText pro zadání položky a počtu kusů
- Tlačítko "Přidat na seznam" (Button)
- RecyclerView, který bude zobrazovat seznam nákupních položek

  
2. MainActivity:
- Aktivita, která je propojena s layoutem activity_main.xml
- Inicializuje seznam shoppingList pro ukládání nákupních položek a adaptér ShoppingAdapter pro propojení RecyclerView s daty
  
V onCreate metodě:
- Nastavuje adaptér pro RecyclerView
- Nastavuje obsluhu události pro tlačítko "Přidat na seznam"
  
Při stisknutí tlačítka:
- získává texty z EditText polí (item a quantity)
  Pokud oba vstupy nejsou prázdné:
    - Vytváří novou položku nákupního seznamu (ShoppingItem) s názvem položky a počtem kusů
    - Přidává tuto položku do seznamu shoppingList
    - Aktualizuje adaptér, aby zobrazil novou položku
    - Vymazává textová pole item a quantity pro další vstupy

ShoppingItem:
- Jednoduchá datová třída pro reprezentaci nákupní položky. Obsahuje název (name) a počet kusů (quantity)

ShoppingAdapter (není zahrnut v kódu):
- Adaptér pro propojení seznamu nákupních položek (shoppingList) s RecyclerView
- Definuje způsob, jakým se položky seznamu budou zobrazovat v RecyclerView
