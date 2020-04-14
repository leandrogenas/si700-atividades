package br.unicamp.ft.l201039_l201253.atividade4;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.fragment.app.Fragment;


/**
 * A simple {@link Fragment} subclass.
 */
public class BiografiaFragment extends Fragment {

    public BiografiaFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_biografia, container, false);

        // Recebendo valores
        Bundle bundle = getArguments();

        if (bundle != null) {
            String msg = bundle.getString("msg", "");
            String dst = bundle.getString("dst", "");

            TextView txtMsg = view.findViewById(R.id.msg);
            TextView txtDst = view.findViewById(R.id.dst);

            txtMsg.setText(msg);
            txtDst.setText(dst);
        }
        return view;
    }
}
