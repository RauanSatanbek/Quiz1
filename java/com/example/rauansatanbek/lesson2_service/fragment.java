package com.example.rauansatanbek.lesson2_service;

import android.app.Activity;
import android.app.Fragment;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class fragment extends Fragment implements View.OnClickListener{
    Button goTo2, goTo3, finish;
    EditText text;
    TextView textFrom1;
    int layout;
    FragmentTransaction ft;
    int which;
    fragment(int layout, int which) {
        this.layout = layout;
        this.which = which;
    }

    public interface ChangeLayout{
        void change(String Text);
    }

    ChangeLayout changeLayout;

    @Override
    public void onAttach(Activity context) {
        changeLayout = (ChangeLayout)context;
        super.onAttach(context);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(layout, null);
        switch (which) {
            case 1:
                goTo2 = (Button) view.findViewById(R.id.goTo2);
                goTo2.setOnClickListener(this);
                text = (EditText) view.findViewById(R.id.text);
                break;
            case 2:
                goTo3 = (Button) view.findViewById(R.id.goTo3);
                goTo3.setOnClickListener(this);
                textFrom1 = (TextView) view.findViewById(R.id.textFrom1);
                break;
            case 3:
                finish = (Button) view.findViewById(R.id.finish);
                finish.setOnClickListener(this);
                break;
        }


        return view;
    }


    @Override
    public void onClick(View v) {
        ft = getFragmentManager().beginTransaction();
        switch (v.getId()) {
            case R.id.goTo2:
                ft.replace(R.id.container, new fragment(R.layout.fragment2, 2));
                changeLayout.change(text.getText().toString());
                break;
            case R.id.goTo3:
                ft.replace(R.id.container, new fragment(R.layout.fragment3, 3));
                break;
            case R.id.finish:
                break;
        }
        ft.commit();
    }


}
