package com.example.newlogin;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ProgressBar;

import com.github.ybq.android.spinkit.sprite.Sprite;
import com.github.ybq.android.spinkit.style.ChasingDots;


public class DashboardActivity extends AppCompatActivity {
    CardView create, manage,view_repo;
    ProgressBar progressBar;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);
        create = findViewById(R.id.createreport);
       manage = findViewById(R.id.myprofile);
        view_repo = findViewById(R.id.view);
       progressBar = findViewById(R.id.spin_kit);


        Sprite chasingDots = new ChasingDots();
        progressBar.setIndeterminateDrawable(chasingDots);


        create.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                progressBar.setVisibility(View.VISIBLE);
                startActivity(new Intent(DashboardActivity.this, Stepper_TabActivity.class));
                progressBar.setVisibility(View.GONE);
            }
        });




       manage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                progressBar.setVisibility(View.VISIBLE);
                startActivity(new Intent(DashboardActivity.this, MyprofileActivity.class));
                progressBar.setVisibility(View.GONE);
            }
        });

        view_repo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                progressBar.setVisibility(View.VISIBLE);
                startActivity(new Intent(DashboardActivity.this, View_report.class));
                progressBar.setVisibility(View.GONE);
            }
        });

    }



    }



