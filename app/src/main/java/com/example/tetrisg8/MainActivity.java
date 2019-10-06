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
        
        partida();
    }
    
    public void partida(){
        enjuego = fichaView.generarPieza();
        puntuacion = 0;
        derrota = false;
        FuncionamientoJuego funcionamiento = new FuncionamientoJuego();
        tablero.inicializarTablero();
        this.caja_score.setText("0");
        while(!derrota){
            //crear pieza nueva
            derrota = funcionamiento.finJuego(tablero, piezaAct); //comprueba si la pieza nueva entra en el tablero
            if (! derrota) {
                    //pintar la pieza
                    //acciones de mover pieza durante x tiempo ?
                    //si no se produce ninguna acción:
                    if (! tablero.ocupadoBajar(piezaAct)) { //si se puede se baja la pieza si no se fija
                        tablero.bajarPieza(piezaAct);
                    }
                    else{
                        //se fija la pieza
                        puntuacion = funcionamiento.actualizarPuntuacion(puntuacion, tablero, piezaAct); //se comprueba si se han completado lineas y se actualiza la puntuacion
                        //eliminar las lineas llenas y bajar las lineas superiores
                        /*
                        caja_score.setText(String.valueOf(puntuacion));
                        */
                    }

            }
        }
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
