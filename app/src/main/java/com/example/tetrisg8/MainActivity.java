package com.example.tetrisg8;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

    //Ventana principal en la que se jugará la partida

public class MainActivity extends AppCompatActivity {
    
    private FuncionamientoJuego start = new FuncionamientoJuego(); 
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
        this.inicializarTablero();
        this.gameView = new GameView(this,tab);
        this.fichaView = new FichaView(this);

        LinearLayout gameLayout = (LinearLayout)findViewById(R.id.gameView);
        LinearLayout fichaLayout = (LinearLayout)findViewById(R.id.fichaView);

        gameLayout.addView(this.gameView);
        fichaLayout.addView(this.fichaView);
        
        start.partida(this.caja_score, gameView, fichaView, tab);
    }
    


    //move left
    public void moveLeft(View view) {
        start.izquierda();
    }

    //move right
    public void moveRight(View view) {
        start.derecha();
    }

    //rotate
    public void rotateAction(View view) {
        //start.girar();
    }
}
