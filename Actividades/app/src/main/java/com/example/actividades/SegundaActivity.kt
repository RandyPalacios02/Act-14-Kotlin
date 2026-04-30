package com.example.actividades

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.actividades.databinding.ActivitySegundaBinding

class SegundaActivity : AppCompatActivity() {

    lateinit var binding: ActivitySegundaBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        binding = ActivitySegundaBinding.inflate(layoutInflater)

        setContentView(binding.root)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val bundle = intent.extras
        if (bundle != null) {
            val edad = bundle.getInt("EDAD")
            val esEstudiante = bundle.getBoolean("ES_ESTUDIANTE")
            binding.tvwEdad.text = "Edad: $edad años"
            binding.tvwEstudiante.text = "¿Es estudiante?: $esEstudiante"
        }

        binding.tvwname.text =bundle?.getString("USER_NAME")// intent.getStringExtra(" USER_NAME")

    }
}