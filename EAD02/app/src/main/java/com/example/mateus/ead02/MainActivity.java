package com.example.mateus.ead02;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.Selection;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.towel.math.Expression;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void btnSoma(View soma){

        Button btn_calculo = (Button) findViewById(R.id.btn_soma);
        String btn = btn_calculo.getText().toString();

        TextView operacao = (TextView) findViewById(R.id.tx_operacao);
        operacao.setText(btn);
    }

    public void btnSubitracao(View subitracao){

        Button btn_calculo = (Button) findViewById(R.id.btn_subtracao);
        String btn = btn_calculo.getText().toString();

        TextView operacao = (TextView) findViewById(R.id.tx_operacao);
        operacao.setText(btn);
    }

    public void btnMultiplicacao(View multiplicacao){

        Button btn_calculo = (Button) findViewById(R.id.btn_multiplicacao);
        String btn = btn_calculo.getText().toString();

        TextView operacao = (TextView) findViewById(R.id.tx_operacao);
        operacao.setText(btn);

    }

    public void btnDivisao(View divisao){

        Button btn_calculo = (Button) findViewById(R.id.btn_divisao);
        String btn = btn_calculo.getText().toString();

        TextView operacao = (TextView) findViewById(R.id.tx_operacao);
        operacao.setText(btn);
    }


    public void onButtonCalcular(View v){

        TextView valor1 = (TextView) findViewById(R.id.vl_expressao);
        String v1 = valor1.getText().toString();

        TextView valor2 = (TextView) findViewById(R.id.vl_expressao2);
        String v2 = valor2.getText().toString();

        TextView operacao = (TextView) findViewById(R.id.tx_operacao);
        String op = operacao.getText().toString();

        String expressao = v1 + op + v2;

        Context context = getApplicationContext();
        int duration = Toast.LENGTH_SHORT;

        if (v1.equals("") || v1.equals(null)){

            CharSequence text = "Informe o primeiro Valor";
            Toast toast = Toast.makeText(context, text, duration);
            toast.show();

        } if (v2.equals("") || v2.equals(null)){

            CharSequence text = "Informe o segundo Valor";
            Toast toast = Toast.makeText(context, text, duration);
            toast.show();
        } else {

            Intent mudatela = new Intent(MainActivity.this, SegundaTela.class);
            mudatela.putExtra("expressao", expressao);
            mudatela.putExtra("operacao", op);
            startActivity(mudatela);
            onDestroy();
        }
    }
}
