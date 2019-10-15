package com.example.tetrisg8;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

    //Ventana principal en la que se jugará la partida

public class MainActivity extends AppCompatActivity {
    
    private FuncionamientoJuego start;
    private Tablero tab = new Tablero();
    private GameView gameView;
    private FichaView fichaView;
    private TextView caja_score;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        this.caja_score = (TextView)findViewById(R.id.caja_score);
        //to set score
        //this.caja_score.setText(String.valueOf());
        tab.inicializarTablero();
        this.gameView = new GameView(this, tab);
        this.fichaView = new FichaView(this);

        LinearLayout gameLayout = (LinearLayout)findViewById(R.id.gameView);
        LinearLayout fichaLayout = (LinearLayout)findViewById(R.id.fichaView);

        gameLayout.addView(this.gameView);
        fichaLayout.addView(this.fichaView);

        start = new FuncionamientoJuego(gameView, tab, this);
        
        start.partida();
    }

    //move left
    public void moveLeft(View view) {
        //Se intenta desplazar la ficha a la izquierda, si ha sido posible se actualiza el canvas
        if(tab.izquierda())
            gameView.invalidate();
    }

    //move right
    public void moveRight(View view) {
        //Se intenta desplazar la ficha a la derecha, si ha sido posible se actualiza el canvas
        if(tab.derecha())
            gameView.invalidate();
    }

    //rotate
    public void rotateAction(View view) {
        //start.girar();
    }

    public void pantallaGameOver(){
        Intent intent = new Intent(this,GameOverActivity.class);
        startActivity(intent);
    }
}
