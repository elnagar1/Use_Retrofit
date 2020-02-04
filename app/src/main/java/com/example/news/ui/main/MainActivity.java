package com.example.news.ui.main;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import androidx.appcompat.app.AppCompatActivity;
import com.example.news.R;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    Intent intent;
     final Context context = this;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ImageView HIMIT = findViewById(R.id.HIMIT);
        ImageView health= findViewById(R.id.health);
        ImageView sports = findViewById(R.id.sport);
        ImageView entertainment = findViewById(R.id.entertainment);
        ImageView technology = findViewById(R.id.technology);
        ImageView business = findViewById(R.id.business);
        ImageView science = findViewById(R.id.science);

        HIMIT.setOnClickListener(this);
        health.setOnClickListener(this);
        sports.setOnClickListener(this);
        entertainment.setOnClickListener(this);
        technology.setOnClickListener(this);
        business.setOnClickListener(this);
        science.setOnClickListener(this);
        intent=new Intent(this,NewsActivity.class);
    }

    @Override
    public void onClick(View v) {
        if (v instanceof ImageView) {

                intent.putExtra("category",v.getId());
                context.startActivity(intent);
            }


        }
    }

