package com.example.tetrisg8;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

//Ventana inicial de arranque

public class StartGame extends AppCompatActivity {
    static Activity ventanaInicio;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start_game);
        //Para poder cerrar el activity desde otra ventana
        ventanaInicio = this;
    }

    public void jugar(View view) {
        Intent goToMain = new Intent(this,Alert.class);
        startActivity(goToMain);
    }
}

