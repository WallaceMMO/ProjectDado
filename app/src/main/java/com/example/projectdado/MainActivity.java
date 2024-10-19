/*
 *@author:<Wallace Moura Machado de Oliveira;1110482413004>
 */

package com.example.projectdado;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    Spinner spnDados;
    Spinner spnQuantidade;
    Button btnRolar;
    TextView lblResultado;
    int facesDado;
    int quantidadeDados;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        spnDados = findViewById(R.id.spnDados);
        spnQuantidade = findViewById(R.id.spnQuantidade);
        btnRolar = findViewById(R.id.btnRolar);
        lblResultado = findViewById(R.id.lblResultado);

        String[] tiposDados = {"D4", "D6", "D8", "D10", "D12", "D20", "D100"};
        ArrayAdapter<String> adapterDados = new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item, tiposDados);
        spnDados.setAdapter(adapterDados);

        String[] quantidades = {"1", "2", "3"};
        ArrayAdapter<String> adapterQuantidade = new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item, quantidades);
        spnQuantidade.setAdapter(adapterQuantidade);

        spnDados.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {

                String selecao = tiposDados[i];
                facesDado = Integer.parseInt(selecao.substring(1));
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {
            }
        });

        spnQuantidade.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {

                quantidadeDados = Integer.parseInt(quantidades[i]);
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {
            }
        });

        btnRolar.setOnClickListener(p -> rolarDados());
    }

    private void rolarDados() {
        Random random = new Random();
        StringBuilder resultado = new StringBuilder();

        for (int i = 0; i < quantidadeDados; i++) {
            int valor = random.nextInt(facesDado) + 1;
            resultado.append("Dado ").append(i + 1).append(": ").append(valor).append("\n");
        }

        lblResultado.setText(resultado.toString());
    }
}