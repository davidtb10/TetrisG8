package com.example.tetrisg8;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

    //Ventana inicial de arranque

public class StartGame extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start_game);

    }

    public void jugar(View view) {
        Intent goToMain = new Intent(this,MainActivity.class);
        startActivity(goToMain);
    }
}
