package com.example.mateus.calculadoramain;

import android.content.Context;
import android.support.v4.app.SupportActivity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.towel.math.Expression;
import com.towel.swing.table.TableFilter;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MainActivityCalc extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_calc);
    }

    public void buttonOnClick(View calculo){

        TextView tv = (TextView) findViewById(R.id.plaintext_calc);
        String texto = tv.getText().toString();

        Pattern p = Pattern.compile("/^[0-9]{1,}$/");
        Matcher m = p.matcher(texto);

        if (!texto.equals("")) {

           Expression e = new Expression(texto);
           double result = e.resolve();

           TextView total = (TextView) findViewById(R.id.total);
           total.setText(String.valueOf(result));

            tv.setText("");
       }else {

           Context context = getApplicationContext();
           CharSequence text = "Digita uma expressão animal!";
           int duration = Toast.LENGTH_SHORT;

           Toast toast = Toast.makeText(context, text, duration);
           toast.show();

       }
    }


}
