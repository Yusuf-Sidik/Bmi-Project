package com.example.projectbmi

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity

class MainActivity2 : AppCompatActivity() {

    lateinit var edtNama: EditText
    lateinit var edtUmur: EditText
    lateinit var edtTinggi: EditText
    lateinit var edtBerat: EditText
    lateinit var btnHasil: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)

        edtNama = findViewById(R.id.edt_nama)
        edtUmur = findViewById(R.id.edt_umur)
        edtTinggi = findViewById(R.id.edt_tinggi)
        edtBerat = findViewById(R.id.edt_berat)
        btnHasil = findViewById(R.id.btn_hasil)


        btnHasil.setOnClickListener {
            // Mengambil data dari EditText
            val nama = edtNama.text.toString()
            val umur = edtUmur.text.toString().toInt()
            val tinggi = edtTinggi.text.toString().toFloat() / 100 // Konversi ke meter
            val berat = edtBerat.text.toString().toFloat()

            // Menghitung BMI
            val hasil = berat / (tinggi * tinggi)

            // Tentukan kategori BMI
            val kategori = when {
                hasil < 18.5 -> "Kurus"
                hasil < 24.9 -> "Normal"
                hasil < 29.9 -> "Gemuk"
                else -> "Obesitas"
            }

            val intent = Intent(this, MainActivity3::class.java)
            intent.putExtra("nama", nama)
            intent.putExtra("umur", umur)
            intent.putExtra("hasil", hasil)
            intent.putExtra("keteranga", kategori)
            startActivity(intent)
        }
    }
}