package br.unicamp.ft.l201039_l201253.atividade5;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import org.w3c.dom.Text;

import java.util.ArrayList;

import br.unicamp.ft.l201039_l201253.atividade5.AlunosFragment;
import br.unicamp.ft.l201039_l201253.atividade5.R;

public class MyFirstAdapter extends RecyclerView.Adapter {

    private ArrayList<Aluno> alunos;
    public MyFirstAdapter(ArrayList alunos){
        this.alunos = alunos;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull final ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(
                R.layout.adapter_layout, parent, false);


        view.setOnClickListener(new View.OnClickListener(){
                                    @Override
                                    public void onClick(View v) {
                                        if (myFirstAdapterOnItemClickListener != null){
                                            TextView txt = v.findViewById(R.id.text_view);
                                            myFirstAdapterOnItemClickListener.myFirstAdapterOnItemClick(txt.getText().toString());
                                        }
                                       // Toast.makeText(parent.getContext(), "ASDF", Toast.LENGTH_SHORT).show();
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
        private ImageView imageView;
        private TextView  textView;

        public MyFirstViewHolder(@NonNull View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.image_view);
            textView  = itemView.findViewById(R.id.text_view);
        }

        public void bind(Aluno aluno){
            imageView.setImageResource(aluno.getFoto());
            textView.setText(aluno.getNome());
        }
    }
}
















