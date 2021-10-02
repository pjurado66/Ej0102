package pjurado.com.ej0102;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    private Button btn1;
    private Button btn2;
    private Button btn3;
    private Button btn4;
    private TextView tv1;
    private TextView tv2;
    private TextView tv3;
    private TextView tv4;


    private final static int UNO = 1;
    private final static int DOS = 2;
    private final static int TRES = 3;
    private final static int CUATRO = 4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn1 = findViewById(R.id.button1);
        btn2 = findViewById(R.id.button2);
        btn3 = findViewById(R.id.button3);
        btn4 = findViewById(R.id.button4);

        tv1 = findViewById(R.id.textView1);
        tv2 = findViewById(R.id.textView2);
        tv3 = findViewById(R.id.textView3);
        tv4 = findViewById(R.id.textView4);

        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(MainActivity.this, ActivitySecundario.class);
                i.putExtra("Valor", Integer.parseInt(tv1.getText().toString()));
                startActivityForResult(i, UNO);
            }
        });

        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(MainActivity.this, ActivitySecundario.class);
                i.putExtra("Valor", Integer.parseInt(tv2.getText().toString()));
                startActivityForResult(i, DOS);
            }
        });

        btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(MainActivity.this, ActivitySecundario.class);
                i.putExtra("Valor", Integer.parseInt(tv3.getText().toString()));
                startActivityForResult(i, TRES);
            }
        });

        btn4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(MainActivity.this, ActivitySecundario.class);
                i.putExtra("Valor", Integer.parseInt(tv4.getText().toString()));
                startActivityForResult(i, CUATRO);
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        int contador;

        if (resultCode == RESULT_OK) {
            switch (requestCode) {
                case UNO:
                    contador = Integer.parseInt(tv1.getText().toString()) + 1;
                    tv1.setText(String.valueOf(contador));
                    break;
                case DOS:
                    contador = Integer.parseInt(tv2.getText().toString()) + 1;
                    tv2.setText(String.valueOf(contador));
                    break;
                case TRES:
                    contador = Integer.parseInt(tv3.getText().toString()) + 1;
                    tv3.setText(String.valueOf(contador));
                    break;
                case CUATRO:
                    contador = Integer.parseInt(tv4.getText().toString()) + 1;
                    tv4.setText(String.valueOf(contador));
                    break;
            }

        }
    }
}

