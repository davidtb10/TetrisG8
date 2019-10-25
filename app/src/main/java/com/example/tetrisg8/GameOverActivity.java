package com.example.tetrisg8;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class GameOverActivity extends AppCompatActivity implements View.OnClickListener {
    TextView textViewPuntuacion;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.game_over);
        //Recibimos la puntuación del main
        int puntuacion = getIntent().getExtras().getInt("puntuacion");
        //Mostramos la puntuación
        textViewPuntuacion = (TextView) findViewById(R.id.score);
        textViewPuntuacion.setText(String.valueOf(puntuacion));
        Button botonSalir = (Button) this.findViewById(R.id.botSalir);
        botonSalir.setOnClickListener(this);
        Button botonJugar = (Button) this.findViewById(R.id.botJugar);
        botonJugar.setOnClickListener(this);
    }

    @Override
    public void onBackPressed() {
        //Impedimos que se pueda salir de la ventana al pulsar el botón de atrás del movil
    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.botSalir) {
            StartGame.ventanaInicio.finish();
            finish();
        } else {
            finish();
        }
    }
}
