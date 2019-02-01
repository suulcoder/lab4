package com.example.lab4.fragments


import android.content.Intent
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ListView
import com.example.lab4.MainActivity

import com.example.lab4.R
import com.example.lab4.models.Link
import com.example.lab4.web
import com.example.miscontactos.CustomAdapter
import kotlinx.android.synthetic.*
import kotlinx.android.synthetic.main.activity_list_item.view.*
import kotlinx.android.synthetic.main.fragment_proyectos.*

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 *
 */
class proyectos : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment


        //Creamos la lista con los repositorios

        val view = inflater.inflate(R.layout.fragment_proyectos, container, false)
        return  view

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val link1 = Link("App de un Restaurante","https://github.com/suulcoder/PlataformasMoviles/tree/master/Lab2",R.drawable.app1)
        val link2 = Link("App de Contactos","https://github.com/suulcoder/PlataformasMoviles/tree/master/MIsContactos",R.drawable.app2)
        val list: ArrayList<Link> =  ArrayList()
        list.add(link1)
        list.add(link2)

        listarepo.adapter = CustomAdapter(context!!,list)

        listarepo.setOnItemClickListener { parent, view, position, id ->
            val intento1 = Intent(context!!, web::class.java)
            intento1.putExtra("link",list[position].link)
            startActivity(intento1)
        }

    }







}
