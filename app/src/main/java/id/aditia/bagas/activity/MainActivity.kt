package id.aditia.bagas.activity

import android.os.Bundle
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import id.aditia.bagas.R
import id.aditia.bagas.adapter.CountryAdapter
import id.aditia.bagas.apicovidglobal.RetrofitGlobal
import id.aditia.bagas.apicovidindo.Retrofit
import id.aditia.bagas.model.GlobalResponse
import id.aditia.bagas.model.IndonesiaResponse
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        tampilIndonesia()
        tampilGlobal()
//        val btnCountry = findViewById<Button>(R.id.btnCountry)
//        btnCountry.setOnClickListener {
//            Intent(this@MainActivity, CountryActivity::class.java).also {
//                startActivity(it)
//            }
//        }

    }

    private fun tampilGlobal() {
        //menyimpan rvCountry
        val recyclerView = findViewById<RecyclerView>(R.id.rvCountry)
        recyclerView.setHasFixedSize(true)
        //menyimpan layout manager
        recyclerView.layoutManager = LinearLayoutManager(this)

        //mamanggil retrofitg lobal
        RetrofitGlobal.instance.getGlobal().enqueue(object : Callback<ArrayList<GlobalResponse>> {
            override fun onResponse(
                call: Call<ArrayList<GlobalResponse>>,
                response: Response<ArrayList<GlobalResponse>>
            ) {
                val list = response.body()
                val adapter = list?.let { CountryAdapter(it) }
                recyclerView.adapter = adapter
            }

            override fun onFailure(call: Call<ArrayList<GlobalResponse>>, t: Throwable) {
                //toast untuk menentukan eror
                Toast.makeText(this@MainActivity, "${t.message}", Toast.LENGTH_SHORT).show()
            }

        })
    }

    //fungsi untuk menampilkan data covid indoneisa yang didalamnya terdapat objek Retrofit
    private fun tampilIndonesia() {
        Retrofit.instance.getIndonesia().enqueue(object : Callback<ArrayList<IndonesiaResponse>>{
            override fun onResponse(
                call: Call<ArrayList<IndonesiaResponse>>,
                response: Response<ArrayList<IndonesiaResponse>>
            ) {
                //karena array list hanya berjumlah 1 maka get bernilai 0
                //menampung data yang diperoleh api
                val indonesiaResponse = response.body()?.get(0)
                val positif = indonesiaResponse?.positif
                val sembuh = indonesiaResponse?.sembuh
                val meninggal = indonesiaResponse?.meninggal
                val dirawat = indonesiaResponse?.dirawat

                //menampilkan pada textview sesuai dengan idnya
                val teksPositif = findViewById<TextView>(R.id.teksPositif)
                val teksSembuh:TextView  = findViewById(R.id.teksSembuh)
                val teksMeninggal = findViewById<TextView>(R.id.teksMeninggal)
                val teksDirawat = findViewById<TextView>(R.id.teksDirawat)
                teksPositif.text = positif
                teksSembuh.text = sembuh
                teksMeninggal.text = meninggal
                teksDirawat.text = dirawat
            }
            //ketika terjadi error
            override fun onFailure(call: Call<ArrayList<IndonesiaResponse>>, t: Throwable) {
                Toast.makeText(this@MainActivity, "${t.message}", Toast.LENGTH_SHORT).show()
            }

        })
    }
}