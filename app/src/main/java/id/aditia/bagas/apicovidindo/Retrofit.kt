package id.aditia.bagas.apicovidindo

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

//membuat variabel untuk menampung base URL
object Retrofit {
    private const val BASE_URL = "https://api.kawalcorona.com/"

    val instance: Api by lazy {
        val retrofit = Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
        retrofit.create(Api::class.java)
    }
}