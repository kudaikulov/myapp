package com.example.newkolesupgrade

import android.telecom.Call
import com.fasterxml.jackson.databind.JsonNode
import retrofit2.http.GET

interface ApiClient {
    @GET("rest/v2/all")
    fun getUpcommingEvents(): retrofit2.Call<JsonNode>

}