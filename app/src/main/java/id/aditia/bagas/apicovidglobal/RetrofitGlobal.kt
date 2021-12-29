package id.aditia.bagas.apicovidglobal

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

//membuat variabel untuk menampung base URL
object RetrofitGlobal {
    private const val BASE_URL = "https://corona.lmao.ninja/v2/"


    val instance: ApiGlobal by lazy {
        val retrofit = Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
        retrofit.create(ApiGlobal::class.java)
    }
}