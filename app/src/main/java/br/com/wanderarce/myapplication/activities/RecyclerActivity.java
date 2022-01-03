package br.com.wanderarce.myapplication.activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import br.com.wanderarce.myapplication.R;
import br.com.wanderarce.myapplication.adapters.MyAdapter;
import br.com.wanderarce.myapplication.entities.City;

import android.os.Bundle;
import android.widget.LinearLayout;

import java.util.ArrayList;
import java.util.List;

public class RecyclerActivity extends AppCompatActivity {

    RecyclerView recyclerView;

    private final List<City> cities = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycler);

        //Instanciar o RecycrecyclerViewlerView na Activity ou no Fragment
        recyclerView = findViewById(R.id.recyclerView);

        //carregar dados para mostrar
        loadCities();
        //Configurar o  Layout  com o LayoutManager- Linear
        RecyclerView.LayoutManager layoutManager= new LinearLayoutManager(getApplicationContext());

        recyclerView.setLayoutManager(layoutManager);

        //configura o layout que será atribuido a RecyclerView
        MyAdapter myAdapter = new MyAdapter(cities);
        recyclerView.setAdapter(myAdapter);

        //define que o tamanho do component sera fixo contribuindo com a performance do app
        recyclerView.setHasFixedSize(true);

        //adicionar Divider
        recyclerView.addItemDecoration(new DividerItemDecoration(this, LinearLayout.VERTICAL) );

    }

    private void loadCities() {
        cities.clear();
        City city = new City("Campo Grande");
        cities.add(city);

        city = new City("Curitiba");
        cities.add(city);

        city = new City("Cuiabá");
        cities.add(city);

        city = new City("Três Lagoas");
        cities.add(city);

        city = new City("Assunção");
        cities.add(city);

        city = new City("Bela Vista");
        cities.add(city);

        city = new City("Goiania");
        cities.add(city);

        city = new City("Texas");
        cities.add(city);

        city = new City("Londres");
        cities.add(city);

    }
}