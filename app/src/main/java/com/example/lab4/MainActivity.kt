package com.example.lab4

import android.content.Intent
import android.content.pm.PackageManager
import android.os.Bundle
import android.support.design.widget.Snackbar
import android.support.design.widget.NavigationView
import android.support.v4.app.ActivityCompat
import android.support.v4.app.Fragment
import android.support.v4.view.GravityCompat
import android.support.v7.app.ActionBarDrawerToggle
import android.support.v7.app.AppCompatActivity
import android.view.Menu
import android.view.MenuItem
import com.example.lab4.fragments.BlankFragment
import com.example.lab4.fragments.proyectos
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.app_bar_main.*

class MainActivity : AppCompatActivity(), NavigationView.OnNavigationItemSelectedListener {

    override fun onCreate(savedInstanceState: Bundle?) {//Sobreescribimos el metodo OnCreate
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(toolbar)

        val toggle = ActionBarDrawerToggle(
                this, drawer_layout, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close)
        drawer_layout.addDrawerListener(toggle)
        toggle.syncState()
        nav_view.setNavigationItemSelectedListener(this)
        permisos()
        load(BlankFragment())
    }

    override fun onBackPressed() {//Soreescribimos onBackPRessed
        if (drawer_layout.isDrawerOpen(GravityCompat.START)) {
            drawer_layout.closeDrawer(GravityCompat.START)
        } else {
            super.onBackPressed()
        }
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.main, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {//sobre escribimos el metodo para cerrar
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        when (item.itemId) {
            R.id.salir ->{//si se decide salir
                this.finish()//terminamos la activity
                return true
            }
            else -> return super.onOptionsItemSelected(item)

        }
    }

    override fun onNavigationItemSelected(item: MenuItem): Boolean {//sera utl para el NavigationView
        // Handle navigation view item clicks here.
        when (item.itemId) {
            R.id.inicio -> {//Si pide el inicio corremos de nuevo el MainActivity
                load(BlankFragment())
            }
            R.id.proyectos -> {//Si pide proyectos corremos fragment proyectos
                load(proyectos())
            }
            R.id.Direccion -> {//Si pide dirección corremos fragmen direccion
                val intent = Intent(applicationContext, mapa::class.java)
                startActivity(intent)
            }
        }

        drawer_layout.closeDrawer(GravityCompat.START)
        return true
    }


    private fun load(fragment: Fragment){//nos permite agregar el fragment a la activity actual
        val manager = supportFragmentManager
        manager.beginTransaction().replace(R.id.fragment_container,fragment).commit()
    }


    private fun permisos() {
        if (ActivityCompat.checkSelfPermission(
                this,
                android.Manifest.permission.ACCESS_NETWORK_STATE
            ) != PackageManager.PERMISSION_GRANTED
        ) {
            ActivityCompat.requestPermissions(this, arrayOf(android.Manifest.permission.ACCESS_NETWORK_STATE), 1)
        }
    }
}
