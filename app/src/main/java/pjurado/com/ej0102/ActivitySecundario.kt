package pjurado.com.ej0102

import androidx.appcompat.app.AppCompatActivity
import android.widget.TextView
import android.os.Bundle
import pjurado.com.ej0102.R
import android.app.Activity
import android.util.Log
import android.view.View
import android.widget.Button
import pjurado.com.ej0102.databinding.ActivityMainBinding
import pjurado.com.ej0102.databinding.ActivitySecundarioBinding

class ActivitySecundario : AppCompatActivity() {
    private lateinit var binding: ActivitySecundarioBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySecundarioBinding.inflate(layoutInflater)
        setContentView(binding.root)


        val numero = intent.extras!!.getInt("Valor")
        val requestCode = intent.extras!!.getInt("requestCode")
        Log.d("Valor", "Valor" + intent.extras!!.getInt("Valor"))
        binding.textViewValor.setText((numero + 1).toString())
        binding.buttonVolver.setOnClickListener(View.OnClickListener {
            intent.putExtra("resultCode", "0")
            setResult(RESULT_OK, intent)
            finish()
        })
    }
}