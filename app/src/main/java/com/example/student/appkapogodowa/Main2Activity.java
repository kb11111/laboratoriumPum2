package com.example.student.appkapogodowa;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;


public class Main2Activity extends AppCompatActivity {

    @BindView(R.id.recyclerView)
   RecyclerView recyclerView;

    @BindView(R.id.txtv_result)
    TextView txtv_result ;
    String place;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        ButterKnife.bind(this);

        Bundle przekazanedane = getIntent().getExtras();
        String przekazanytekst = przekazanedane.getString("KEY");
        txtv_result.setText(przekazanytekst);

       ArrayList<Place> places = new ArrayList<>();
        places.add(new Place("Warszawa","Stolica Polski"));
        places.add(new Place("Zakopane","Tatry"));
        places.add(new Place("Gliwice","Politechnika Śląska"));

        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(layoutManager);


        OnPlaceClick listener = (view, position) -> {

            place = places.get(position).getPlaceName();
            Intent intent = new Intent(getApplicationContext(), MainActivity.class);
            Bundle bundle = new Bundle();
            bundle.putString("Nazwa", place);
            intent.putExtras(bundle);
            startActivity(intent);
        };


        PlaceAdapter placeAdapter = new PlaceAdapter(places,  listener);
        recyclerView.setAdapter(placeAdapter);






    }


}
