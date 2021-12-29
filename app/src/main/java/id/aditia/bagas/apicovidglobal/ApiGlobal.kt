package id.aditia.bagas.apicovidglobal

import id.aditia.bagas.model.GlobalResponse
import retrofit2.Call
import retrofit2.http.GET

interface ApiGlobal {
    //menggunakan retrofit untuk memanggil data
    //fungsi untuk mengambil data dengan endpoint v2/countries/
    @GET("countries/")
    //membuat fungsi getGlobal dengan nilai return Call didalamnya terdapat Arraylist
    fun getGlobal(): Call<ArrayList<GlobalResponse>>
}