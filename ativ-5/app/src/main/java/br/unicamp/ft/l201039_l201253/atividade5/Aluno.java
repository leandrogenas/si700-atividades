package br.unicamp.ft.l201039_l201253.atividade5;

import android.content.Context;
import android.content.res.TypedArray;

import br.unicamp.ft.l201039_l201253.atividade5.R;

public class Aluno {
    private String nome;
    private int foto;
    private int idade;
    private int tipo;

    public Aluno(String nome, int idade, int tipo, int foto){
        this.nome = nome;
        this.idade = idade;
        this.tipo = tipo;
        this.foto = foto;
    }

    public String getNome(){return nome;}
    public int getFoto(){return foto;}
    public int getIdade(){return idade;}
    public int getTipo(){return tipo;}

    public static Aluno[] getAlunos(Context context){
        if (context != null){
            String[] infos   = context.getResources().getStringArray(R.array.nomes);
//            TypedArray fotos = context.getResources().obtainTypedArray(R.array.fotos);

            Aluno[] alunos = new Aluno[infos.length];
            for (int i = 0; i < alunos.length; i++){
                String[] info = infos[i].split(",");
                alunos[i]= new Aluno(
                    info[0],
                    Integer.parseInt(info[1]),
                    Integer.parseInt(info[2]),
                    R.drawable.pessoa_default
                );
            }
//            fotos.recycle();
            return alunos;
        }
        return null;
    }

    @Override
    public boolean equals(Object o)
    {
        return ((Aluno) o).getNome().equals(this.getNome());
    }

}
