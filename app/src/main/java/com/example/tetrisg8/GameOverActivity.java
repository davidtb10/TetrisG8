package com.example.tetrisg8;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

public class GameOverActivity extends AppCompatActivity implements View.OnClickListener {
    TextView textViewPuntuacion;
    TextView textViewTiempo;
    DatabaseClass myDb;
    Button btnviewAll;
    


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.game_over);
        //Recibimos la puntuación del main
        int puntuacion = getIntent().getExtras().getInt("puntuacion");
        //Mostramos la puntuación
        int tiempo = getIntent().getExtras().getInt("tiempo");
        DateFormat df = new SimpleDateFormat("mm:ss");
        //Mostramos la puntuación
        textViewPuntuacion = (TextView) findViewById(R.id.score);
        textViewPuntuacion.setText(String.valueOf(puntuacion));
        textViewTiempo = (TextView) findViewById(R.id.time);
        textViewTiempo.setText(String.valueOf( df.format(tiempo)));
        Button botonSalir = (Button) this.findViewById(R.id.botSalir);
        botonSalir.setOnClickListener(this);
        Button botonJugar = (Button) this.findViewById(R.id.botJugar);
        botonJugar.setOnClickListener(this);
        myDb = new DatabaseClass(this);
        btnviewAll = (Button) findViewById(R.id.button_viewAll);
        viewAll();
    }

    private void viewAll() {
        btnviewAll.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Cursor res = myDb.getAllData();
                        if (res.getCount() == 0) {
                            // show message
                            showMessage("Top Scores", "Nothing found");
                            return;
                        }
                       int cont=1;
                        StringBuffer buffer = new StringBuffer();
                        while (res.moveToNext()) {
                            buffer.append(cont+".");
                            buffer.append("  Name :"+res.getString(1) + "\n");
                            buffer.append("     Score :"+ res.getString(2) + "\n");
                            buffer.append("     Time :"+res.getString(3) + "\n");

                            buffer.append("\n");
                            cont++;
                        }

                        // MUESTRA NOMBRES CON PUNTUACIONES
                        showMessage("                    TOP SCORES              ", buffer.toString());
                    }
                }
        );
    }

    @Override
    public void onBackPressed() {
        //Impedimos que se pueda salir de la ventana al pulsar el botón de atrás del movil
    }

    public void showMessage(String title, String Message) {
        android.app.AlertDialog.Builder builder = new AlertDialog.Builder(this,R.style.AlertDialogCustom);
        builder.setCancelable(true);
        builder.setTitle(title);
        builder.setMessage(Message);
        AlertDialog dialog = builder.create();
        dialog.show();
        dialog.getWindow().setBackgroundDrawableResource(R.drawable.dark);
    }




    public void onClick (View v){
            if (v.getId() == R.id.botSalir) {
                StartGame.ventanaInicio.finish();
                Alert.ventanaNombre.finish();
                finish();

            } else {
                Intent goToMain = new Intent(this, StartGame.class);
                startActivity(goToMain);
                finish();
            }
        }
    }


