package com.example.finalapps;

import androidx.appcompat.app.AppCompatActivity;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivityMusica extends AppCompatActivity {

    Button play_pause;
    MediaPlayer mp;
    int posicion = 0;
    MediaPlayer vectormp [] = new MediaPlayer[3];

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_musica);

        play_pause = (Button) findViewById(R.id.btn_play);
        vectormp[0] = MediaPlayer.create(this, R.raw.kali_uchis_telepatia);
        vectormp[1] = MediaPlayer.create(this, R.raw.the_neighbourhood_daddy_issues);
        vectormp[2] = MediaPlayer.create(this, R.raw.mark_ronson_miley_cyrus_nothing_breaks_like_a_heart);
    }

    // Boton para reproducir la canción
    public void playPause(View view) {
        if (vectormp[posicion].isPlaying()) {
            vectormp[posicion].pause();
            play_pause.setBackgroundResource(R.drawable.play);
            Toast.makeText(this, "Pausa", Toast.LENGTH_SHORT).show();
        } else {
            vectormp[posicion].start();
            play_pause.setBackgroundResource(R.drawable.pausa);
            Toast.makeText(this, "Play", Toast.LENGTH_SHORT).show();
        }
    }

    // Boton para ir a la siguiente canción
    public void siguiente(View view) {
        if (posicion < vectormp.length - 1) {

            if (vectormp[posicion].isPlaying()) {
                vectormp[posicion].stop();
                posicion++;
                vectormp[posicion].start();
            } else {
                posicion++;
            }

        } else {
            Toast.makeText(this, "No hay más canciones", Toast.LENGTH_SHORT).show();
        }
    }

    // Boton para ir a la anterior canción
    public void atras(View view) {
        if (posicion >= 1) {

            if (vectormp[posicion].isPlaying()) {
                vectormp[posicion].stop();
                vectormp[0] = MediaPlayer.create(this, R.raw.kali_uchis_telepatia);
                vectormp[1] = MediaPlayer.create(this, R.raw.the_neighbourhood_daddy_issues);
                vectormp[2] = MediaPlayer.create(this, R.raw.mark_ronson_miley_cyrus_nothing_breaks_like_a_heart);
                posicion--;

                vectormp[posicion].start();

            } else {
                posicion--;
            }

        } else {
            Toast.makeText(this, "No hay más canciones", Toast.LENGTH_SHORT).show();
        }
    }
}