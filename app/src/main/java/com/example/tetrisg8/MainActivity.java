package com.example.tetrisg8;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private Tablero tablero = new Tablero();
    private boolean derrota;
    private int puntuacion;
    private Pieza enjuego;
    
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
        this.gameView = new GameView(this);
        this.fichaView = new FichaView(this);

        LinearLayout gameLayout = (LinearLayout)findViewById(R.id.gameView);
        LinearLayout fichaLayout = (LinearLayout)findViewById(R.id.fichaView);

        gameLayout.addView(this.gameView);
        fichaLayout.addView(this.fichaView);
        
        //partida();
    }
    


    //move left
    public void moveLeft(View view) {
        if (tablero.ocupadoIzq(enjuego)){
            for (int i=0;i<4;i++){
                enjuego.pieza[i].setY(enjuego.pieza[i].getY()-1);
            }
        }
    }

    //move right
    public void moveRight(View view) {
        if (tablero.ocupadoDcha(enjuego)){
            for (int i=0;i<4;i++){
                enjuego.pieza[i].setY(enjuego.pieza[i].getY()+1);
            }
        }
    }

    //rotate
    public void rotateAction(View view) {
    }
}
