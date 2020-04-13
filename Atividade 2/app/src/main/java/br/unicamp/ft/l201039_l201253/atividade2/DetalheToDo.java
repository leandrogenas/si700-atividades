package br.unicamp.ft.l201039_l201253.atividade2;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class DetalheToDo extends AppCompatActivity {

    protected TextView vlrConteudo;
    protected TextView vlrPrioridade;
    protected TextView vlrNotificar;
    protected TextView vlrCategoria;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.todo_detalhe);

        vlrConteudo = findViewById(R.id.vlr_conteudo);
        vlrPrioridade = findViewById(R.id.vlr_prioridade);
        vlrNotificar = findViewById(R.id.vlr_notificar);
        vlrCategoria = findViewById(R.id.vlr_categoria);

        carregarDadosToDo();
    }

    protected void carregarDadosToDo()
    {
        Intent it = getIntent();
        vlrConteudo.setText(it.getStringExtra(DadosToDo.TODO_CONTENT.name()));
        vlrPrioridade.setText(it.getStringExtra(DadosToDo.TODO_PRIORITY.name()));
        vlrNotificar.setText(it.getStringExtra(DadosToDo.TODO_NOTIFICATION.name()));
        vlrCategoria.setText(it.getStringExtra(DadosToDo.TODO_CATEGORY.name()));
    }
}
