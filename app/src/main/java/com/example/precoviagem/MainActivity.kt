package com.example.precoviagem

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.EditText
import android.widget.Toast
import com.example.precoviagem.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity(), View.OnClickListener {

    lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.buttonCalculate.setOnClickListener(this)
    }

    override fun onClick(view: View) {
        if (view.id == R.id.button_calculate) {
            calculate()
        }
    }


    private fun isValid(edtToValid: EditText): Boolean {
        return (edtToValid.text.toString() != "")
    }


    private fun calculate() {
        if (isValid(binding.editDistance) && isValid(binding.editAutonomy)
            && isValid(binding.editPrice) &&
            binding.editAutonomy.text.toString().toFloat() != 0f
        ) {
            val distance = binding.editDistance.text.toString().toFloat()
            val price = binding.editPrice.text.toString().toFloat()
            val autonomy = binding.editAutonomy.text.toString().toFloat()
            val totalValue = (distance * price) / autonomy
            val totalValueStr = "R$ ${"%.2f".format(totalValue)}"

            binding.textTotalValue.text = totalValueStr
        } else {
            Toast.makeText(this, R.string.preencha_campos, Toast.LENGTH_SHORT).show()
        }
    }
}