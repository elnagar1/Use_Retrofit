package com.example.news.ui.main;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import com.example.news.R;

public class MainActivity extends AppCompatActivity {

    private MainActivityViewModel mainActivityViewModel ;


    @Override
    protected void onResume() {
        super.onResume();
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

         final TextView textView = findViewById(R.id.tv);
        Button button = findViewById(R.id.button);
        mainActivityViewModel = ViewModelProviders.of( this).get(MainActivityViewModel .class);


        mainActivityViewModel.mutableLiveData.observe(this, new Observer<String>() {
            @Override
            public void onChanged(String s) {
                Log.e("ssssssssssssssss0", "successfully");
                textView.setText(s);
            }
        });

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.e("ssssssssssssssss1", "successfully");
                mainActivityViewModel.getNews();
                Log.e("ssssssssssssssss2", "successfully");
            }
        });







    }



}
