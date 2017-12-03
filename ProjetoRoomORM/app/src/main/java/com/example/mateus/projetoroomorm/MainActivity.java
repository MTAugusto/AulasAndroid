package com.example.mateus.projetoroomorm;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.sql.Blob;

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    @Override
    protected void onStart() {
        super.onStart();
        IniciaLista();
    }

    @Override
    protected void onResume() {
        super.onResume();
        final AppContatos db = AppContatos.getAppDatabase(this);

        final ListView lv = findViewById(R.id.ListView);
        lv.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> adapterView, View view, int position, long _id) {
                final Contatos contatinhos = (Contatos) adapterView.getItemAtPosition(position);
                atualizarDados(contatinhos);
                final Button ll = (Button) findViewById(R.id.btn_deletar);
                ll.setEnabled(true);

                ll.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        db.ContatosDao().deleteContatinho(contatinhos);

                        LimpaTela();
                        IniciaLista();
                        ll.setEnabled(false);
                    }
                });
                return true;
            }
        });

        Button btnInserir = (Button) findViewById(R.id.btn_inserir);
        btnInserir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EditText tx1 = (EditText) findViewById(R.id.tx_nome);
                String nome =  tx1.getText().toString();
                EditText tx2 = (EditText) findViewById(R.id.tx_telefone);
                String telefone =  tx2.getText().toString();
                EditText tx3 = (EditText) findViewById(R.id.tx_idade);
                String idade =  tx3.getText().toString();
                EditText tx4 = (EditText) findViewById(R.id.tx_informacao);
                String informacao =  tx4.getText().toString();


                if (nome.equals("")  || telefone.equals("") || idade.equals("") || informacao.equals("")){

                    Context context = getApplicationContext();
                    CharSequence text = "Os campos possuem valores nulos, favor informar todos os campos!";
                    int duration = Toast.LENGTH_SHORT;

                    Toast toast = Toast.makeText(context, text, duration);
                    toast.show();
                }
                else{

                    Contatos continho = new Contatos();
                    continho.setNome(nome);
                    continho.setTelefone(telefone);
                    continho.setInformacao(informacao);
                    continho.setIdade(idade);
                    db.ContatosDao().insertContatos(continho);
                }

                LimpaTela();
                IniciaLista();
            }
        });

    }
    protected void atualizarDados(final Contatos contatinhos){
        final AppContatos db = AppContatos.getAppDatabase(this);
        final int idDados = contatinhos.get_id();

        EditText tx1 = (EditText) findViewById(R.id.tx_nome);
        tx1.setText(contatinhos.getNome());

        EditText tx2 = (EditText) findViewById(R.id.tx_telefone);
        tx2.setText(contatinhos.getTelefone());

        EditText tx3 = (EditText) findViewById(R.id.tx_idade);
        tx3.setText(String.valueOf(contatinhos.getIdade()));

        EditText tx4 = (EditText) findViewById(R.id.tx_informacao);
        tx4.setText(contatinhos.getInformacao());

        Button atualizadados = (Button) findViewById(R.id.btn_inserir);
        atualizadados.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EditText tx1 = (EditText) findViewById(R.id.tx_nome);
                final String nome =  tx1.getText().toString();

                EditText tx2 = (EditText) findViewById(R.id.tx_telefone);
                final String telefone =  tx2.getText().toString();

                EditText tx3 = (EditText) findViewById(R.id.tx_idade);
                final String idade = tx3.getText().toString();

                EditText tx4 = (EditText) findViewById(R.id.tx_informacao);
                final String informacao =  tx4.getText().toString();

                db.ContatosDao().alterarDados(nome,telefone,idade,informacao,idDados);

                LimpaTela();
                IniciaLista();
                final Button ll = (Button) findViewById(R.id.btn_deletar);
                ll.setEnabled(false);
                onResume();
            }

        });

    }

    protected void IniciaLista(){
        final AppContatos db = AppContatos.getAppDatabase(this);
        Contatos[] todoscontatos =  db.ContatosDao().loadAllContatos();
        ListView lv = findViewById(R.id.ListView);
        ArrayAdapter<Contatos> contatinhos = new ArrayAdapter
                <>(this, android.R.layout.simple_expandable_list_item_1, todoscontatos);
        lv.setAdapter(contatinhos);
    }

    protected void LimpaTela(){

        ((EditText) findViewById(R.id.tx_nome)).setText("");
        ((EditText) findViewById(R.id.tx_telefone)).setText("");
        ((EditText) findViewById(R.id.tx_idade)).setText("");
        ((EditText) findViewById(R.id.tx_informacao)).setText("");
    }
}
