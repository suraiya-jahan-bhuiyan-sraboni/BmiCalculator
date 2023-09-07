package com.example.bmicalculator

import android.graphics.Color
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.isVisible
import com.example.bmicalculator.databinding.ActivityMainBinding

private lateinit var binding: ActivityMainBinding
class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding=ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val t1= binding.bmiResult
        val weight= binding.editTextweight
        val height= binding.editTextheight
        val result_btn=binding.buttonResult
        result_btn.setOnClickListener {
            if((weight.text.toString() == "") || (height.text.toString() == "")){
                Toast.makeText(this, "Enter height and weight properly!", Toast.LENGTH_SHORT).show()
            }else {
                val area = binding.resultCv
                area.isVisible = true
                val w: String = weight.text.toString()
                val h: String = height.text.toString()
                val bmi: Float = w.toFloat() / ((h.toFloat() / 100) * (h.toFloat() / 100))
                val ubmi = String.format("%.2f", bmi).toFloat()
                t1.text = ubmi.toString()
                printStatus(ubmi)
            }

        }


    }

    private fun printStatus(ubmi: Float) {
        val t2= binding.resultState
        val t3= binding.range
        t3.text="18.5-24.9 is healthy range"
        if(ubmi<16.0){
            t2.text="you are underweight(severe)."
            t2.setTextColor(Color.YELLOW)

        }else if(ubmi in 16.0..16.9){
            t2.text="you are underweight(Moderate)."
            t2.setTextColor(Color.YELLOW)
        } else if(ubmi in 17.0..18.4){
            t2.text="you are underweight(Mild)."
            t2.setTextColor(Color.YELLOW)
        }else if(ubmi in 18.5..24.9){
            t2.text="you are healthy."
            t2.setTextColor(Color.GREEN)
        }else if(ubmi in 25.0..29.9){
            t2.text="you are overweighted."
            t2.setTextColor(Color.parseColor("#FFC107"))
        }else if(ubmi in 30.0..34.9){
            t2.text="you are too much overweighted."
            t2.setTextColor(Color.parseColor("#FF9800"))
        }else if(ubmi in 35.0..39.9){
            t2.text="you are extremely overweighted."
            t2.setTextColor(Color.parseColor("#FF5722"))
        }else{
            t2.text="you are at health risk(OverWeighted)."
            t2.setTextColor(Color.parseColor("#F8DC2619"))
        }


    }
}