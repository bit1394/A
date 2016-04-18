package ru.bitreslab.bonus;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.SeekBar;
import android.widget.TextView;

public class Main extends AppCompatActivity {
    EditText etName, et10, et13, et15, et10Total, et13Total, et15Total, etCustomSBar, etCustom, etCustomTotal;
    SeekBar sBar;

    private double n_etName;
    private int n_etCustomSBar;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);

        if (savedInstanceState == null) {
            n_etName = 0.0;
            n_etCustomSBar = 18;


        }
//        else {
//            n_etName = savedInstanceState.getDouble()
//        }
        //ищем объекты
        etName = (EditText) findViewById(R.id.etName);
        et10 = (EditText) findViewById(R.id.et10);
        et13 = (EditText)findViewById(R.id.et15);

    }
}
