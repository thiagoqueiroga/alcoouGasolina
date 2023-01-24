package com.example.alcoolougasolinafinal;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.google.android.material.textfield.TextInputEditText;

public class MainActivity extends AppCompatActivity {
    TextInputEditText editPrecoAlcool, editPrecoGasolina;
    TextView textoResultado;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }

    public void calcularPreco(View view) {
        //Referenciando as variaveis
        textoResultado = findViewById(R.id.textResultado);
        editPrecoAlcool = findViewById(R.id.editPrecoAlcool);
        editPrecoGasolina = findViewById(R.id.editPrecoGasolina);

        // Recuperando valores das caixas de textos
        String precoAlcool = editPrecoAlcool.getText().toString();
        String precoGasolina = editPrecoGasolina.getText().toString();

        // Validação das caixas de texto
        boolean camposValidado = validarCampos(precoAlcool, precoGasolina);
        if (camposValidado) {

            // Transformando de String para Double

            double valorAlcool = Double.parseDouble(precoAlcool);
            double valorGasolina = Double.parseDouble(precoGasolina);

            //Calculo para saber...
            double resultadofinal = valorAlcool / valorGasolina;
            if (resultadofinal >= 7) {
                textoResultado.setText("Gasolina é a melhor opção");
            } else {
                textoResultado.setText("Alcool é a melhor opção");
            }


        } else {
            textoResultado.setText("Digite os valores nos campos acima");
        }


    }

    public Boolean validarCampos(String precoAlcool, String precoGasolina) {
        boolean camposValidar = true;
        if (precoAlcool == null || precoAlcool.equals("")) {
            camposValidar = false;
        } else if (precoGasolina == null || precoGasolina.equals("")) {
            camposValidar = false;
        }
        return camposValidar;
    }


}

