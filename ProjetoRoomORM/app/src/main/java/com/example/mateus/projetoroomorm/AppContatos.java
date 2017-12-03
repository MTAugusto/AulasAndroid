package com.example.mateus.projetoroomorm;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.Room;
import android.arch.persistence.room.RoomDatabase;
import android.content.Context;

/**
 * Created by mateus on 30/11/17.
 */
@Database(entities = {Contatos.class}, version = 1)
public abstract class AppContatos extends RoomDatabase {

    private static AppContatos INSTANCE;

    public abstract ContatosDao ContatosDao();

    public static AppContatos getAppDatabase(Context context) {
        if (INSTANCE == null) {
            INSTANCE =
                    Room.databaseBuilder(context.getApplicationContext(), AppContatos.class, "BancoContatinhos")
                            .allowMainThreadQueries()
                            .build();
        }
        return INSTANCE;
    }

    public static void destroyInstance() {
        INSTANCE = null;
    }
}