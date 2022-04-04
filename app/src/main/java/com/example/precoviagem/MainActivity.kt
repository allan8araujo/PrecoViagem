package com.example.precoviagem

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import com.example.precoviagem.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity(), View.OnClickListener {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.buttonCalculate.setOnClickListener(this)

    }

    fun calculate (){
        Toast.makeText(this,"fui clicado!",Toast.LENGTH_SHORT).show()
    }

    override fun onClick(view: View) {
        if (view.id==R.id.button_calculate){
            calculate()
        }
    }
}