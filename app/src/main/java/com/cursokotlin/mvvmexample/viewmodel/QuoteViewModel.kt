package com.cursokotlin.mvvmexample.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.cursokotlin.mvvmexample.model.QuoteModel
import com.cursokotlin.mvvmexample.model.provideRandomQuote

/**
 * El ViewModel establece la conexión entre el modelo y la vista. Las vistas se suscriben a sus respectivos
 * viewModels y estos al percatarse de que el modelo ha sido modificado lo notificarán a la vista.
 */


class QuoteViewModel : ViewModel() {  // Heredamos de ViewModel


    /* Implementamos LiveData, un tipo de datos al que la activity se conectará

    * */

    val quoteModel = MutableLiveData<QuoteModel>()

    /* Definimos el método que actualizará la vista. La MutableLiveData


     */

    fun randomQuote() = quoteModel.postValue(provideRandomQuote())
}