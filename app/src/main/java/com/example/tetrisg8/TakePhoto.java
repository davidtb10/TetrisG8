package com.example.tetrisg8;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.ImageView;


public class TakePhoto extends AppCompatActivity {
    private FuncionamientoJuego start;
    int puntuacion;
    int tiempo;
    ImageView fotoUusario;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.click_photo);
        fotoUusario=(ImageView)findViewById(R.id.fotoUsuario);
        //Para poder cerrar el activity desde otra ventana
        puntuacion = getIntent().getExtras().getInt("puntuacion");
        //Mostramos la puntuación
        tiempo = getIntent().getExtras().getInt("tiempo");
    }

    public void foto(View view) {
        Intent intentCamara=new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        startActivityForResult(intentCamara,123);
        /*Intent goToMain = new Intent(this, GameOverActivity.class);
        goToMain.putExtra("puntuacion", puntuacion);
        goToMain.putExtra("tiempo", tiempo);
        startActivity(goToMain);
        finish();*/

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode==123 && resultCode==RESULT_OK){
            Bundle datosRec=data.getExtras();
            Bitmap imagen= (Bitmap) datosRec.get("data");
            fotoUusario.setImageBitmap(imagen);
        }
    }
}
