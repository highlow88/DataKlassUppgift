package com.example.dataklassuppgift;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.Person;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements  RecycleViewInterface{

    ArrayList<PersonModel> personModels = new ArrayList<>();

    int[] personImages = {R.drawable.baseline_person_24, R.drawable.baseline_woman_24, R.drawable.baseline_man_24};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        RecyclerView recyclerView = findViewById(R.id.mRecycleView);

        setUpPersonModel();

        Person_recycleViewAdapter adapter = new Person_recycleViewAdapter(this, personModels, this);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));


    }

    private void setUpPersonModel() {

        String[] personNames = getResources().getStringArray(R.array.Person);
        String[] personAge = getResources().getStringArray(R.array.Age);
        String[] personAddress = getResources().getStringArray(R.array.Address);

        for (int i = 0; i < personNames.length; i++) {
            personModels.add(new PersonModel(personNames[i],
                    personAge[i],
                    personAddress[i],
                    personImages[i]));
        }
    }

    @Override
    public void onItemClick(int position) {

    }
}