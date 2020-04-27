package br.unicamp.ft.l201039_l201253.atividade5;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.Arrays;


/**
 * A simple {@link Fragment} subclass.
 */
public class AlunosFragment extends Fragment {

    private RecyclerView recyclerView;
    private MyFirstAdapter myFirstAdapter;

    public AlunosFragment() { }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
    {
        View view = inflater.inflate(R.layout.fragment_alunos, container, false);
        recyclerView = view.findViewById(R.id.recycler_view);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));

        myFirstAdapter = new MyFirstAdapter(
            new ArrayList(Arrays.asList(Aluno.getAlunos(getContext())))
        );
        recyclerView.setAdapter(myFirstAdapter);

        return view;
    }
}
