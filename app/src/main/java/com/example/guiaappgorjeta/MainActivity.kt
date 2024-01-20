package com.example.guiaappgorjeta

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.guiaappgorjeta.databinding.ActivityMainBinding
import java.text.NumberFormat
import kotlin.math.ceil

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnCalcular.setOnClickListener{
            calcularGorjeta()
        }
    }

    private fun calcularGorjeta() {
        val valor = binding.txtiTotal.text.toString().toDouble()
        val opcaoSelecionada = binding.rgOpcoes.checkedRadioButtonId
        val porcentagem = when(opcaoSelecionada){
            R.id.rbOtimo -> 0.30
            R.id.rbBom -> 0.20
            else -> 0.15
        }
        var gorjeta = valor * porcentagem
        val arredondar = binding.swArrendondar.isChecked //como é um switch, a val já é uma booleana
        if (arredondar){
            gorjeta = ceil(gorjeta) // o método ceil arredonda o  valor
        }

        val gorjetaFormatada = NumberFormat.getCurrencyInstance().format(gorjeta) // recupera a moeda
        // local de onde se está utilizando o app e formata o valor

        binding.txtGorjeta.text = getString(R.string.gorjeta, gorjetaFormatada)


    }
}