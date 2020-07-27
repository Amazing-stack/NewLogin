package com.example.newlogin;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ProgressBar;

import com.github.ybq.android.spinkit.sprite.Sprite;
import com.github.ybq.android.spinkit.style.DoubleBounce;
import com.github.ybq.android.spinkit.style.WanderingCubes;
import com.github.ybq.android.spinkit.style.Wave;

public class Splashscreen extends AppCompatActivity {
Button signup, signin;
    Animation uptodown,downtoup;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splashscreen);

       signup = findViewById(R.id.textsignup);
     signin = findViewById(R.id.textsignin);
        ProgressBar progressBar = findViewById(R.id.spin_kit);

        uptodown = AnimationUtils.loadAnimation(this,R.anim.uptodown);
        downtoup = AnimationUtils.loadAnimation(this,R.anim.downtoup);
       signup.setAnimation(uptodown);
        signin.setAnimation(downtoup);

        MediaPlayer mediaPlayer= MediaPlayer.create(Splashscreen.this,R.raw.policesirensound);
        mediaPlayer.start();

        signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Splashscreen.this, RegisterActivity.class));
            }
        });

       signin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Splashscreen.this, MainActivity.class));
            }
        });


        Sprite wave = new Wave();
        progressBar.setIndeterminateDrawable(wave);


    }
}