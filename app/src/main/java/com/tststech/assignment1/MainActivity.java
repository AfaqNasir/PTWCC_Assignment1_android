package com.tststech.assignment1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;


public class MainActivity extends AppCompatActivity
{
    EditText enterTemp;
    Button btnSubmit;
    TextView appOutput;
    String emptyError;
    String result = "\0";
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        enterTemp = findViewById(R.id.enterTemp);
        btnSubmit = findViewById(R.id.btnSubmit);
        appOutput = findViewById(R.id.appOutput);

        appOutput.setVisibility(View.GONE);

        btnSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String temp = enterTemp.getText().toString().trim();
                emptyError = getString(R.string.emptyerror);

                try {
                    int chirps = Integer.parseInt(temp);
                    String error;
                    if (chirps <= 0) {
                        error = getString(R.string.error);
                        appOutput.setVisibility(View.VISIBLE);
                        appOutput.setText(error);

                    } else {
                        appOutput.setVisibility(View.VISIBLE);
                        result = String.valueOf(((chirps / 3) + 4));
                        String completeResult = getString(R.string.textTemp) + result + getString(R.string.cel);
                        appOutput.setText(completeResult);
                    }


                }catch (Exception e) {
                    appOutput.setVisibility(View.VISIBLE);
                    appOutput.setText(emptyError);}
            }
        });
    }

}