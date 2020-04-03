package com.example.actividad2;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorManager;
import android.media.MediaPlayer;
import android.os.Vibrator;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public class MainActivity extends AppCompatActivity{

    ImageView imagen;
    TextView letrero;
    Button btn;
    MediaPlayer mp;
    Vibrator vibrator;
    SensorManager sm;
    Sensor sen;
    Random ramdon = new Random(System.currentTimeMillis());

    //Patron de vibracion
    long[] pattern0 = {0,ramdon.nextInt(1000)+1,ramdon.nextInt(1000)+1,ramdon.nextInt(1000)+1,ramdon.nextInt(1000)+1,ramdon.nextInt(1000)+1,ramdon.nextInt(1000)+1};
    long[] pattern1 = {0,ramdon.nextInt(1000)+1,ramdon.nextInt(1000)+1,ramdon.nextInt(1000)+1,ramdon.nextInt(1000)+1,ramdon.nextInt(1000)+1,ramdon.nextInt(1000)+1};
    long[] pattern2 = {0,ramdon.nextInt(1000)+1,ramdon.nextInt(1000)+1,ramdon.nextInt(1000)+1,ramdon.nextInt(1000)+1,ramdon.nextInt(1000)+1,ramdon.nextInt(1000)+1};
    long[] pattern3 = {0,ramdon.nextInt(1000)+1,ramdon.nextInt(1000)+1,ramdon.nextInt(1000)+1,ramdon.nextInt(1000)+1,ramdon.nextInt(1000)+1,ramdon.nextInt(1000)+1};
    long[] pattern4 = {0,ramdon.nextInt(1000)+1,ramdon.nextInt(1000)+1,ramdon.nextInt(1000)+1,ramdon.nextInt(1000)+1,ramdon.nextInt(1000)+1,ramdon.nextInt(1000)+1};
    long[] pattern5 = {0,ramdon.nextInt(1000)+1,ramdon.nextInt(1000)+1,ramdon.nextInt(1000)+1,ramdon.nextInt(1000)+1,ramdon.nextInt(1000)+1,ramdon.nextInt(1000)+1};
    long[] pattern6 = {0,ramdon.nextInt(1000)+1,ramdon.nextInt(1000)+1,ramdon.nextInt(1000)+1,ramdon.nextInt(1000)+1,ramdon.nextInt(1000)+1,ramdon.nextInt(1000)+1};

    int sr = 0, temp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //asociando atributos, id, layout
        imagen = findViewById(R.id.imageView);
        letrero = findViewById(R.id.texto);
        btn = findViewById(R.id.button);

        mostrarRand();

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                temp = sr;
                mostrarRand();
            }
        });
    }

    //mostrar valores de aleatorio

    public void mostrarRand(){

        sr = ThreadLocalRandom.current().nextInt(0,7);

        while(sr == temp){
            sr = ThreadLocalRandom.current().nextInt(0,7);
        }

        imagen.setImageResource(randArray[sr].getImagen());
        letrero.setText(randArray[sr].getAleatorio());

        //generar patron de vibracion
        vibrator = (Vibrator) getSystemService(Context.VIBRATOR_SERVICE);
        vibrator.vibrate(randArray[sr].getPattern(), 0);
        stopPlying();

        mp = MediaPlayer.create(this,randArray[sr].getSonido());
        mp.start();
        mp.setLooping(true);
    }

    aleatorio i1 = new aleatorio(R.drawable.uno, "img 1", R.raw.sound1, pattern0);
    aleatorio i2 = new aleatorio(R.drawable.dos, "img 2", R.raw.sound2, pattern1);
    aleatorio i3 = new aleatorio(R.drawable.tres, "img 3", R.raw.sound3, pattern2);
    aleatorio i4 = new aleatorio(R.drawable.cuatro, "img 4", R.raw.sound4, pattern3);
    aleatorio i5 = new aleatorio(R.drawable.cinco, "img 5", R.raw.sound5, pattern4);
    aleatorio i6 = new aleatorio(R.drawable.seis, "img 6", R.raw.sound6, pattern5);
    aleatorio i7 = new aleatorio(R.drawable.siete, "img 7", R.raw.sound7, pattern6);
    //llenando array
    aleatorio[] randArray = new aleatorio[]{
            i1, i2, i3, i4, i5, i6, i7
    };

    private void stopPlying(){
        if(mp != null){
            mp.stop();
            mp.release();
            mp = null;
        }
    }
}
