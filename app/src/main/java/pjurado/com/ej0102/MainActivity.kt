package pjurado.com.ej0102

import androidx.appcompat.app.AppCompatActivity
import androidx.activity.result.contract.ActivityResultContracts
import android.widget.TextView
import android.os.Bundle
import pjurado.com.ej0102.R
import android.content.Intent
import pjurado.com.ej0102.ActivitySecundario
import pjurado.com.ej0102.MainActivity
import android.app.Activity
import android.view.View
import android.widget.Button
import com.google.android.material.snackbar.Snackbar
import pjurado.com.ej0102.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    companion object {
        private const val UNO = 1
        private const val DOS = 2
        private const val TRES = 3
        private const val CUATRO = 4
    }

    private lateinit var binding: ActivityMainBinding
    private val responseLauncher = registerForActivityResult(
        ActivityResultContracts.StartActivityForResult()){
        val requestCode = it.data?.extras?.getInt("requestCode")
        when (it.resultCode) {
            RESULT_OK -> {
                when (requestCode) {
                    UNO -> {
                        val contador = binding.textView1.text.toString().toInt() + 1
                        binding.textView1.text = contador.toString()
                    }
                    DOS -> {
                        val contador = binding.textView2.text.toString().toInt() + 1
                        binding.textView2.text = contador.toString()
                    }
                    TRES -> {
                        val contador = binding.textView3.text.toString().toInt() + 1
                        binding.textView3.text = contador.toString()
                    }
                    CUATRO -> {
                        val contador = binding.textView4.text.toString().toInt() + 1
                        binding.textView4.text = contador.toString()
                    }
                    RESULT_CANCELED -> Snackbar.make(
                        binding.root,
                        "Ha cancelado",
                        Snackbar.LENGTH_SHORT
                    )
                        .setBackgroundTint(resources.getColor(R.color.design_default_color_secondary_variant))
                        .show()
                }
            }
        }
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.button1.setOnClickListener(View.OnClickListener {
            val intent = Intent(this, ActivitySecundario::class.java)
            intent.putExtra("requestCode", UNO)
            intent.putExtra("Valor", binding.textView1.getText().toString().toInt())
            responseLauncher.launch(intent)
        })

        binding.button2.setOnClickListener(View.OnClickListener {
            val intent = Intent(this, ActivitySecundario::class.java)
            intent.putExtra("requestCode", DOS)
            intent.putExtra("Valor", binding.textView2.getText().toString().toInt())
            responseLauncher.launch(intent)
        })

        binding.button3.setOnClickListener(View.OnClickListener {
            val intent = Intent(this, ActivitySecundario::class.java)
            intent.putExtra("requestCode", TRES)
            intent.putExtra("Valor", binding.textView3.getText().toString().toInt())
            responseLauncher.launch(intent)
        })

        binding.button4.setOnClickListener(View.OnClickListener {
            val intent = Intent(this, ActivitySecundario::class.java)
            intent.putExtra("requestCode", CUATRO)
            intent.putExtra("Valor", binding.textView4.getText().toString().toInt())
            responseLauncher.launch(intent)
        })
    }

}