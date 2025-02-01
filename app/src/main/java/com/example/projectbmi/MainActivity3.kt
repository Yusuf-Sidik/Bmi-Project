package com.example.projectbmi

import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class MainActivity3 : AppCompatActivity() {

    lateinit var dataNama: TextView
    lateinit var dataUmur: TextView
    lateinit var dataHasil: TextView
    lateinit var keterangan: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main3)

        dataNama = findViewById(R.id.tv_data_nama)
        dataUmur = findViewById(R.id.tv_data_umur)
        dataHasil = findViewById(R.id.tv_data_hasil)
        keterangan = findViewById(R.id.tv_data_keterangan)

        val nama = intent.getStringExtra("nama")
        val umur = intent.getIntExtra("umur", 0)
        val hasil = intent.getFloatExtra("hasil", 0.0f)
        val kategori = intent.getStringExtra("keteranga")

        dataNama.text = "Nama  : $nama"
        dataUmur.text = "Umur  : $umur"
        dataHasil.text = "Hasil : %.2f".format(hasil)
        keterangan.text = "Keterangan : $kategori"

    }
}