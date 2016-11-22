package com.dev.izcax.hitungbensin.Fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;

import com.dev.izcax.hitungbensin.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class Tab1Fragment extends Fragment {


    public Tab1Fragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_tab1, container, false);
        final EditText edtjenis = (EditText)view.findViewById(R.id.edtjenis);
        final String[] gender = {"Jenis Motor","Bebek","Matic"};
        Spinner spinner = (Spinner)view.findViewById(R.id.spinermotor);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this.getActivity(), android.R.layout.simple_spinner_item, gender);
        adapter.setDropDownViewResource(android.R.layout.simple_dropdown_item_1line);
        spinner.setAdapter(adapter);
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                String  jk = gender[position].toString();
                //Intent i = new Intent(getContext(), MainActivity.class);
                //i.putExtra(JK, jk);
                //startActivity(i);
                edtjenis.setText(jk);
                //txtpilih.setText(gender[position]);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
        return view;
    }

}
