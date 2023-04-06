package com.vaisyan.quizchallenge.network

import com.vaisyan.quizchallenge.model.Question
import retrofit2.http.GET
import javax.inject.Singleton

@Singleton
interface QuestionApi {
    @GET("questions.json")
    suspend fun getAllQuestion(): Question
}