package com.example.mateus.projetoroomorm;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;

import java.sql.Blob;


@Entity(tableName = "Contatos")
public class Contatos {

        @PrimaryKey(autoGenerate = true)
        private int _id;

        @ColumnInfo(name = "nome")
        private String nome;

        @ColumnInfo(name = "telefone")
        private String telefone;

        @ColumnInfo(name = "informacao")
        private String informacao;

        @ColumnInfo(name = "idade")
        private String idade;


        //getSetters
        public int get_id() {
            return _id;
        }

        public void set_id(int id) {
            this._id = id;
        }

        public String getNome() {
            return nome;
        }

        public void setNome(String nome) {
            this.nome = nome;
        }

        public String getTelefone() {
            return telefone;
        }

        public void setTelefone(String telefone) {
            this.telefone = telefone;
        }

        public String getInformacao() {
            return informacao;
        }

        public void setInformacao(String informacao) {
            this.informacao = informacao;
        }

        public String getIdade(){
            return idade;
        }

        public void setIdade(String idade) {
            this.idade = idade;
        }

    @Override
    public String toString() {
        return  "Nome: "+ nome+
                " Telefone: " + telefone +
                " Informacao: " + informacao +
                " Idade: " + idade;
    }
}

