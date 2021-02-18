package com.example.newkolesupgrade

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import com.fasterxml.jackson.databind.JsonNode
import kotlinx.android.synthetic.main.activity_main.*
import org.w3c.dom.Text
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.jackson.JacksonConverterFactory


val apiRetrofit: Retrofit = Retrofit.Builder()
//        .baseUrl("http://37.143.8.68:2020/")
        .baseUrl("https://restcountries.eu/")
        .addConverterFactory(JacksonConverterFactory.create())
        .build()

val apiClient: ApiClient = apiRetrofit.create(ApiClient::class.java)

class MainActivity : AppCompatActivity() {

    private lateinit var responseButton: Button
    private lateinit var responseTextView: TextView

//
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        bindViews()

    }

    private fun bindViews(){
        responseTextView = findViewById(R.id.activity_hello_response_text_view)
         responseButton = findViewById(R.id.activity_hello_load_data_button)

        responseButton.setOnClickListener {
            loadApiData()
        }
    }

    private fun loadApiData(){
        apiClient.getUpcommingEvents().enqueue(object : Callback<JsonNode>{

            override fun onResponse(call: Call<JsonNode>, response: Response<JsonNode>) {
                if (response.isSuccessful){
                    val body: JsonNode = response.body()!!
                    responseTextView.text = body.toString()
                }

            }
            override fun onFailure(call: Call<JsonNode>, t: Throwable) {
                responseTextView.text = t.localizedMessage
            }

        })
    }


}