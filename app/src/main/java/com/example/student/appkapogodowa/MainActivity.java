package com.example.student.appkapogodowa;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final EditText zmien = findViewById(R.id.Et_WpiszMiasto);
        Button przycisk = findViewById(R.id.btn_zmienMiejsce);
        Button lista = findViewById(R.id.btn_lista);
        final TextView miasto =  findViewById(R.id.txtv_NazwaMiasta);


        przycisk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
            String nowe = zmien.getText().toString();
            miasto.setText(nowe);
            }
        });

    
    }

}
