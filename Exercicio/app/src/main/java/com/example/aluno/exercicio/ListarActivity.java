package com.example.aluno.exercicio;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class ListarActivity extends AppCompatActivity {

    ListView mListView;
    DataBaseHelper helper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listar);

        mListView = findViewById(R.id.lista);

        helper = new DataBaseHelper(this); // instancia Helper

        final SQLiteDatabase db = helper.getReadableDatabase(); // instancia BD em modo de leitura

        // Campos a serem lido do BD
        String[] campos = {
                DataBaseHelper.COLUMN_NAME_LOGIN
        };

        // Cursor contém o resultado da consulta
        Cursor cursor = db.query(DataBaseHelper.TABLE_NAME,campos,null,null,null,null,null);

        // Monta um ArrayList com os dados da consulta
        final ArrayList<String> nomes = new ArrayList<>();
        while (cursor.moveToNext()) { // enquanto houver dados para serem lidos, faça
//            adiciona no arraylist o dados lido do banco
            String login = cursor.getString(cursor.getColumnIndex("login"));
            nomes.add(login);
        }

        // Criar o adapter para listar os dados
        final ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1);
        adapter.addAll(nomes);

        // associa o Adapter a ListView
        mListView.setAdapter(adapter);

        mListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

                String p[] = new String[1];
                p[0] = nomes.get(i);
                db.delete(DataBaseHelper.TABLE_NAME,DataBaseHelper.COLUMN_NAME_LOGIN+"=?",p);
                nomes.remove(i);
                mListView.setAdapter(adapter);
                adapter.notifyDataSetChanged();
//                db.execSQL("DELETE FROM " + DataBaseHelper.TABLE_NAME + DataBaseHelper.COLUMN_NAME_LOGIN + "=" +nomes.get(i));
            }
        });

    }
}
