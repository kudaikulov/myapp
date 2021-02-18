package com.example.newkolesupgrade

import android.telecom.Call
import com.fasterxml.jackson.databind.JsonNode
import retrofit2.http.GET

interface ApiClient {
    @GET("v2/competitions/")
    fun getUpcommingEvents(): retrofit2.Call<JsonNode>

}


//