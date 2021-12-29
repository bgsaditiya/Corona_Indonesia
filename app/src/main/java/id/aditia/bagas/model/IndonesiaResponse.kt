package id.aditia.bagas.model

//mendeklarasikan variabel data yang terdapat pada api
data class IndonesiaResponse(
    val name: String,
    val positif: String,
    val sembuh: String,
    val meninggal: String,
    val dirawat: String
)