package id.aditia.bagas.adapter


import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import id.aditia.bagas.R
import id.aditia.bagas.model.GlobalResponse

//Implement RecycleView untuk menampilkan data covid global
//parameter list untuk menampung list yang diterima dari response didalamnya adalah Global Response
class CountryAdapter(private var list:ArrayList<GlobalResponse>) :RecyclerView.Adapter<CountryAdapter.CountryViewHolder>(){
    inner class CountryViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){
        fun bind(negara: GlobalResponse){
            with(itemView){
                val country = findViewById<TextView>(R.id.tvCountry)
                val cases:TextView  = findViewById(R.id.tvCases)
                val recovered:TextView  = findViewById(R.id.tvRecovered)
                //val active:TextView  = findViewById(R.id.tvActive)
                val deaths:TextView  = findViewById(R.id.tvDeaths)
                country.text = negara.country
                cases.text = negara.cases
                recovered.text = negara.recovered
                //active.text = negara.attributes.active
                deaths.text = negara.deaths

            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CountryViewHolder {
        //val view untuk menginflate item layout
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_country, parent, false)
        return CountryViewHolder(view)
    }

    override fun onBindViewHolder(holder: CountryViewHolder, position: Int) {
        //memanggil holder
        holder.bind(list[position])
    }

    override fun getItemCount(): Int = list.size
}