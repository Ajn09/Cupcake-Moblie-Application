package com.example.sprinkles_cupcake_shop;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import com.example.namespace.R;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

public class CupcakesActivity extends AppCompatActivity {
    Button buttonBirthday, buttonMothersday, buttonBridal, buttonBaby, buttonFarewell, buttonGraduation, buttonWedding, buttonValentine, buttonAnniversary, buttonChristmas;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cupcakes);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        buttonAnniversary = findViewById(R.id.btnCupcakeAnniversary);
        buttonAnniversary.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(CupcakesActivity.this, AnniversaryDayActivity.class));
            }
        });

        buttonBaby = findViewById(R.id.btnCupcakeBaby);
        buttonBaby.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(CupcakesActivity.this, BabyShowerActivity.class));
            }
        });

        buttonBirthday = findViewById(R.id.btnCupcakeBirthday);
        buttonBirthday.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(CupcakesActivity.this, BirthdayActivity.class));
            }
        });

        buttonBridal = findViewById(R.id.btnCupcakeBridal);
        buttonBridal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(CupcakesActivity.this, BridalShowerActivity.class));
            }
        });

        buttonChristmas = findViewById(R.id.btnCupcakeChristmas);
        buttonChristmas.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(CupcakesActivity.this, ChristmasDayActivity.class));
            }
        });

        buttonFarewell = findViewById(R.id.btnCupcakeFarewell);
        buttonFarewell.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(CupcakesActivity.this, FarewellDayActivity.class));
            }
        });

        buttonGraduation = findViewById(R.id.btnCupcakeGraduation);
        buttonGraduation.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(CupcakesActivity.this, GraduationDayActivity.class));
            }
        });

        buttonMothersday = findViewById(R.id.btnCupcakeMother);
        buttonMothersday.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(CupcakesActivity.this, MothersDayActivity.class));
            }
        });

        buttonValentine = findViewById(R.id.btnCupcakeValentine);
        buttonValentine.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(CupcakesActivity.this, ValentinesDayActivity.class));
            }
        });

        buttonWedding = findViewById(R.id.btnCupcakeWedding);
        buttonWedding.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(CupcakesActivity.this, WeddingDayActivity.class));
            }
        });
    }
}
