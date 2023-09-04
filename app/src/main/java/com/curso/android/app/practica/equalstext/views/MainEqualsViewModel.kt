package com.curso.android.app.practica.equalstext.views

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.curso.android.app.practica.equalstext.models.TextToCompare
import kotlinx.coroutines.launch


private const val TAG = "MainEqualsViewModel"

class MainEqualsViewModel: ViewModel() {

    private var _textToCompare = MutableLiveData<TextToCompare>()
    val textToCompare:LiveData<TextToCompare>get() = _textToCompare

    private var _errorMsg = MutableLiveData<String?>()
    val errorMsg: LiveData<String?> get() = _errorMsg

    fun compararStrings(text1: String, text2: String) {
        try {
            if (text1.isNotEmpty() && text2.isNotEmpty()) {
                val result = text1.equals(text2)
                actualizarData(text1, text2, result)
                actualizarError(null)
            } else {
                throw Exception("Completar ambos campos de texto")
            }
        } catch (e: Exception) {
            actualizarError("Error: ${e.message}")
            Log.e(TAG, "equalsStrings catch; e -> $e")
        }
    }
     private fun actualizarData(text1: String, text2: String, result: Boolean) {
        viewModelScope.launch {
             _textToCompare.value = TextToCompare(text1, text2, result)
        }
    }

    private fun actualizarError(msg: String?) {
        viewModelScope.launch {
            _errorMsg.value = msg
        }
    }
}