package com.example.mateus.hulksmash;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class Smash extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_smash);
        Log.v("CicloVida2","onCreate()");
        Button bt = (Button) findViewById(R.id.button);
        bt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent it = new Intent(Smash.this, HulkSmashAct.class);
                startActivity(it);
                onDestroy();
            }
        });
    }
    @Override
    protected void onStart() {
        super.onStart();
        Log.d("CicloVida2","onStart()");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.i("CicloVida2","onResume()");
    }
    @Override
    protected void onPause(){
        super.onPause();
        Log.w("CicloVida2","onPause()");
    }
    @Override
    protected void onStop(){
        super.onStop();
        Log.i("CicloVida2","onStop()");
    }
    @Override
    protected  void onRestart(){
        super.onRestart();
        Log.w("CicloVida2","onCreate()");
    }
    @Override
    protected void onDestroy(){
        super.onDestroy();
        Log.e("CicloVida2","onDestroy()");
    }
}
