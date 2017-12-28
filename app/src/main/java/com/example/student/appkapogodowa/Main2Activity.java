package com.example.student.appkapogodowa;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;

import butterknife.BindView;

public class Main2Activity extends AppCompatActivity {

    @BindView(R.id.recyclerView)
    RecyclerView recyclerView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        ArrayList<Place> places = new ArrayList<>();
        places.add(new Place("Zawiercie", 5,"tu mieszkam"));
        places.add(new Place("Gliwice", 6,"tu jest polsl"));

        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(layoutManager);

        PlaceAdapter placeAdapter = new PlaceAdapter(places);
        recyclerView.setAdapter(placeAdapter);
    }
}
