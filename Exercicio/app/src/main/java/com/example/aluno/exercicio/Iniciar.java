package com.example.aluno.exercicio;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Iniciar extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_iniciar);

        Button vamos = findViewById(R.id.vamos);
        Button salas = findViewById(R.id.salas);
        Button ranking = findViewById(R.id.ranking);
        Button addquestionario = findViewById(R.id.addquestionario);
        Button sair = findViewById(R.id.sair);
        Button creditos = findViewById(R.id.creditos);

        vamos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent it = new Intent(Iniciar.this, Perguntas.class);
                startActivity(it);
            }
        });
        salas.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent it = new Intent(Iniciar.this,Salas.class);
                startActivity(it);
            }
        });

        ranking.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent it = new Intent(Iniciar.this, Ranking.class);
                startActivity(it);
            }
        });

        addquestionario.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent it = new Intent(Iniciar.this, NovasQuestoes.class);
                startActivity(it);
            }
        });

        sair.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

        creditos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent it = new Intent(Iniciar.this, Creditos.class);
                startActivity(it);
            }
        });

    }
}
