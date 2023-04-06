package com.vaisyan.quizchallenge.repository

import android.util.Log
import com.vaisyan.quizchallenge.data.DataOrException
import com.vaisyan.quizchallenge.model.QuestionItem
import com.vaisyan.quizchallenge.network.QuestionApi
import javax.inject.Inject

class QuestionRepository @Inject constructor(private val api: QuestionApi) {
    private val dataOrException =  DataOrException<ArrayList<QuestionItem>, Boolean, Exception>()

    suspend fun getAllQuestions(): DataOrException<ArrayList<QuestionItem>, Boolean, Exception> {
        try {
            dataOrException.loading = true
            dataOrException.data = api.getAllQuestion()
            if(dataOrException.data.toString().isNotEmpty()) dataOrException.loading = false
        } catch (exception: Exception) {
            dataOrException.e = exception
            Log.d("EXC", "getAllQuestions: ${dataOrException.e!!.localizedMessage}")
        }
        return dataOrException
    }
}