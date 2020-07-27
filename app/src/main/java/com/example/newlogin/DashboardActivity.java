package com.example.newlogin;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ProgressBar;

import com.github.ybq.android.spinkit.sprite.Sprite;
import com.github.ybq.android.spinkit.style.ChasingDots;
import com.github.ybq.android.spinkit.style.WanderingCubes;

import java.util.List;

public class DashboardActivity extends AppCompatActivity {
    CardView create, manage;
    private List<CourseCard> courseCards;
    ProgressBar progressBar;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);
        create = findViewById(R.id.createreport);
       manage = findViewById(R.id.myprofile);
       progressBar = findViewById(R.id.spin_kit);

        Sprite chasingDots = new ChasingDots();
        progressBar.setIndeterminateDrawable(chasingDots);

       progressBar.setVisibility(View.VISIBLE);
        create.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(DashboardActivity.this, Complainant_form.class));
                progressBar.setVisibility(View.GONE);
            }
        });



        progressBar.setVisibility(View.VISIBLE);
       manage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(DashboardActivity.this, MyprofileActivity.class));
                progressBar.setVisibility(View.GONE);
            }
        });

    }



    }



