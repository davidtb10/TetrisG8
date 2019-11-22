package com.example.tetrisg8;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

//Ventana inicial de arranque

public class TakePhoto extends AppCompatActivity {
    private FuncionamientoJuego start;
    int puntuacion;
    int tiempo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.click_photo);
        //Para poder cerrar el activity desde otra ventana
         puntuacion = getIntent().getExtras().getInt("puntuacion");
        //Mostramos la puntuación
        tiempo = getIntent().getExtras().getInt("tiempo");
    }

    public void foto(View view) {
        Intent goToMain = new Intent(this, GameOverActivity.class);
        goToMain.putExtra("puntuacion", puntuacion);
        goToMain.putExtra("tiempo", tiempo);
        startActivity(goToMain);
        finish();

    }
}
