package com.curso.android.app.practica.equalstext.views

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.inputmethod.InputMethodManager
import androidx.activity.viewModels
import com.curso.android.app.practica.equalstext.R
import com.curso.android.app.practica.equalstext.databinding.ActivityMainBinding

private const val TAG = "MainActivity"

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private val mainEqualsViewModel:MainEqualsViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)


        binding.buttonComparar.setOnClickListener {


            val text1: String = binding.texto1.text.toString()
            val text2: String = binding.texto2.text.toString()
            println(text1)
            println(text2)
            mainEqualsViewModel.compararStrings(text1, text2)

        }
        mainEqualsViewModel.textToCompare.observe(this){
            setResultTxt(it.result)
        }
        mainEqualsViewModel.errorMsg.observe(this){
            if (!it.isNullOrEmpty()) showError(it)
        }
    }

    private fun showError(msg: String) {
        val color = getColor(R.color.error)
        setTextView(msg, color)
    }

    private fun setResultTxt(comparisonResult: Boolean) {
        val txt: String
        val color: Int

        when(comparisonResult) {
            true -> {
                txt = getString(R.string.resultTrue)
                color = getColor(R.color.resultTrue)
            }
            false -> {
                txt = getString(R.string.resultFalse)
                color = getColor(R.color.resultFalse)
            }
        }

        setTextView(txt, color)
    }

    private fun setTextView(text: String, color: Int) {
        binding.textViewComparision.text = text
        binding.textViewComparision.setTextColor(color)
    }


    }
