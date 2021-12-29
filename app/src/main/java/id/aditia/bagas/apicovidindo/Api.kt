package id.aditia.bagas.apicovidindo

import id.aditia.bagas.model.IndonesiaResponse
import retrofit2.Call
import retrofit2.http.GET

interface Api {
    //menggunakan retrofit untuk memanggil data
    //fungsi untuk mengambil data dengan endpoint indonesia
    @GET("indonesia/")
    //membuat fungsi getIndonesia dengan nilai return Call didalamnya terdapat Arraylist
    fun getIndonesia(): Call<ArrayList<IndonesiaResponse>>


}