package com.asoto.simondice

import android.app.Activity
import android.graphics.Color

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.TextView
import kotlinx.android.synthetic.main.*
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import org.jetbrains.anko.toast
import java.util.*


class ActividadBotones : Activity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.actividad_botones)

        val btnEmpezar = findViewById<Button>(R.id.Empezar)

        val btnRojo = findViewById<Button>(R.id.Rojo)
        val btnAmarillo = findViewById<Button>(R.id.Amarillo)
        val btnAzul = findViewById<Button>(R.id.Azul)
        val btnVerde = findViewById<Button>(R.id.Verde)
        val btnComprobar = findViewById<Button>(R.id.Comprobar)

        val colores = arrayListOf("Rojo","Azul","Amarillo","Verde")
        val secuencia = arrayListOf<String>()
        val colorPulsado = arrayListOf<String>()

        var nivel = 1




        btnEmpezar.setOnClickListener(object : View.OnClickListener{
            override fun onClick(v: View?) {
                for(i in 0..nivel){
                    secuencia.add(colores.get((0..3).random()))
                }
                toast(secuencia.toString())
            }

        }

        )

        btnComprobar.setOnClickListener(object : View.OnClickListener{
            override fun onClick(v: View?) {
                for(i in 0..nivel){
                    if(secuencia.get(i).equals(colorPulsado.get(i))){
                        nivel++
                    }else{
                        toast("Has perdido")
                    }

                }
            }
        }

        )





        btnRojo.setOnClickListener(object : View.OnClickListener{
            override fun onClick(v: View?) {
                btnRojo.setBackgroundColor(Color.parseColor("#FF4081"))
                colorPulsado.add("Rojo")

                GlobalScope.launch(Dispatchers.Main) {
                    delay(500)
                    btnRojo.setBackgroundColor(Color.parseColor("#FFCC0000"))
                }

            }

        }

        )

        btnAmarillo.setOnClickListener(object : View.OnClickListener{
            override fun onClick(v: View?) {
                colorPulsado.add("Amarillo")
            }

        }

        )

        btnAzul.setOnClickListener(object : View.OnClickListener{
            override fun onClick(v: View?) {
                colorPulsado.add("Azul")
            }

        }

        )

        btnVerde.setOnClickListener(object : View.OnClickListener{
            override fun onClick(v: View?) {
                colorPulsado.add("Verde")
            }

        }

        )

    }

    /*
    fun cambiarTexto(v : TextView) {
        v.setText(String.format("presionado"))
    }
    */
}
