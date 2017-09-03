package com.example.mateus.hulksmash;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.ActionMode;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import static android.widget.Toast.*;

public class HulkSmashAct extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hulk_smash);
        Log.v("CicloVida","onCreate()");
        Button bt = (Button) findViewById(R.id.button2);
        bt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent it = new Intent(HulkSmashAct.this, Smash.class);
                startActivity(it);
                onStop();
            }
        });
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.d("CicloVida","onStart()");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.i("CicloVida","onResume()");
    }
    @Override
    protected void onPause(){
        super.onPause();
        Log.w("CicloVida","onPause()");
    }
    @Override
    protected void onStop(){
        super.onStop();
        Log.i("CicloVida","onStop()");
    }
    @Override
    protected  void onRestart(){
        super.onRestart();
        Log.w("CicloVida","onCreate()");
    }
    @Override
    protected void onDestroy(){
        super.onDestroy();
        Log.e("CicloVida","onDestroy()");
    }
}
