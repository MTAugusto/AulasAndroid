package com.example.mateus.mateusaugusto;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import org.w3c.dom.Text;
import org.xml.sax.Parser;
import org.xml.sax.helpers.ParserAdapter;

public class MainActivity_Mateus extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main__mateus);
        Log.v("CicloVida","onCreate()");

    }


    public void btnCalcular(View btn_Calcular){

        TextView mensagem = (TextView) findViewById(R.id.text_mensagem);

        TextView tv = (TextView) findViewById(R.id.valor_alcoool);
        Float valoralcool = Float.parseFloat(tv.getText().toString());

        TextView tv2 = (TextView) findViewById(R.id.valor_gasolina);
        Float valorgasolina = Float.parseFloat(tv2.getText().toString());

        Float melhorresultado =  valoralcool / valorgasolina;

        if (melhorresultado <= 0.7){
            mensagem.setText("Vai de Alcool");
        }else {
            mensagem.setText("Vai de Gasolina");
        }

    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.d("Prova","onStart()");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.i("Prova","onResume()");
    }
    @Override
    protected void onPause(){
        super.onPause();
        Log.w("Prova","onPause()");
    }
    @Override
    protected void onStop(){
        super.onStop();
        Log.i("Prova","onStop()");
    }
    @Override
    protected  void onRestart(){
        super.onRestart();
        Log.w("Prova","onCreate()");
    }
    @Override
    protected void onDestroy(){
        super.onDestroy();
        Log.e("Prova","onDestroy()");
    }


}

