package com.example.mateus.ead02;


import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.towel.math.Expression;

public class SegundaTela  extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_segundatela);

        Intent pegadados = getIntent();

        String expressao = getIntent().getStringExtra("expressao");
        String op = getIntent().getStringExtra("operacao");

        Expression resultado = new Expression(expressao);
        double result = resultado.resolve();

        TextView exp = (TextView) findViewById(R.id.t2_valordigitado);
        exp.setText(expressao);

        TextView operacao = (TextView) findViewById(R.id.t2_operacao);
        operacao.setText(op);

        TextView respostanatela = (TextView) findViewById(R.id.t2_resultado);
        respostanatela.setText(String.valueOf(result));

    }

    public void btnVoltar(View voltar){


        Intent it = new Intent(SegundaTela.this, MainActivity.class);
        startActivity(it);
        onDestroy();

    }


}
