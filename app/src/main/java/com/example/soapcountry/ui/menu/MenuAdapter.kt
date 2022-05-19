package com.example.soapcountry.ui.menu

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.soapcountry.R
import com.example.soapcountry.util.ClickOnItem


class MenuAdapter(private val listener: ClickOnItem<MenuElement>) :
    RecyclerView.Adapter<MenuAdapter.ViewHolder>() {

    data class MenuElement(val title: String, val image: Int)

    private var listOfMenu = listOf<MenuElement>()

    fun setData(menus: List<MenuElement>) {
        listOfMenu = menus
        notifyDataSetChanged()
    }


    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val titulo: TextView = view.findViewById(R.id.txt_nombre_menu)
        val image: ImageView = view.findViewById(R.id.image_menu)
        fun bind(menu: MenuElement) {
            image.setImageResource(menu.image)
            titulo.text = menu.title
        }
    }

    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(viewGroup.context)
            .inflate(R.layout.item_menu, viewGroup, false)
        return ViewHolder(view)

    }

    override fun onBindViewHolder(viewHolder: ViewHolder, position: Int) {
        viewHolder.bind(listOfMenu[position])
        viewHolder.itemView.setOnClickListener {
            listener.clickOnElement(listOfMenu[position], position)
        }
    }

    override fun getItemCount() = listOfMenu.size


}
