package br.com.wanderarce.myapplication.activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import java.util.Date;

import br.com.wanderarce.myapplication.R;
import br.com.wanderarce.myapplication.fragments.AboutFragment;
import br.com.wanderarce.myapplication.fragments.FirstFragment;
import br.com.wanderarce.myapplication.fragments.SecondFragment;

public class MainActivity extends AppCompatActivity {

    Button firstButton, secondButton, aboutButton;
    FirstFragment firstFragment;
    SecondFragment secondFragment;
    AboutFragment aboutFragment;

    @Override
    protected void onDestroy() {
        Log.i("recycler_onDestroy", new Date().toString());
        super.onDestroy();
    }

    @Override
    protected void onStop() {
        Log.i("recycler_onStop", new Date().toString());
        super.onStop();
    }

    @Override
    protected void onRestart() {
        Log.i("recycler_onRestart", new Date().toString());
        super.onRestart();
    }

    @Override
    protected void onResume() {
        Log.i("recycler_onResume", new Date().toString());
        super.onResume();
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Log.i("recycler_onCreate", new Date().toString());
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        // Instancie os elementos
        firstButton = findViewById(R.id.firstButton);
        secondButton = findViewById(R.id.secondButton);
        aboutButton = findViewById(R.id.aboutButton);
        // Instancie os Fragments que deseja usar
        firstFragment = new FirstFragment();
        secondFragment = new SecondFragment();
        aboutFragment = new AboutFragment();
        renderFragment(firstFragment);

        firstButton.setOnClickListener(v -> renderFragment(firstFragment));


        secondButton.setOnClickListener(v -> renderFragment(secondFragment));

        aboutButton.setOnClickListener(v -> renderFragment(aboutFragment) );

    }

    private void renderFragment(Fragment fragment) {
        //Crie a transacao
        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
        // Informe o recipiente e o Fragment
        fragmentTransaction.replace(R.id.frameLayout, fragment);
        // Commit a transaction
        fragmentTransaction.commit();
    }

    public void renderRecyclerView(View view) {
        Intent intent = new Intent(this, RecyclerActivity.class);
        startActivity(intent);
    }


}