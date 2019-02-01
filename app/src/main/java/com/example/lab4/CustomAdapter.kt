package com.example.miscontactos

import android.content.Context
import android.media.Image
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ImageView
import android.widget.TextView
import com.example.lab4.R
import com.example.lab4.models.Link

class CustomAdapter(var context: Context, var list:ArrayList<Link>): BaseAdapter() {

    private class ViewHolder(row: View?){
        var txtName: TextView
        var txtLink: TextView
        var ivImage: ImageView

        init {
            this.txtName = row?.findViewById(R.id.name) as TextView
            this.txtLink = row?.findViewById(R.id.link) as TextView
            this.ivImage = row?.findViewById(R.id.photo) as ImageView
        }
    }
    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        var view: View?
        var viewHolder: ViewHolder
        if (convertView==null){
            var layout = LayoutInflater.from(context)
            view = layout.inflate(R.layout.activity_list_item,convertView,false)
            viewHolder = ViewHolder(view)
            view.tag = viewHolder
        }
        else{
            view = convertView
            viewHolder = view.tag as ViewHolder
        }

        var objeto:Link = getItem(position) as Link

        viewHolder.txtName.text = objeto.nombre
        viewHolder.txtLink.text = (objeto.link)
        viewHolder.ivImage.setImageResource(objeto.image)


        return view as View


    }

    override fun getItem(position: Int): Any {//devolvemos la posicion de la lista
        return list.get(position)
    }

    override fun getItemId(position: Int): Long {//devolvemos la posicion
        return position.toLong();
    }

    override fun getCount(): Int {//contamos la cantidad de items
        return list.count()
    }
}