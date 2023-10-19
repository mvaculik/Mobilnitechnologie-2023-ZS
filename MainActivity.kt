import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    private val shoppingList = ArrayList<ShoppingItem>()
    private lateinit var adapter: ShoppingAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        adapter = ShoppingAdapter(shoppingList)
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = adapter

        addButton.setOnClickListener {
            val item = editTextItem.text.toString()
            val quantity = editTextQuantity.text.toString()
            if (item.isNotEmpty() && quantity.isNotEmpty()) {
                val shoppingItem = ShoppingItem(item, quantity.toInt())
                shoppingList.add(shoppingItem)
                adapter.notifyDataSetChanged()
                // Clear input fields
                editTextItem.text.clear()
                editTextQuantity.text.clear()
            }
        }
    }
}

data class ShoppingItem(val name: String, val quantity: Int)
