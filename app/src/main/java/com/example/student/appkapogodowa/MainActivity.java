package com.example.student.appkapogodowa;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import butterknife.BindView;
import butterknife.OnClick;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity {

    @BindView(R.id.Et_WpiszMiasto)
    EditText Et_WpiszMiasto ;

    @BindView(R.id.btn_zmienMiejsce)
    Button btn_zmienMiejsce ;

    @BindView(R.id.btn_lista)
    Button btn_lista ;

    @BindView(R.id.txtv_NazwaMiasta)
    TextView txtv_NazwaMiasta ;

    @BindView(R.id.obrazek)
    ImageView obrazek;

    @OnClick(R.id.btn_zmienMiejsce)
    void onClick(View view){

        String nowe = Et_WpiszMiasto.getText().toString();
        txtv_NazwaMiasta.setText(nowe);
    }



    @OnClick(R.id.btn_lista)
    void onClick2(View view){

        Intent intent = new Intent( MainActivity.this, Main2Activity.class);
        Bundle bundle = new Bundle();
        String wpisanyTekst = Et_WpiszMiasto.getText().toString();
        bundle.putString("KEY", wpisanyTekst);
        intent.putExtras(bundle);
        startActivity(intent);

    }
    private void LoadImage(){
String intentUrl = "http://www.autokomisy.gniezno.pl/blog/obrazy/podstrony/pogoda_gniezno1.jpg";
        Glide.with(this)
                .load(intentUrl)
                .into(obrazek);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);







    }

}
