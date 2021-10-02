package pjurado.com.ej0102;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class ActivitySecundario extends AppCompatActivity {
    private Button btnVolver;
    private TextView tvValor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_secundario);

        btnVolver = findViewById(R.id.buttonVolver);
        tvValor = findViewById(R.id.textViewValor);
        int numero = getIntent().getExtras().getInt("Valor");
                Log.d("Valor", "Valor" + getIntent().getExtras().getInt("Valor"));
        tvValor.setText(String.valueOf(numero+1));
        btnVolver.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setResult(RESULT_OK, getIntent());
                finish();
            }
        });
    }
}