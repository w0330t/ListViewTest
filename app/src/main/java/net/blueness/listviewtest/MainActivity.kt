package net.blueness.listviewtest

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.widget.ListView
import org.jetbrains.anko.find
import org.jetbrains.anko.toast

class MainActivity : AppCompatActivity() {

//    private val data = arrayOf(
//            "Apple", "Banana", "Orange", "Watermelon", "Pear", "Grape", "Pineapple", "Strawberry", "Cherry", "Mango",
//            "Apple", "Banana", "Orange", "Watermelon", "Pear", "Grape", "Pineapple", "Strawberry", "Cherry", "Mango")

    private var fruitList: MutableList<Fruit> = arrayListOf()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

//        val arrayAdapter: ArrayAdapter<String> = ArrayAdapter(this, android.R.layout.simple_list_item_1, data)
//        val listView: ListView = find(R.id.list_view)
//        listView.adapter = arrayAdapter

        initFruits()
        val fruitAdapter: FruitAdapter = FruitAdapter(this, R.layout.fruit_item, fruitList)
        val listView: ListView = find(R.id.list_view)
        listView.adapter = fruitAdapter

        listView.setOnItemClickListener {
            parent, view, position, id ->
            val fruit = fruitList.get(position)
            toast(fruit.name)
        }
    }

    private fun initFruits() {
        for (i in 0..10000){
            val apple = Fruit("Apple", R.drawable.apple_pic)
            fruitList.add(apple)
            val banana = Fruit("banana", R.drawable.banana_pic)
            fruitList.add(banana)
            val orange = Fruit("orange", R.drawable.orange_pic)
            fruitList.add(orange)
            val watermelon = Fruit("watermelon", R.drawable.watermelon_pic)
            fruitList.add(watermelon)
            val pear = Fruit("pear", R.drawable.pear_pic)
            fruitList.add(pear)
            val grape = Fruit("grape", R.drawable.grape_pic)
            fruitList.add(grape)
            val pineapple = Fruit("pineapple", R.drawable.pineapple_pic)
            fruitList.add(pineapple)
            val strawberry = Fruit("strawberry", R.drawable.strawberry_pic)
            fruitList.add(strawberry)
            val cherry = Fruit("cherry", R.drawable.cherry_pic)
            fruitList.add(cherry)
            val mango = Fruit("mango", R.drawable.mango_pic)
            fruitList.add(mango)
        }
    }
}