package br.edu.fateczl.conversorbinario;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    /*
     *@author: Kelvin Santos Guimarães
    */

    private RadioButton rbBytes;
    private RadioButton rbKB;
    private RadioButton rbMB;
    private RadioButton rbGB;
    private RadioButton rbTB;
    private EditText etBit;
    private Button btnConverter;
    private TextView tvRes;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        rbBytes = findViewById(R.id.rbByte);
        rbBytes.setChecked(true);
        rbKB = findViewById(R.id.rbKB);
        rbMB = findViewById(R.id.rbMB);
        rbGB = findViewById(R.id.rbGB);
        rbTB = findViewById(R.id.rbTB);
        etBit = findViewById(R.id.teBit);
        btnConverter = findViewById(R.id.btnConverter);
        tvRes = findViewById(R.id.tvRes);

        btnConverter.setOnClickListener(op -> converter());

    }

    private void converter() {
        String valorBit = etBit.getText().toString();

        if (valorBit.isEmpty()) {
            tvRes.setText("Por favor, insira um número de bits");
            return;
        }

        long bits = Long.parseLong(valorBit);
        double resultado = 0.0;

        if (rbBytes.isChecked()) {
            resultado = bits / 8.0;
        } else if (rbKB.isChecked()) {
            resultado = bits / 8.0 / 1024.0;
        } else if (rbMB.isChecked()) {
            resultado = bits / 8.0 / 1024.0 / 1024.0;
        } else if (rbGB.isChecked()) {
            resultado = bits / 8.0 / 1024.0 / 1024.0 / 1024.0;
        } else if (rbTB.isChecked()) {
            resultado = bits / 8.0 / 1024.0 / 1024.0 / 1024.0 / 1024.0;
        }

        tvRes.setText("Valor convertido: " + resultado);
    }
}