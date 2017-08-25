package net.blueness.listviewtest

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.ImageView
import android.widget.TextView
import org.jetbrains.anko.find

/**
 * Created by Blueness on 2017/8/25.
 */
class FruitAdapter(context: Context?, textViewResourceId: Int, objects: List<Fruit>) :
        ArrayAdapter<Fruit>(context, textViewResourceId, objects) {

    private var resourceId: Int

    init {
        resourceId = textViewResourceId
    }

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        val fruit = getItem(position) //获取当前Fruit的实例
        val view: View
        val viewHolder: ViewHolder //内部类

        if (convertView == null){
            view = LayoutInflater.from(context!!).inflate(resourceId, parent, false)
            viewHolder = ViewHolder()
            viewHolder.fruitImage = view.find(R.id.fruit_image)
            viewHolder.fruitName = view.find(R.id.fruit_name)
            view.setTag(viewHolder)
        } else {
            view = convertView
            viewHolder = view.getTag() as ViewHolder
        }

        viewHolder.fruitImage!!.setImageResource(fruit.imageId)
        viewHolder.fruitName!!.setText(fruit.name)
        return view
    }

    class ViewHolder {
        internal var fruitImage: ImageView? = null
        internal var fruitName: TextView? = null
    }

}

