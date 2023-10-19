import android.os.Bundle // Importuje třídu Bundle z balíčku android.os, který se používá k předávání dat mezi různými částmi aplikace, například mezi aktivitami
import androidx.appcompat.app.AppCompatActivity // Základní třída pro vytvoření aktivity v Android aplikaci. Aktivity jsou obrazovky, které tvoří uživatelské rozhraní aplikace (prostě frontend)
import androidx.recyclerview.widget.LinearLayoutManager // LinearLayoutManager se používá k definici způsobu, jakým budou položky zobrazovány v RecyclerView v lineárním seznamu
import kotlinx.android.synthetic.main.activity_main.* // Syntetické je pro vytváření odkazů na prvky uživatelského rozhraní z XML layoutu aktivity activity_main.xml. To umožňuje přistupovat k prvkům layoutu přímo v kódu..

class MainActivity : AppCompatActivity() { // Toto je deklarace třídy MainActivity, která je odvozena od třídy AppCompatActivity, a to znamená že MainActivity je hlavní aktivitou aplikace
    private val shoppingList = ArrayList<ShoppingItem>() // Vytváří privátní proměnnou shoppingList typu ArrayList<ShoppingItem>, která bude sloužit k ukládání nákupních položek a ArrayList je dynamický seznam pro ukládání dat
    private lateinit var adapter: ShoppingAdapter // Vytváří privátní proměnnou adapter typu ShoppingAdapter, která bude sloužit k propojení seznamu shoppingList s RecyclerView. Proměnná je označena jako lateinit a to znamená, že její inicializace proběhne pozděj

    override fun onCreate(savedInstanceState: Bundle?) { // Metoda onCreate se volá při vytvoření instance aktivity. Uvnitř této metody se inicializují různé komponenty a nastavují listener událostí..
        super.onCreate(savedInstanceState) // Volá metodu onCreate nadřazené třídy, což je AppCompatActivity. Tím se zajistí, že předchozí inicializační kód nadřazené třídy bude proveden
        setContentView(R.layout.activity_main) // Nastaví obsah aktivity na layout definovaný v souboru activity_main.xml

        adapter = ShoppingAdapter(shoppingList) // Inicializuje adaptér proměnou adapter s daty ze seznamu shoppingList
        recyclerView.layoutManager = LinearLayoutManager(this) // Nastaví layout manager pro RecyclerView, což je LinearLayoutManager. To určuje, jak budou položky seznamu zobrazeny (v lineárním seznamu)
        recyclerView.adapter = adapter // Nastaví adaptér pro RecyclerView, což spojí seznam s RecyclerView pro zobrazení dat

        addButton.setOnClickListener { // 
            val item = editTextItem.text.toString()
            val quantity = editTextQuantity.text.toString()
            if (item.isNotEmpty() && quantity.isNotEmpty()) {
                val shoppingItem = ShoppingItem(item, quantity.toInt()) // Vytvoří se nový objekt ShoppingItem
                shoppingList.add(shoppingItem) // Přidá se do seznamu shoppingList
                adapter.notifyDataSetChanged() // Poté se aktualizuje adaptér a vstupní pole se vymažou
                // Clear input fields
                editTextItem.text.clear()
                editTextQuantity.text.clear()
            }
        }
    }
}

data class ShoppingItem(val name: String, val quantity: Int) // Toto je datová třída ShoppingItem, která slouží k reprezentaci nákupní položky. Obsahuje dva parametry: name (název) a quantity (počet kusů)
// Proč? Data třídy je použita k uchování informací o nákupních položkách.. 
