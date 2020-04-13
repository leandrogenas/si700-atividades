package br.unicamp.ft.l201039_l201253.atividade2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;

public class NovoToDo extends AppCompatActivity {

    protected EditText conteudoToDo;
    protected RadioGroup prioridadeToDo;
    protected CheckBox notificar;
    protected Spinner categorias;
    protected Button salvar;

    enum Prioridade{ ALTA, MÉDIA, BAIXA }

    final static class AcaoSalvarToDo implements View.OnClickListener {

        private final NovoToDo atividade;

        AcaoSalvarToDo(NovoToDo instancia)
        {
            atividade = instancia;
        }

        private String obterPrioridade()
        {
            RadioButton radioSelecionado =
                atividade.findViewById(atividade.prioridadeToDo.getCheckedRadioButtonId());

            return Prioridade
                    .valueOf(radioSelecionado.getText().toString().toUpperCase())
                    .name();
        }

        @Override
        public void onClick(View v)
        {
            Intent intent = new Intent(atividade, DetalheToDo.class);
            intent.putExtra(DadosToDo.TODO_CONTENT.name(), atividade.conteudoToDo.getText().toString());
            intent.putExtra(DadosToDo.TODO_PRIORITY.name(), obterPrioridade());
            intent.putExtra(DadosToDo.TODO_NOTIFICATION.name(), (atividade.notificar.isSelected()) ? "Sim" : "Não");
            intent.putExtra(DadosToDo.TODO_CATEGORY.name(), atividade.categorias.getSelectedItem().toString());
            atividade.startActivity(intent);
        }

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.todo_novo);

        // Carregar os elementos da tela nas variáveis
        conteudoToDo = findViewById(R.id.conteudo_todo);
        prioridadeToDo = findViewById(R.id.prioridade_todo);
        notificar = findViewById(R.id.notificar);
        categorias = findViewById(R.id.categorias);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.todo_category, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        categorias.setAdapter(adapter);

        findViewById(R.id.salvar)
            .setOnClickListener(new AcaoSalvarToDo(this));

    }

    /*
    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        String text = parent.getItemAtPosition(position).toString();
        Toast.makeText(parent.getContext(), text, Toast.LENGTH_SHORT).show();
    }
     */

    /*
    public void save() {
        String inputContent = findViewById(R.id.todo_content).toString();
        String inputPriority = findViewById(R.id.todo_priority).toString();
        String inputNotification = findViewById(R.id.todo_notification).toString();
        String inputCategory = findViewById(R.id.todo_category_input).toString();

        Intent intent = new Intent(getBaseContext(), DetalhesNota.class);
        intent.putExtra("TODO_CONTENT", inputContent);
        intent.putExtra("TODO_PRIORITY", inputPriority);
        intent.putExtra("TODO_NOTIFICATION", inputNotification);
        intent.putExtra("TODO_CATEGORY", inputCategory);
    }
     */
};
