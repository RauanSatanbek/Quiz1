package com.example.rauansatanbek.lesson2_service;

import android.app.Fragment;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements fragment.ChangeText, fragment.UpdateText, fragment.Destroy{
    FragmentTransaction ft;
    DialogFragment myAlert;
    String Text = "";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ft = getFragmentManager().beginTransaction();
        ft.add(R.id.container, new fragment(R.layout.fragment1, 1));
        ft.commit();

    }

    @Override
    public void changeText(String Text) {
        this.Text = Text;
//        myAlert = new MyAlert(1, Text);
//        myAlert.show(getSupportFragmentManager(), "alert");
    }

    @Override
    public void updateText() {
        Log.d("MyLogs", "Hello");
        Fragment frag1 = getFragmentManager().findFragmentById(R.id.container);
        ((TextView) frag1.getView().findViewById(R.id.textFrom1))
                .setText(Text);
    }

    @Override
    protected void onDestroy() {
        Log.d("MyLogs", "onDestroy");
        super.onDestroy();
        finish();
    }

    @Override
    public void destroy() {
        Log.d("MyLogs", "destroy");
        onDestroy();
    }

    //    public static class MyAlert extends DialogFragment implements AlertDialog.OnClickListener{
//        int which;
//        String Text;
//        MyAlert (int which, String Text) {
//            this.which = which;
//            this.Text = Text;
//        }
//        @NonNull
//        @Override
//        public Dialog onCreateDialog(Bundle savedInstanceState) {
//            AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
//
//            builder.setMessage("Are you sure ?");
//            builder.setNegativeButton("NO", this);
//            builder.setPositiveButton("YES", this);
//            return builder.create();
//        }
//
//        @Override
//        public void onClick(DialogInterface dialog, int button) {
//            switch (which) {
//                case 1:
//                    android.support.v4.app.Fragment frag1 = getFragmentManager().findFragmentById(R.id.container);
//                    ((TextView) frag1.getView().findViewById(R.id.textFrom1))
//                            .setText(Text);
//                    break;
//            }
//            Log.d("MYLogs", "Which: " + which);
//        }
//    }
}
