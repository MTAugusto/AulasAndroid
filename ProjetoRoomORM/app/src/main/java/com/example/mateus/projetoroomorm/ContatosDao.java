package com.example.mateus.projetoroomorm;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.OnConflictStrategy;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.Update;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by mateus on 30/11/17.
 */
@Dao
public interface ContatosDao {

        @Insert(onConflict = OnConflictStrategy.REPLACE)
        public void insertContatos(Contatos inscont);

        @Query("Update Contatos set nome = :nome,telefone = :telefone, idade = :idade, informacao = :informacao where _id = :id")
        public void alterarDados(String nome, String telefone,String idade, String informacao,int id );

        @Delete
        public void deleteContatinho(Contatos delcont);

        @Query("SELECT * FROM Contatos")
        public Contatos[] loadAllContatos();

}
