package com.example.student.appkapogodowa;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity {

    @BindView(R.id.Et_WpiszMiasto)
    EditText Et_WpiszMiasto ;

    @BindView(R.id.btn_zmienMiejsce)
    Button btn_zmienMiejsce;

    @BindView(R.id.btn_lista)
    Button btn_lista;

    @BindView(R.id.txtv_NazwaMiasta)
    TextView   txtv_NazwaMiasta;

    @BindView(R.id.recyclerView)
    RecyclerView recyclerView;

    @OnClick(R.id.Et_WpiszMiasto)
    void onClick(View view){

            String nowe = Et_WpiszMiasto.getText().toString();
        txtv_NazwaMiasta.setText(nowe);
    }

    @OnClick(R.id.btn_lista)
    void onClick2(View view){

        Intent intent = new Intent( MainActivity.this, Main2Activity.class);
        startActivity(intent);
        Bundle bundle = new Bundle();
        bundle.putString("zmien","miasto");
        intent.putExtras(bundle);
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);







    }

}
