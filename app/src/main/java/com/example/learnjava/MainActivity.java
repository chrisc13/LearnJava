package com.example.learnjava;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    private Button poly_button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        poly_button = (Button) findViewById(R.id.poly_button);
        poly_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openPolyView();
            }
        });
    }

    public void openPolyView(){
        Intent intent = new Intent(this, PolyActivity.class);
        startActivity(intent);

    }




}
