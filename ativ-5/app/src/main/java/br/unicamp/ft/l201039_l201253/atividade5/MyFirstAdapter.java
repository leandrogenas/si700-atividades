package br.unicamp.ft.l201039_l201253.atividade5;

import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import org.w3c.dom.Text;

import java.util.ArrayList;

import br.unicamp.ft.l201039_l201253.atividade5.AlunosFragment;
import br.unicamp.ft.l201039_l201253.atividade5.R;

public class MyFirstAdapter extends RecyclerView.Adapter {

    private MyFirstAdapter teste;
    private ArrayList<Aluno> alunos;
    public MyFirstAdapter(ArrayList alunos){
        this.alunos = alunos;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull final ViewGroup parent, int viewType) {
        teste = this;
        View view = LayoutInflater.from(parent.getContext()).inflate(
                R.layout.adapter_layout, parent, false);

        view.setOnLongClickListener(new View.OnLongClickListener(){
                                    @Override
                                    public boolean onLongClick(View v) {
                                        v.setVisibility(View.GONE);
                                        ViewGroup.LayoutParams params = v.getLayoutParams();
                                        params.height = 0;
                                        v.setLayoutParams(params);

                                        return true;
                                    }
                                }
        );

        return new MyFirstViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        ((MyFirstViewHolder)holder).bind(alunos.get(position));
    }

    @Override
    public int getItemCount() {
        return alunos.size();
    }


    /*
    Definindo a interface para disparar gatilhos de OnItemClick
     */
    public interface MyFirstAdapterOnItemClickListener{
        void myFirstAdapterOnItemClick(String nome);
    }
    // Declarei o atributo
    private MyFirstAdapterOnItemClickListener myFirstAdapterOnItemClickListener;

    // Atribuo a instância para o atributo.
    public void setMyFirstAdapterOnItemClickListener(MyFirstAdapterOnItemClickListener m){
        this.myFirstAdapterOnItemClickListener = m;
    }
    /*  End */




    static class MyFirstViewHolder extends RecyclerView.ViewHolder {
        private ImageView foto;
        private TextView nome;
        private TextView idade;

        public MyFirstViewHolder(@NonNull View itemView) {
            super(itemView);
            foto = itemView.findViewById(R.id.foto);
            nome = itemView.findViewById(R.id.nome);
            idade = itemView.findViewById(R.id.idade);

        }

        public void bind(Aluno aluno){
            foto.setImageResource(aluno.getFoto());
            nome.setText(aluno.getNome());
            idade.setText(aluno.getIdade() + " anos");
            if(aluno.getTipo() == 1)
                itemView.findViewById(R.id.linha)
                    .setBackgroundColor(Color.parseColor("#00bcd4"));
        }
    }
}

















